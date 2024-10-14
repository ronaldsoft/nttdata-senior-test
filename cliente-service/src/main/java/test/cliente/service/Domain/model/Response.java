
package test.cliente.service.Domain.model;

import java.util.Optional;

public class Response<T> {

    private int status;
    private String message;
    private Optional<T> data; // Usamos Optional para hacer que sea opcional

    // Constructor
    public Response(int status, String message, Optional<T> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getters y setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Optional<T> getData() {
        return data;
    }

    public void setData(Optional<T> data) {
        this.data = data;
    }
}