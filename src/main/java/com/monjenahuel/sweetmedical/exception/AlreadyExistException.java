package com.monjenahuel.sweetmedical.exception;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String mensaje){
        super(mensaje);
    }
}
