import java.util.*;
class AppEngine {
    private final WallService wallService = new WallService();
    private final UserService userService = new UserService();
    private final BrickService brickService = new BrickService(wallService);
    
    // Main method to run the application
    public void initializeUsers(Scanner sc) {
        System.out.println("Enter 5 users:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter user name: ");
            userService.addUser(sc.nextLine());
        }
    }
    
    // AlLMethods to handle user actions

    //paint  wall by user
    public void paintBrick(Scanner sc) {
        User user = userService.getUser(sc);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        wallService.showCities();
        System.out.print("Choose City: ");
        String city = sc.nextLine();
        System.out.print("Caption: ");
        String caption = sc.nextLine();
        System.out.print("Message: ");
        String msg = sc.nextLine();
        System.out.print("Dedicated to: ");
        String dedicatee = sc.nextLine();
        brickService.createBrick(city, caption, msg, user, dedicatee);
    }
    // Method to view the wall of a city
    public void viewWall(Scanner sc) {
        User user = userService.getUser(sc);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        wallService.showCities();
        System.out.print("Choose City: ");
        String city = sc.nextLine();
        wallService.viewCityWall(city, user);
    }

    //add comment to a brick
    public void commentOnBrick(Scanner sc) {
        System.out.print("Enter Brick ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter comment: ");
        String comment = sc.nextLine();
        brickService.addComment(id, comment);
    }
   // report he brick
    public void flagBrick(Scanner sc) {
        System.out.print("Enter Brick ID to flag: ");
        int id = sc.nextInt();
        sc.nextLine();
        brickService.flagBrick(id);
    }
    //edit brick data
    public void editBrick(Scanner sc) {
        User user = userService.getUser(sc);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        System.out.print("Enter Brick ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("New Caption: ");
        String caption = sc.nextLine();
        System.out.print("New Message: ");
        String msg = sc.nextLine();
        brickService.editBrick(id, user, caption, msg);
    }
    //admin login to edit brick data
    public void adminLogin(Scanner sc) {
        System.out.print("Enter Admin name: ");
        String name = sc.nextLine();
        if (!name.equalsIgnoreCase("admin")) return;

        System.out.print("Enter Brick ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("New Caption: ");
        String caption = sc.nextLine();
        System.out.print("New Message: ");
        String msg = sc.nextLine();
        brickService.editBrickAsAdmin(id, caption, msg);
    }

    public void showStats() {
        wallService.showStats();
        brickService.showPopularityStats();
    }
}
