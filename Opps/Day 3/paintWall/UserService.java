import java.util.*;
class UserService {
    private final List<User> users = new ArrayList<>();
    private int userIdCounter = 1;

    public void addUser(String name) {
        users.add(new User(userIdCounter++, name));
    }

    public User getUser(Scanner sc) {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        return users.stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }
}