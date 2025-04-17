import java.util.*;

public class Chat {
    private final User user1;
    private final User user2;
    private final List<IMessage> messages = new ArrayList<>();

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public boolean hasUser(User user) {
        return user.equals(user1) || user.equals(user2);
    }

    public void addMessage(IMessage message) {
        messages.add(message);
    }

    public List<IMessage> getMessages() {
        return messages;
    }

    public void printChat(User currentUser) {
        System.out.println("\n--- Conversation with " + (currentUser.equals(user1) ? user2.getName() : user1.getName()) + " ---");
        for (IMessage msg : messages) {
            System.out.println((msg.getSender().equals(currentUser) ? "You" : msg.getSender().getName()) + ": " + msg.getContent() + " (" + msg.getTimestamp() + ")");
        }
        System.out.println("--------------------------\n");
    }
}
