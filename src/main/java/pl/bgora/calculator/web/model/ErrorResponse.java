package pl.bgora.calculator.web.model;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private int status;
    private String error;

    public ErrorResponse(HttpStatus status, String error) {
        this.status = status.value();
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
