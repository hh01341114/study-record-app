package com.example.Dto;

/**
 * エラーレスポンスDTO
 */
public class ErrorResponse {
	
	private String message;
	private int status;
	
	//コンストラクタ
	public ErrorResponse(String message, int status) {
		this.message = message;
		this.status = status;
	}
	
	public String getMassege() { return message; }
	public int getStatus() { return status; }
}