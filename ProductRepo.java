import java.util.*;
public class ProductRepo {
    private static ArrayList<Product> productList = new ArrayList<>();

    public static ArrayList<Product> getProductList() {
        return productList;
    }
    public static void setProductList(ArrayList<Product> productList) {
        ProductRepo.productList = productList;
    }
    
}
