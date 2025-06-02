package pl.aka.os.test.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GeneralAppException extends RuntimeException {
    private final HttpStatus status;

    public GeneralAppException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}