public class BillItem {
    private Product product;
    private int quantity;
    private double amount;
    public BillItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.amount = calculateAmount(product.getPrice(), quantity);
    }

    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getAmount() {
        return amount;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double calculateAmount(double price, int quantity){
        return price * quantity;
    }

    @Override
    public String toString() {
        return "BillItem [product=" + product.getName() + ", quantity=" + quantity + ", amount=" + amount + "]";
    }
    
    
    
}
