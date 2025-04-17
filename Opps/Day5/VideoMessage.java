class VideoMessage implements IMessage {
    private final String videoURL;
    private final User sender;
    private final LocalDateTime timestamp;

    public VideoMessage(String videoURL, User sender) {
        this.videoURL = videoURL;
        this.timestamp = LocalDateTime.now();
        this.sender = sender;
    }

    public String getContent() { return "[Video] " + videoURL; }
    public User getSender() { return sender; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getType() { return "Video"; }
}