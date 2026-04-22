package com.example.exception;

/**
 * 404例外処理クラス
 */
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}