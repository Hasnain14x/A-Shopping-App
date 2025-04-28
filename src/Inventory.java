import java.util.*;

public class Inventory {
    private Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Product '" + product.getDetails() + "' added successfully.");
    }

    public void deleteProduct(int productId) {
        if (products.containsKey(productId)) {
            Product removedProduct = products.remove(productId);
            System.out.println("Product '" + removedProduct.getDetails() + "' deleted successfully.");
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void showInventory() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("Inventory:");
            for (Product product : products.values()) {
                System.out.println(product.getDetails());
            }
        }
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }
}