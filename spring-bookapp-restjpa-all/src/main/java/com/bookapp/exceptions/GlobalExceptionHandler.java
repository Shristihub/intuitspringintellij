package com.bookapp.exceptions;

import com.bookapp.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error =ex.getMessage();
        String message = "Request Method not supported"; //custom
        headers.add("info","Request Method not supported");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),message,error,HttpStatus.METHOD_NOT_ALLOWED);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error =ex.getMessage();
        String message = "Media type not supported";
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),message,error,HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).headers(headers).body(apiErrors);
    }

    @Override
     protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error =ex.getMessage();
        String message = "Path Variable is missing";
        headers.add("info","Missing Path Variable");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),message,error,HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error =ex.getMessage();
        String message = "Servlet Request Parameter is missing";
        headers.add("info","Missing Path Variable");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),message,error,HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error =ex.getMessage();
        String message = "Mismatch of data types";
        headers.add("info","Wrong datatype passed");
        ApiErrors apiErrors = new ApiErrors(LocalDateTime.now(),message,error,HttpStatus.NOT_IMPLEMENTED);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).headers(headers).body(apiErrors);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ApiErrors> handleBookException(BookNotFoundException e){
        String error =e.getMessage();
        String message = "Book not found for this id";

        ApiErrors apiErrors =
                new ApiErrors(LocalDateTime.now(),message,error, HttpStatus.NOT_ACCEPTABLE);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(apiErrors);

    }



}
