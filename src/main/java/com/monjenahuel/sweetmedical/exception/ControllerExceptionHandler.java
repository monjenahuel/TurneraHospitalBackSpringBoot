package com.monjenahuel.sweetmedical.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private Map<String,Object> response = new HashMap<>();

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException ex){
        response.clear();
        response.put("error",ex.getMessage());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<?> alreadyExistException(AlreadyExistException ex){
        response.clear();
        response.put("error",ex.getMessage());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<?> InvalidCredentialsException(InvalidCredentialsException ex){
        response.clear();
        response.put("error",ex.getMessage());

        return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {


        response.clear();
        List<String> errores = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField().concat(": ").concat(error.getDefaultMessage()))
                .collect(Collectors.toList());

        response.put("Errores", errores);

        return new ResponseEntity<>(response,null,HttpStatus.BAD_REQUEST);
    }



}
