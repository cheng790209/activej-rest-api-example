package models;

public class Info {
    private String message, author;
    private String[] availableEndpoints;

    public Info(String message, String[] availableEndpoints, String author) {
        this.message = message;
        this.availableEndpoints = availableEndpoints;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getAvailableEndpoints() {
        return availableEndpoints;
    }

    public void setAvailableEndpoints(String[] availableEndpoints) {
        this.availableEndpoints = availableEndpoints;
    }
}
