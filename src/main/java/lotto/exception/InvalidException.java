package lotto.exception;

public class InvalidException extends IllegalArgumentException{
    private final static String prefix = "[ERROR] ";
    public InvalidException(String message){
        super(prefix+message);
    }
}
