import java.util.Date;

public class Purchase {
     int productId;
     String purchaser;
     Date date;

    public Purchase(int productId, String purchaser) {
        this.productId = productId;
        this.purchaser = purchaser;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Purchaser: " + purchaser + ", Date: " + date;
    }
}