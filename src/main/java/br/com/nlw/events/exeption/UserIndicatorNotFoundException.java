package br.com.nlw.events.exeption;

public class UserIndicatorNotFoundException extends RuntimeException{
	public UserIndicatorNotFoundException(String msg) {
		super(msg);
	}
}
