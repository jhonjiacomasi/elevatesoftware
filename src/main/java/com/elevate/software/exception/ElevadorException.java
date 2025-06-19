package com.elevate.software.exception;

public class ElevadorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ElevadorException(String mensagem) {
		super(mensagem);
	}
}
