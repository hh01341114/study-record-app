package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Dto.ErrorResponse;

/**
 * 例外用ハンドラー
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 404エラー
     * @param ex
     * @return
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), 404));
    }
    /**
     * 403エラー
     * @param ex
     * @return
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleForbidden(ResourceNotFoundException ex) {
    	return ResponseEntity
    			.status(HttpStatus.FORBIDDEN)
    			.body(new ErrorResponse(ex.getMessage(), 404));
    }
    
    /**
     * 予期しないエラー
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("予期しないエラーが発生しました", 500));
    }
}