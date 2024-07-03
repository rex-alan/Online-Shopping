import java.util.*;
public class WishlistRepo {
    private static ArrayList<WishList> wishListCollections = new ArrayList<>();

    public static ArrayList<WishList> getWishListCollections() {
        return wishListCollections;
    }
    public static void setWishListCollections(ArrayList<WishList> wishListCollections) {
        WishlistRepo.wishListCollections = wishListCollections;
    }
    
}
