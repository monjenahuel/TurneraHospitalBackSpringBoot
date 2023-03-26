package com.monjenahuel.sweetmedical.exepction;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(String mensaje){
        super(mensaje);
    }
}
