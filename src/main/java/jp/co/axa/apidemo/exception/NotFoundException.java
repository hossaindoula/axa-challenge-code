package jp.co.axa.apidemo.exception;

public class NotFoundException extends Exception{

    public NotFoundException(String errorMessage){
        super(errorMessage);
    }

    public NotFoundException(String errorMessage, Throwable cause){
        super(errorMessage, cause);
    }
    
}
