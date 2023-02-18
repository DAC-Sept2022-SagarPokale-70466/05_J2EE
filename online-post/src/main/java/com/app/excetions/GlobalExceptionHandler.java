/**
*	@Developer : Sagar_Pokale
*	@Date		 	   : 27-Dec-2022 4:29:44 PM
*/

package com.app.excetions;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.ResourceClosedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.payloads.ApiResponce;

@RestControllerAdvice // Global exception handler
public class GlobalExceptionHandler {

	private String defaultMessage;

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponce apiResponce = new ApiResponce(message, false);
		return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> resp = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String field = ((FieldError) error).getField();
			defaultMessage = error.getDefaultMessage();
			resp.put(field, defaultMessage);
		});
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiResponce> handlerApiException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponce apiResponce = new ApiResponce(message, true);
		return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.BAD_REQUEST);
	}
}
