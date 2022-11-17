package clickortime;

public class MailEvent {
    private String message;
    private String email;

    public MailEvent(String message) {
        this.message = message;
    }

    public MailEvent(String message, String email) {
        this.message = message;
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "MailEvent{" +
                "message='" + message + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
