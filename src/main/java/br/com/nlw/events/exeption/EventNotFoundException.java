package br.com.nlw.events.exeption;

public class EventNotFoundException extends RuntimeException{
	//consrtutor obrigatório
	public EventNotFoundException(String msg) {
		//invocar construtor da classe runtime
		super(msg);
	}
}
