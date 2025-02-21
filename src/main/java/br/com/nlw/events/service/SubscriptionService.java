package br.com.nlw.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nlw.events.dto.SubscriptionResponse;
import br.com.nlw.events.exeption.EventNotFoundException;
import br.com.nlw.events.exeption.SubscriptionConflictException;
import br.com.nlw.events.exeption.UserIndicatorNotFoundException;
import br.com.nlw.events.model.Event;
import br.com.nlw.events.model.Subscription;
import br.com.nlw.events.model.User;
import br.com.nlw.events.repo.EventRepo;
import br.com.nlw.events.repo.SubscriptionRepo;
import br.com.nlw.events.repo.UserRepo;

@Service
public class SubscriptionService {
	//manipular os dados do envento
	@Autowired
	private EventRepo evtRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SubscriptionRepo subRepo;
	
	public SubscriptionResponse createNewSubscription(String eventName, User user, Integer userId) {
		//recuperar evento pelo nome
		Event evt = evtRepo.findByPrettyName(eventName);
		if(evt == null) { //caso alternativo 2
			throw new EventNotFoundException("Evento "+eventName+" não existe");
		}
		
		User userRec = userRepo.findByEmail(user.getEmail());
		
		System.out.println("\n ####old user: " + userRec);
		
		if(userRec == null) { // caso alternativo 1
			//grava usuário no banco e o resultado sobrescreve em cima do parametro
			userRec = userRepo.save(user);	
			System.out.println("\n ####new user: " + userRec);
		}
		
		// findById já vem pronto do crudreposiotry
		User indicador = userRepo.findById(userId).orElse(null);
		if(indicador == null) {
			throw new UserIndicatorNotFoundException("Usuário "+userId+" indicador não existe");
		}
		
	  //montando o obj de inscrição
		Subscription subs = new Subscription();
		subs.setEvent(evt); //o evento recuperado na inscrição
		subs.setSubscriber(userRec); //stribuir o usurio   como sendo o assinante
		subs.setIndication(indicador);
		
		System.out.println("\n ####Event obj: " + userRec);
		
		Subscription tmpSub = subRepo.findByEventAndSubscriber(evt, userRec);
		System.out.println("\n ####tmpSub: " + tmpSub);
		if(tmpSub != null) { // caso alternativo 3
			throw new SubscriptionConflictException("Já existe inscrição para o usuário "+userRec.getName()+" no evento "+evt.getTitle());
		}
		
		//montou o obj de evento
		Subscription res = subRepo.save(subs);
//		return res;
		return  new SubscriptionResponse(res.getSubscriptionNumber(), "http://codecraft.com/subscription/"+res.getEvent().getPrettyName()+"/"+res.getSubscriber().getId());
	}
}

























