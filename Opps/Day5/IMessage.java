import java.time.LocalDateTime;

public interface IMessage {
    String getContent();
    User getSender();
    LocalDateTime getTimestamp();
}
