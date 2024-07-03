public class Coupon {
    private int couponCode;
    private float discount;
    
    public Coupon(int couponCode, float discount) {
        this.couponCode = couponCode;
        this.discount = discount;
    }
    public int getCouponCode() {
        return couponCode;
    }
    public float getDiscount() {
        return discount;
    }
    public void setCouponCode(int couponCode) {
        this.couponCode = couponCode;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    @Override
    public String toString() {
        return "Coupon [couponCode=" + couponCode + ", discount=" + discount + "]";
    }
    
    
}
