package es.grupo12.model;

import java.time.LocalDateTime;

public class CustomErrorJson {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String trace;
    private String message;
    private String path;

    public CustomErrorJson(LocalDateTime timestamp, int status, String error, String trace, String message,
            String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.trace = trace;
        this.message = message;
        this.path = path;
    }

    // Getters
    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public String getTrace() {
        return trace;
    }

    // Setters
    public void setStatus(int status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    
}
