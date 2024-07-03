public class Stock {
    private Product product;
    private int quantity;

    public Stock(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Stock(){}

    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addStock(int pId, int quantity){
        for (Stock stock : StockRepo.getStockList()) {
            if(stock.getProduct().getId() == pId){
                stock.setQuantity(stock.getQuantity()+quantity);
                System.out.println("Stock Updated Successfully");
                return;
            }
        }
        for (Product p : ProductRepo.getProductList()) {
            if(p.getId() == pId){
                Stock stock = new Stock(p, quantity);
                StockRepo.getStockList().add(stock);
                System.out.println("Stock Added Successfully");
                return;
            }
        }
        System.out.println("Invalid Product ID");
    }

    @Override
    public String toString() {
        return "Stock [product=" + product + ", quantity=" + quantity + "]";
    }

    
    

}
