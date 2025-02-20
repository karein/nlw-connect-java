package br.com.nlw.events.exeption;

public class SubscriptionConflictException extends RuntimeException{
	public SubscriptionConflictException(String msg) {
		super(msg);
	}
}
