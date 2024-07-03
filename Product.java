public class Product {
    private int id;
    private static int counter = 1;
    private String name;
    private double price;
    private Coupon couponCode;

    public Product(String name, double price) {
        this.id = counter++;
        this.name = name;
        this.price = price;
    }
    public Product(){}

    public int getId() {
        return id;
    }public String getName() {
        return name;
    }public double getPrice() {
        return price;
    }
    public Coupon getCouponCode() {
        return couponCode;
    }
    public void setId(int id) {
        this.id = id;
    }public void setName(String name) {
        this.name = name;
    }public void setPrice(double price) {
        this.price = price;
    }
    public void setCouponCode(Coupon couponCode) {
        this.couponCode = couponCode;
    }
    //add,update,remove,get product
    public void updateProduct(int id, int price){
        for (Stock stock : StockRepo.getStockList()) {
            if(id == stock.getProduct().getId()){
                stock.getProduct().setPrice(price);
                System.out.println("Price updated successfully");
                return;
            }
        }
        System.out.println("Invalid ID");
    }
    public void removeProduct(int id){
        for (Stock stock : StockRepo.getStockList()) {
            if(id == stock.getProduct().getId()){
                StockRepo.getStockList().remove(stock);
                System.out.println("Product removed successfully");
                return;
            }
        }
        System.out.println("Invalid ID");
    }
    public Product getProduct(int id){
        for (Stock stock : StockRepo.getStockList()) {
            if(id == stock.getProduct().getId()){
                return stock.getProduct();
            }
        }
        System.out.println("Invalid ID");
        return null;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

    

    
}
