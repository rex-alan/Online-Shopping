public class Loaders {
    public void loadCustomer(){
        Customer c1 = new Customer("Rex", "7");
        Customer c2 = new Customer("Alan", "8");
        Customer c3 = new Customer("Rock", "9");
        CustomerRepo.getCustomerList().add(c3);
        CustomerRepo.getCustomerList().add(c2);
        CustomerRepo.getCustomerList().add(c1);
    }
    public void loadProduct(){
        Product p1 = new Product("shirt",50);
        Product p2 = new Product("Pant",100);
        Product p3 = new Product("Trouser",75);
        Product p4 = new Product("Saree",200);
        ProductRepo.getProductList().add(p1);
        ProductRepo.getProductList().add(p2);
        ProductRepo.getProductList().add(p3);
        ProductRepo.getProductList().add(p4);

        Stock s1 = new Stock(p1, 10);
        Stock s2 = new Stock(p2, 10);
        Stock s3 = new Stock(p3, 10);
        Stock s4 = new Stock(p4, 10);
        StockRepo.getStockList().add(s1);
        StockRepo.getStockList().add(s2);
        StockRepo.getStockList().add(s3);
        StockRepo.getStockList().add(s4); 
    }
    public void loadWishlist(){
        WishList wl = new WishList();
        wl.addToWishlist(5, 1);
        wl.addToWishlist(5, 2);
        wl.addToWishlist(5, 3);
        wl.addToWishlist(6, 4);
        wl.addToWishlist(6, 1);
    }
    public void loadCoupon(){
        Coupon c1 = new Coupon(999, 10);
        Coupon c2 = new Coupon(888, 20);
        Coupon c3 = new Coupon(777, 50);
        CouponRepo.getCopounList().add(c1);
        CouponRepo.getCopounList().add(c2);
        CouponRepo.getCopounList().add(c3);
    }
}
