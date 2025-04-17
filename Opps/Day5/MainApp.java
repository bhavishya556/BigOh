import java.time.LocalDateTime;
import java.util.*;


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
