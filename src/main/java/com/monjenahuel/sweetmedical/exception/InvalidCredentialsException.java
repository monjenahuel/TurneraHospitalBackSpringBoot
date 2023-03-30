package com.monjenahuel.sweetmedical.exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String mensaje){
        super(mensaje);
    }
}
