import java.util.*;

public class ShoppingApp {
    Inventory inventory = new Inventory();
    List<Purchase> salesHistory = new ArrayList<>();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Shopping App Menu ---");
            System.out.println("1. Show Inventory");
            System.out.println("2. Add Product to Inventory");
            System.out.println("3. Delete Product from Inventory");
            System.out.println("4. Purchase Product");
            System.out.println("5. Show Sales History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    inventory.showInventory();
                    break;
                case "2":
                    addProductMenu(scanner);
                    break;
                case "3":
                    deleteProductMenu(scanner);
                    break;
                case "4":
                    purchaseProductMenu(scanner);
                    break;
                case "5":
                    showSalesHistory();
                    break;
                case "6":
                    System.out.println("Exiting Shopping App. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addProductMenu(Scanner scanner) {
        try {
            System.out.print("Enter Product ID: ");
            int productId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Product Description: ");
            String description = scanner.nextLine();
            System.out.print("Enter Product Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter Seller Name: ");
            String seller = scanner.nextLine();

            Product product = new Product(productId, name, description, price, seller);
            inventory.addProduct(product);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private void deleteProductMenu(Scanner scanner) {
        try {
            System.out.print("Enter Product ID to delete: ");
            int productId = Integer.parseInt(scanner.nextLine());
            inventory.deleteProduct(productId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private void purchaseProductMenu(Scanner scanner) {
        try {
            System.out.print("Enter Product ID to purchase: ");
            int productId = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Purchaser's Name: ");
            String purchaser = scanner.nextLine();

            Product product = inventory.getProduct(productId);
            if (product != null) {
                Purchase purchase = new Purchase(productId, purchaser);
                salesHistory.add(purchase);
                inventory.deleteProduct(productId);
                System.out.println("Purchase successful!");
            } else {
                System.out.println("Product ID not found in inventory.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private void showSalesHistory() {
        if (salesHistory.isEmpty()) {
            System.out.println("No sales history available.");
        } else {
            System.out.println("Sales History:");
            for (Purchase purchase : salesHistory) {
                System.out.println(purchase);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingApp app = new ShoppingApp();
        app.showMenu();
    }
}