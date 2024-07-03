import java.util.*;
public class WishList {
    private int customerID;
    private ArrayList<Product> wishlistProducts = new ArrayList<>();

    public ArrayList<Product> getWishlistProducts() {
        return wishlistProducts;
    }
    public void setWishlistProducts(ArrayList<Product> wishlistProducts) {
        this.wishlistProducts = wishlistProducts;
    }

    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void addToWishlist(int custID,int prodID){
        for (Stock stock : StockRepo.getStockList()) {
            if(stock.getProduct().getId() == prodID){
                Product p = stock.getProduct();
                for (WishList wishList : WishlistRepo.getWishListCollections()) {
                    if(wishList.getCustomerID() == custID){
                        if(!(wishList.getWishlistProducts().contains(p))){
                            wishList.getWishlistProducts().add(p);
                            System.out.println("Product Added Successfully");
                            return;
                        }
                        System.out.println("This Product already added");
                        return;
                    }
                }
                WishList wishList = new WishList();
                wishList.setCustomerID(custID);
                wishList.getWishlistProducts().add(p);
                WishlistRepo.getWishListCollections().add(wishList);    
                System.out.println("Product Added Successfully");
                return;
                
            }
        }
        System.out.println("Invalid Product ID");
    }
    public void removeFromWishlist(int custID,int prodID){
        for (WishList wishList : WishlistRepo.getWishListCollections()) {
            if(wishList.getCustomerID() == custID){
                for (Product product : wishList.getWishlistProducts()) {
                    if(product.getId() == prodID){
                        wishList.getWishlistProducts().remove(product);
                        System.out.println("Product Removed Successfully");
                        return;
                    }
                }
            }
        }
        System.out.println("This Product is not in your WishList");
    }
    public void showWishList(int custID){
        for(WishList wishList : WishlistRepo.getWishListCollections()){
            if(wishList.getCustomerID() == custID){
                for (Product product : wishList.getWishlistProducts()) {
                    System.out.println(product);
                }
                return;
            }
        }
        System.out.println("Invalid Custoomer ID");
    }
}
