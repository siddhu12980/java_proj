import java.util.ArrayList;
import java.util.Scanner;

public class Stock {

    public static void disp() {
        System.out.println("Options:");
        System.out.println("1. Add Product");
        System.out.println("2. Update Stock");
        System.out.println("3. Display Stock");
        System.out.println("4. Exit");

        System.out.print("Enter your choice: ");
    }

    public static void welcome() {
        System.out.println("--------------------------------:");
        System.out.println("Welcome");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println(" ");

        System.out.println("Stock Managment System");
        System.out.println(" ");

        System.out.println(" ");

        System.out.println(" ");

        System.out.println(" ");

        System.out.println("@2023 JU");
        System.out.println(" ");

        System.out.println(" ");

        System.out.println(" ");

        System.out.println(" ");

        System.out.println("-------------------------------");

    }

    private static void clearScreen() {
        try {
            System.out.println("Press Enter to continue...");
            new Scanner(System.in).nextLine(); // Wait for the user to press Enter

            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J"); // ANSI escape code for clearing the screen
                System.out.flush();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        StockManager stockManager = new StockManager();

        Scanner scanner = new Scanner(System.in);
        clearScreen();

        welcome();
        clearScreen();

        while (true) {
            clearScreen();

            disp();

            int choice = scanner.nextInt();

       

            

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.next();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter initial quantity: ");
                    int initialQuantity = scanner.nextInt();
                    stockManager.addProduct(name, price, initialQuantity);
                    break;
                case 2:
                    stockManager.displayStock();
                    System.out.print("Enter product name to update stock: ");
                    String productName = scanner.next();
                    try {
                        stockManager.updateStock(productName);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    stockManager.displayStock();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        }

    }



// add expectiom