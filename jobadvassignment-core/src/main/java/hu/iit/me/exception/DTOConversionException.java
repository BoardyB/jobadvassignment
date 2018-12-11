package hu.iit.me.exception;

public class DTOConversionException extends RuntimeException {

    public DTOConversionException(String message) {
        super(message);
    }

    public DTOConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}
