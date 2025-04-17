import java.util.*;

// Entry Point
public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AppEngine app = new AppEngine();

        app.initializeUsers(sc);

        while (true) {
            System.out.println("\n1. Paint a Brick\n2. View Wall\n3. Comment on Brick\n4. Flag a Brick\n5. Edit Brick\n6. Admin Login\n7. Show Stats\n8. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> app.paintBrick(sc);
                case 2 -> app.viewWall(sc);
                case 3 -> app.commentOnBrick(sc);
                case 4 -> app.flagBrick(sc);
                case 5 -> app.editBrick(sc);
                case 6 -> app.adminLogin(sc);
                case 7 -> app.showStats();
                case 8 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}

