package ru.conus.books.core.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

    private final HttpStatus status;

    public BusinessException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "status=" + status +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}
