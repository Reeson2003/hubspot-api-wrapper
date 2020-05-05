package ru.reeson2003.hubspotapi.v3;

public class ApiCallException extends RuntimeException {

    public ApiCallException(String message) {
        super(message);
    }

    public ApiCallException(Throwable cause) {
        super(cause);
    }
}
