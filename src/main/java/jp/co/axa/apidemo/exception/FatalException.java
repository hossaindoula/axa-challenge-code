package jp.co.axa.apidemo.exception;

public class FatalException extends Exception{

    public FatalException(String errorMessage){
        super(errorMessage);
    }

    public FatalException(String errorMessage, Throwable cause){
        super(errorMessage, cause);
    }
    
}
