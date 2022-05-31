package com.mec.dnaVerifier.exception;

import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value = InvalidNitrogenousBaseException.class)
	public ResponseEntity<?> invalidNitrogenousBaseException(HttpServletRequest request, InvalidNitrogenousBaseException exception) {
		ErrorInfo errorInfo = new ErrorInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = NotReachMinimumLengthException.class)
	public ResponseEntity<?> notReachMinimumLengthException(HttpServletRequest request,
															NotReachMinimumLengthException exception) {
		ErrorInfo errorInfo = new ErrorInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = RoleNotFoundException.class)
	public ResponseEntity<?> roleNotFoundException(HttpServletRequest request,
												   RoleNotFoundException exception) {
		ErrorInfo errorInfo = new ErrorInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = NotSquareArrayException.class)
	public ResponseEntity<?> notSquareArrayException(HttpServletRequest request,
													 NotSquareArrayException exception) {
		ErrorInfo errorInfo = new ErrorInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<?> userNotFoundException(HttpServletRequest request,
												   UserNotFoundException exception) {
		ErrorInfo errorInfo = new ErrorInfo(exception.getMessage(), HttpStatus.BAD_REQUEST.value(),
				request.getRequestURI());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
	}

@ExceptionHandler(value = HttpMessageNotReadableException.class)
public ResponseEntity<?> httpMessageNotReadableException(HttpServletRequest request,
											   HttpMessageNotReadableException exception) {
	ErrorInfo errorInfo = new ErrorInfo(exception.getMessage().substring(0, 16), HttpStatus.BAD_REQUEST.value(),
			request.getRequestURI());
	return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
}
}
