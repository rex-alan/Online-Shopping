import java.util.*;
public class CouponRepo {
    private static ArrayList<Coupon> copounList = new ArrayList<>();

    public static ArrayList<Coupon> getCopounList() {
        return copounList;
    }
    public static void setCopounList(ArrayList<Coupon> copounList) {
        CouponRepo.copounList = copounList;
    }
    public void viewCoupons(){
        for (Coupon coupon : copounList) {
            System.out.println(coupon);
        }
    }
}
