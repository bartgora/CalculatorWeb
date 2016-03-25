package pl.bgora.calculator.web.model;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private int code;
    private String message;

    public ErrorResponse(HttpStatus status, String message) {
        this.code = status.value();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
