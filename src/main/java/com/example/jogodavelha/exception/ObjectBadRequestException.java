package com.example.jogodavelha.exception;

public class ObjectBadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
		public ObjectBadRequestException(String msg) {
			super(msg);
		}
		
		public ObjectBadRequestException(String msg,Throwable cause) {
			super(msg,cause);
		}

}
