class AudioMessage implements IMessage {
    private final String audioURL;
    private final User sender;
    private final LocalDateTime timestamp;

    public AudioMessage(String audioURL, User sender) {
        this.audioURL = audioURL;
        this.sender = sender;
        this.timestamp = LocalDateTime.now();
    }

    public String getContent() { return "[Audio] " + audioURL; }
    public User getSender() { return sender; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getType() { return "Audio"; }
}