package com.electioncommision.ivc.exceptionhandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.electioncommision.ivc.util.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new HashMap<String, String>();
		for (ObjectError objectError : errors) {
			FieldError error = (FieldError) objectError;
			String name = error.getField();
			String message = error.getDefaultMessage();
			map.put(name, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFound(IdNotFoundException ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Id  Not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PhoneNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handlePhoneNotFound(PhoneNotFound ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Voter Not Found with given phone no.");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handleEmailNotFound(EmailNotFound ex) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setData("Voter Not Found with given email.");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(NoDataAvailable.class)
	public ResponseEntity<ResponseStructure<String>> handleNoDataAvailable(NoDataAvailable ex){
		ResponseStructure<String> structure= new ResponseStructure<String>();
		structure.setData("No Data Available.");
		structure.setStatus(HttpStatus.NO_CONTENT.value());
		structure.setMessage(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<ResponseStructure<String>> handleDuplicateEntryException(DuplicateEntryException ex){
		ResponseStructure<String> structure= new ResponseStructure<String>();
		structure.setData("Voter is Already registered.");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
}
