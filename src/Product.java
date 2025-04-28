public class Product {
     int productId;
     String name;
     String description;
     double price;
     String seller;

    public Product(int productId, String name, String description, double price, String seller) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.seller = seller;
    }

    public int getProductId() {
        return productId;
    }

    public String getDetails() {
        return "ID: " + productId + ", Name: " + name + ", Description: " + description +
                ", Price: $" + price + ", Seller: " + seller;
    }
}