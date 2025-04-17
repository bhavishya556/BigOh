import java.time.LocalDateTime;

public class TextMessage implements IMessage {
    private final String content;
    private final User sender;
    private final LocalDateTime timestamp;

    public TextMessage(String content, User sender) {
        this.content = content;
        this.sender = sender;
        this.timestamp = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public User getSender() {
        return sender;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
