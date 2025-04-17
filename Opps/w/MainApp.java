import java.time.LocalDateTime;
import java.util.*;

// ---------- IMessage Interface and Message Types ----------
interface IMessage {
    String getContent();
    User getSender();
    LocalDateTime getTimestamp();
    String getType();
}

class TextMessage implements IMessage {
    private final String content;
    private final User sender;
    private final LocalDateTime timestamp;

    public TextMessage(String content, User sender) {
        this.content = content;
        this.sender = sender;
        this.timestamp = LocalDateTime.now();
    }

    public String getContent() { return content; }
    public User getSender() { return sender; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getType() { return "Text"; }
}

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

// ---------- Chat Class ----------
class Chat {
    private final User user1;
    private final User user2;
    private final List<IMessage> messages = new ArrayList<>();

    public Chat(User u1, User u2) {
        this.user1 = u1;
        this.user2 = u2;
    }

    public User getUser1() { return user1; }
    public User getUser2() { return user2; }

    public void addMessage(IMessage msg) {
        messages.add(msg);
    }

    public List<IMessage> getMessages() {
        return messages;
    }

    public User getOtherUser(User current) {
        return current.equals(user1) ? user2 : user1;
    }
}

// ---------- User Class ----------
class User {
    private final String name;
    private final String phoneNumber;
    private final List<Chat> chats = new ArrayList<>();

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }

    public void addChat(Chat chat) {
        chats.add(chat);
    }

    public List<Chat> getChats() { return chats; }

    public Chat findChatWith(User other) {
        for (Chat chat : chats) {
            if (chat.getOtherUser(this).equals(other)) {
                return chat;
            }
        }
        Chat newChat = new Chat(this, other);
        this.addChat(newChat);
        other.addChat(newChat);
        return newChat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User other) {
            return this.phoneNumber.equals(other.phoneNumber);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }
}

// ---------- Chat Manager ----------
class ChatManager {
    private final Map<String, User> userMap = new HashMap<>();

    public User registerUser(String name, String phone) {
        if (userMap.containsKey(phone)) {
            System.out.println("User already exists!");
            return userMap.get(phone);
        }
        User user = new User(name, phone);
        userMap.put(phone, user);
        return user;
    }

    public User login(String phone) {
        return userMap.get(phone);
    }

    public List<User> getAllUsersExcept(User u) {
        return userMap.values().stream()
                .filter(user -> !user.equals(u))
                .toList();
    }
}

// ---------- Terminal App ----------
public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ChatManager chatManager = new ChatManager();
    private static User currentUser = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Register User\n2. Login\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> loginUser();
                case 3 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void registerUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        chatManager.registerUser(name, phone);
    }

    private static void loginUser() {
        System.out.print("Enter phone to login: ");
        String phone = scanner.nextLine();
        currentUser = chatManager.login(phone);
        if (currentUser == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Logged in as: " + currentUser.getName());
        userMenu();
    }

    private static void userMenu() {
        while (true) {
            System.out.println("\n---- " + currentUser.getName() + "'s Menu ----");
            System.out.println("1. Show Friends");
            System.out.println("2. Switch User");
            System.out.println("3. Logout");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> showAndChatWithFriends();
                case 2 -> { return; }
                case 3 -> {
                    currentUser = null;
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void showAndChatWithFriends() {
        List<User> others = chatManager.getAllUsersExcept(currentUser);
        if (others.isEmpty()) {
            System.out.println("No friends available.");
            return;
        }

        System.out.println("Friends:");
        for (int i = 0; i < others.size(); i++) {
            System.out.println((i + 1) + ". " + others.get(i).getName());
        }

        System.out.print("Select friend to chat: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();

        if (idx < 0 || idx >= others.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        User friend = others.get(idx);
        Chat chat = currentUser.findChatWith(friend);
        chatMenu(chat);
    }

    private static void chatMenu(Chat chat) {
        while (true) {
            System.out.println("\nChat with " + chat.getOtherUser(currentUser).getName());
            List<IMessage> messages = chat.getMessages();
            for (IMessage msg : messages) {
                String prefix = msg.getSender().equals(currentUser) ? "You" : msg.getSender().getName();
                System.out.println(prefix + ": " + msg.getContent() + " [" + msg.getType() + "]");
            }

            System.out.println("1. Send Text");
            System.out.println("2. Send Audio");
            System.out.println("3. Send Video");
            System.out.println("4. Back");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Enter message: ");
                    String text = scanner.nextLine();
                    chat.addMessage(new TextMessage(text, currentUser));
                }
                case 2 -> {
                    System.out.print("Enter audio URL: ");
                    String audio = scanner.nextLine();
                    chat.addMessage(new AudioMessage(audio, currentUser));
                }
                case 3 -> {
                    System.out.print("Enter video URL: ");
                    String video = scanner.nextLine();
                    chat.addMessage(new VideoMessage(video, currentUser));
                }
                case 4 -> { return; }
                default -> System.out.println("Invalid.");
            }
        }
    }
}
