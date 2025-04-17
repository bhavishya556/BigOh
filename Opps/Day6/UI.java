package Day6;

import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        HotelManagement hm = new HotelManagement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("Select Role:");
            System.out.println("1. User");
            System.out.println("2. Hotel Agent");
            System.out.println("3. Administrator");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int roleOption = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (roleOption) {
                case 1 -> userMenu(hm, sc);
                case 2 -> hotelAgentMenu(hm, sc);
                case 3 -> administratorMenu(hm, sc);
                case 4 -> {
                    System.out.println("Exiting... Bye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid role option.");
            }
        }
    }

    private static void userMenu(HotelManagement hm, Scanner sc) {
        while (true) {
            System.out.println("\n--- User Portal ---");
            System.out.println("1. Register");
            System.out.println("2. Book Hotel");
            System.out.println("3. Show All Hotels");
            System.out.println("4. Back");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter name, email, phone:");
                    String name = sc.nextLine();
                    String email = sc.nextLine();
                    String phone = sc.nextLine();
                    hm.createUser(name, email, phone);
                    System.out.println("User registered successfully.");
                }
                case 2 -> {
                    System.out.println("Enter your registered name:");
                    String uname = sc.nextLine();
                    User user = hm.findUserByName(uname);
                    if (user == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    hm.showAllHotels();
                    System.out.println("Enter Hotel ID to book:");
                    String hotelId = sc.nextLine();
                    hm.bookHootel(user, hotelId);
                }
                case 3 -> hm.showAllHotels();
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void hotelAgentMenu(HotelManagement hm, Scanner sc) {
        HotelAgent agent = null;
        while (true) {
            System.out.println("\n--- Hotel Agent Portal ---");
            System.out.println("1. Register");
            System.out.println("2. Add Hotel");
            System.out.println("3. Back");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter name, email, phone:");
                    String name = sc.nextLine();
                    String email = sc.nextLine();
                    String phone = sc.nextLine();
                    agent = hm.createHotelAgent(name, email, phone);
                    System.out.println("Hotel Agent registered successfully.");
                }
                case 2 -> {
                    if (agent == null) {
                        System.out.println("Please register as a Hotel Agent first.");
                        break;
                    }
                    System.out.println("Enter hotel name, location, hotelId, available rooms:");
                    String hname = sc.nextLine();
                    String location = sc.nextLine();
                    String hotelId = sc.nextLine();
                    int rooms = sc.nextInt();
                    sc.nextLine();
                    hm.addHotel(new Hotel(hname, location, hotelId, rooms, agent));
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void administratorMenu(HotelManagement hm, Scanner sc) {
        while (true) {
            System.out.println("\n--- Administrator Portal ---");
            System.out.println("1. Register");
            System.out.println("2. Approve/Reject Hotels");
            System.out.println("3. Show All Bookings by Hotel ID");
            System.out.println("4. Back");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    if (!hm.isAdminAvaliable()) {
                        System.out.println("Enter name, email, phone:");
                        String name = sc.nextLine();
                        String email = sc.nextLine();
                        String phone = sc.nextLine();
                        hm.createAdministrator(name, email, phone);
                        System.out.println("Administrator registered successfully.");
                    } else {
                        System.out.println("Administrator already registered.");
                    }
                }
                case 2 -> {
                    System.out.println("Enter your registered email:");
                    String adminEmail = sc.nextLine();
                    Administrator admin = hm.getAdmin();
                    if (admin == null || !admin.email.equals(adminEmail)) {
                        System.out.println("Administrator not found.");
                        break;
                    }
                    System.out.println("All pending hotels:");
                    hm.showAllPendingHotels();
                    System.out.println("Enter hotelId to approve/reject:");
                    String hotelId = sc.nextLine();
                    System.out.println("Approve? (true/false):");
                    boolean isApprove = sc.nextBoolean();
                    sc.nextLine();
                    hm.approveHotel(admin, hotelId, isApprove);
                }
                case 3 -> {
                    System.out.println("Enter Hotel ID:");
                    String hotelId = sc.nextLine();
                    hm.hotelBookingsByHotelId(hotelId);
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

// package Day6;

// public class HotelSystem {
    
//     public static void main(String[] args) {
//         HotelManagement hm = new HotelManagement();

//         Administrator admin = hm.createAdministrator("bahvi", "email1", "67897");
//         User user1 = hm.createUser("user1", "email1", "67897");
//         User user2 = hm.createUser("user2", "email2", "67897");
//         User user3 = hm.createUser("user3", "email3", "67897");
//         User user4 = hm.createUser("user4", "email4", "67897");
//         User user5 = hm.createUser("user5", "email5", "67897");


//         HotelAgent hotelAgent1 = hm.createHotelAgent("ha1", "email2", "67897");
//         HotelAgent hotelAgent2 = hm.createHotelAgent("ha2", "email2", "67897");
//         HotelAgent hotelAgent3 = hm.createHotelAgent("ha3", "email2", "67897");
//         HotelAgent hotelAgent4 = hm.createHotelAgent("ha4", "email2", "67897");
//         HotelAgent hotelAgent5 = hm.createHotelAgent("ha5", "email2", "67897");
      

//         hm.addHotel(new Hotel("Hotel1", "Location1", "100", 4,hotelAgent1));
//         hm.addHotel(new Hotel("Hotel2", "Location1", "200", 4,hotelAgent2));
//         hm.addHotel(new Hotel("Hotel3", "Location1", "300", 4,hotelAgent3));
//         hm.addHotel(new Hotel("Hotel4", "Location1", "400", 4,hotelAgent3));
//         hm.addHotel(new Hotel("Hotel5", "Location1", "500", 4,hotelAgent3));

//         System.out.println();

//         hm.approveHotel(admin, "100", true);
//         hm.approveHotel(admin, "200", false);
//         hm.approveHotel(user1, "300", true);
//         hm.approveHotel(hotelAgent1, "300", true);

//         hm.approveHotel(admin, "300", true);
//         hm.approveHotel(admin, "400", true);
//         hm.approveHotel(admin, "500", true);
        

//         hm.showALLHotels();
        
//         hm.bookHootel(user1, "100" );
//         hm.bookHootel(user2, "200" );
//         hm.bookHootel(user3, "300" );
//         hm.bookHootel(user4, "400" );
//         hm.bookHootel(user5, "500" );


//        // hm.showAllBookings();
//         hm.hotelBookingsByHotelId("200");
    

        
        
//     }


// }
