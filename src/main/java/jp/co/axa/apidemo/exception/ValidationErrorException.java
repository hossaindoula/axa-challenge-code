package jp.co.axa.apidemo.exception;

public class ValidationErrorException extends Exception{

    public ValidationErrorException(String errorMessage){
        super(errorMessage);
    }

    public ValidationErrorException(String errorMessage, Throwable cause){
        super(errorMessage, cause);
    }
    
}
