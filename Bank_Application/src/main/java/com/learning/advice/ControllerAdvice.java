package com.learning.advice;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.exception.FoodNotFoundException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.NameAlreadyExistsException;
import com.learning.exception.NoDataFoundException;
import com.learning.exception.apierror.ApiError;

@org.springframework.web.bind.annotation.ControllerAdvice 
// will handle all exceptions which are thrown by the controller/restcontroller using throws

public class ControllerAdvice extends ResponseEntityExceptionHandler{
//public class ControllerAdvice implements AuthenticationEntryPoint{
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);
	
	@ExceptionHandler(NoDataFoundException.class) // this is responsible for handling NameAlreadyExistsException.
	public ResponseEntity<?> NoDataFoundException(NoDataFoundException e){
		// Map<String, String> map = new HashMap<>();
		// map.put("message", "no data found");
		// System.out.println(e);
		// no content used for delete
		// not found used for here get method
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,e.getMessage(),e);
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(NameAlreadyExistsException.class) // this is responsible for handling NameAlreadyExistsException.
	public ResponseEntity<?> NameAlreadyExistsException(NameAlreadyExistsException e){
		Map<String, String> map = new HashMap<>();
		map.put("message", "name already exists");
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,"name already Exists",e);
		return ResponseEntity.badRequest().body(map);
	}
	
	@Override
	// @ExceptionHandler(MethodArgumentNotValidException.class)
	// work for @Valid annotation only (Post method)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
		//ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		ApiError apiError = new ApiError(status);
		apiError.setMessage("Validation Error");
		apiError.addValidationErrors(ex.getFieldErrors());
		apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
		return buildResponseEntity(apiError);
	}
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<Object>(apiError,apiError.getHttpStatus());
	}
	
	// will work for path transform to the argument
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	private ResponseEntity<?> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(e.getMessage());
		apiError.setDebugMessage(e.getRequiredType().getName());
		return buildResponseEntity(apiError);
	}
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> IdNotFoundException(IdNotFoundException e){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Supplied ID not found", e);
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<?> handleMethodConstraintViolationException(ConstraintViolationException e){
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(e.getMessage());
		return buildResponseEntity(apiError);
	}
	
	
	@ExceptionHandler(FoodNotFoundException.class)
	public ResponseEntity<?> foodNotFoundException(FoodNotFoundException e){
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage(e.getMessage());
		return buildResponseEntity(apiError);
	}
	
	
}
