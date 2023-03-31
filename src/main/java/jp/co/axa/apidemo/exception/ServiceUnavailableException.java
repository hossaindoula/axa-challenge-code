package jp.co.axa.apidemo.exception;

public class ServiceUnavailableException extends Exception{

    public ServiceUnavailableException(String errorMessage){
        super(errorMessage);
    }

    public ServiceUnavailableException(String errorMessage, Throwable cause){
        super(errorMessage, cause);
    }
    
}
