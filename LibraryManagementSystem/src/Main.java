import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Book> books = new ArrayList<>();
    static int maxborrowlimit = 5;
    static final String adminUserName = "admin";
    static final String adminPassword ="password";

    static List<User> users = new ArrayList<>();


    static Scanner sc = new Scanner(System.in);
        public static void main(String[] args) {

            while(true) {
                System.out.print("Enter your role(Admin /User):");
                String role = sc.nextLine().toLowerCase();

                if (role.equals("admin")) {
                    System.out.print("Enter Admin Username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter Admin Password: ");
                    String password = sc.nextLine();

                    if (username.equals(adminUserName) && password.equals(adminPassword)) {
                        Admin admin = new Admin();
                        admin.adminMenu();
                    } else {
                        System.out.println("Invalid admin credentials.");
                    }

                } else if (role.equals("user")) {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    User user = new User(name);
                    user.userMenu();
                } else {
                    System.out.println("Invalid role. Try again.");
                }
            }
        }
}
