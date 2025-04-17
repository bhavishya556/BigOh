import java.util.*;

public class User {
    private final String name;
    private final List<Chat> chats = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addChat(Chat chat) {
        if (!chats.contains(chat)) {
            chats.add(chat);
        }
    }

    public List<Chat> getChats() {
        return chats;
    }

    public Optional<Chat> getChatWith(User other) {
        return chats.stream()
                .filter(chat -> chat.hasUser(other))
                .findFirst();
    }

    public Chat getOrCreateChatWith(User other) {
        return getChatWith(other).orElseGet(() -> {
            Chat newChat = new Chat(this, other);
            this.addChat(newChat);
            other.addChat(newChat);
            return newChat;
        });
    }
}
