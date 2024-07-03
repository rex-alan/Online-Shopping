import java.util.*;
public class Order {
    private int orderId;
    private static int counter=101;
    private Customer customer;
    private ArrayList<BillItem> billItems = new ArrayList<>();
    private double total;

    public Order(){
        this.orderId = counter++;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }
    public ArrayList<BillItem> getBillItems() {
        return billItems;
    }
    public double getTotal() {
        return (int)total;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setBillItems(ArrayList<BillItem> billItems) {
        this.billItems = billItems;
    }
    public void setTotal(double total) {
        this.total = total;
    }


    public void addBillItem(BillItem billItem){
        for (Stock stock : StockRepo.getStockList()) {
            if(stock.getProduct().getName().equals(billItem.getProduct().getName()) && stock.getQuantity() >= billItem.getQuantity()){
                billItems.add(billItem);
                stock.setQuantity(stock.getQuantity()-billItem.getQuantity());
                calculateBillTotal();
                return;
            }
        }
        System.out.println("Stock unavailable");
        
    }
    public void updateBillItem(int id, int quantity){
        for (BillItem billItem : billItems) {
            if(billItem.getProduct().getId() == id){
                for (Stock stock : StockRepo.getStockList()) {
                    if(stock.getProduct().getName().equals(billItem.getProduct().getName()) && quantity <= billItem.getQuantity()){
                        int leftQUantity = billItem.getQuantity()-quantity;
                        stock.setQuantity(stock.getQuantity()+leftQUantity);
                        billItem.setQuantity(quantity);
                        calculateBillTotal();
                        System.out.println("Quantity Updated");
                        return;
                    }
                    else if(stock.getProduct().getName().equals(billItem.getProduct().getName()) && quantity > billItem.getQuantity()){
                        int extraQuantity = quantity-billItem.getQuantity();
                        if(stock.getQuantity() >= extraQuantity){
                            stock.setQuantity(stock.getQuantity()-extraQuantity);
                            billItem.setQuantity(quantity);
                            calculateBillTotal();
                            System.out.println("Quantity Updated");
                            return;
                        }
                        else{
                            System.out.println("Given Quantity is not available");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Invalid Product ID");
    }

    public void deleteBIllItem(int id){
        for (BillItem billItem : billItems) {
            if(billItem.getProduct().getId() == id){
                for (Stock stock : StockRepo.getStockList()) {
                    if(stock.getProduct().getName().equals(billItem.getProduct().getName())){
                        stock.setQuantity(billItem.getQuantity());
                        billItems.remove(billItem);
                        calculateBillTotal();
                        System.out.println("Product removed");
                        return;
                    }
                }
            }
        }
        System.out.println("Invalid Product Id");
    }

    public void couponDiscount(int coupounCode){
        for (Coupon coupon : CouponRepo.getCopounList()) {
            if(coupon.getCouponCode() == coupounCode){
                float discount = coupon.getDiscount();
                double sum = this.total;
                double discountAmount = sum * (discount/100);
                sum = sum - discountAmount;
                this.total = sum;
                return;
            }
        }
        System.out.println("Invalid CouponCode");
    }

    public void calculateBillTotal(){
        double sum = 0;
        for (BillItem billItem : billItems) {
            sum+=billItem.getAmount();
        }
        this.total = sum;
    }

    public void viewOrderDetails(){
        System.out.println("Order ID: " +this.orderId);
        for (BillItem billItem : billItems) {
            System.out.println(billItem);
        }
        System.out.println("\t\t\t\t Total: "+this.total);
    }

    @Override
    public String toString(){
        String s = "";
        s+="Order ID: "+getOrderId()+"\n";
        for (BillItem billItem : billItems) {
            s+=billItem+"\n";
        }
        s+="\t\t\t\t Total: "+getTotal();
        return s;
    }
}
