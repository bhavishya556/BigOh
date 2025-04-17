import java.util.*;

public class ChatManager {
    private static ChatManager instance;
    private final Map<String, User> users = new HashMap<>();

    private ChatManager() {}

    public static ChatManager getInstance() {
        if (instance == null) {
            instance = new ChatManager();
        }
        return instance;
    }

    public User createUser(String name) {
        User user = new User(name);
        users.put(name, user);
        return user;
    }

    public User getUser(String name) {
        return users.get(name);
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }

    public boolean userExists(String name) {
        return users.containsKey(name);
    }
}
