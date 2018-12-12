package hu.iit.me.exception;

public class InvalidSearchFiltersException extends RuntimeException {

    public InvalidSearchFiltersException() {
        super();
    }

    public InvalidSearchFiltersException(String message) {
        super(message);
    }

    public InvalidSearchFiltersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSearchFiltersException(Throwable cause) {
        super(cause);
    }

    protected InvalidSearchFiltersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
