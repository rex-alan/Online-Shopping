import java.util.Scanner;

public class CustomerServices {
    static Scanner sc = new Scanner(System.in);
    public Customer signin(){
        System.out.print("Enter User ID: "); int id = sc.nextInt();
        System.out.print("Enter password: "); String password = sc.next();
        for (Customer customer : CustomerRepo.getCustomerList()) {
            if (customer.getId() == id && customer.getPassword().equals(password)) {
                System.out.println("Login Successfull");
                return customer;
            }
        }
        System.out.println("Invalid Credentials");
        return null;
    }
    public void signup(){
        System.out.print("Enter Name: "); String name = sc.nextLine();
        sc.nextLine();
        System.out.print("Create new Password: "); String password = sc.next();
        Customer customer = new Customer(name, password);
        CustomerRepo.getCustomerList().add(customer);
        System.out.println("SignUp Successfull, Your user ID is : "+customer.getId());
    }
    public void viewAvailableProducts(){
        for (Stock stock : StockRepo.getStockList()) {
            if(stock.getQuantity() > 0){
                System.out.println(stock.getProduct() + " Quantity: "+stock.getQuantity());
            }
        }
    }
    public void searchProduct(){
        sc.nextLine();
        System.out.print("Enter Product Name: "); String name = sc.nextLine();
        for (Product product : ProductRepo.getProductList()) {
            if(product.getName().toLowerCase().equals(name.toLowerCase())){
                System.out.println(product);
                return;
            }
        }
    }
    public void addToWishlist(Customer customer){
        WishList wishList = new WishList();
        System.out.print("Enter product id to add to wishlist: "); int prodID = sc.nextInt();
        wishList.addToWishlist(customer.getId(),prodID);     
    }
    public void removeFromWishlist(Customer customer){
        WishList wishList = new WishList();
        System.out.print("Enter Product ID: "); int prodID = sc.nextInt();
        wishList.removeFromWishlist(customer.getId(), prodID);
    }
    public void viewWishlist(Customer customer){
        for (WishList wishList : WishlistRepo.getWishListCollections()) {
            if(wishList.getCustomerID() == customer.getId()){
                for (Product product : wishList.getWishlistProducts()) {
                    System.out.println(product);
                }
                return;
            }
        }
        System.out.println("Invalid customer ID");
    }
    public void orderProduct(Customer customer){
        boolean flag = true;
        Order order = new Order();
        while (flag) {
            System.out.println("1.Add Item\t\t5.View My Orders\n2.View Items\t\t6.Enter Coupon Code\n3.Remove Items\t\t7.Place Order\n4.Update Item\t\t8.Cancel Order\n\t\t\t9.Exit");
            int input = sc.nextInt();
            switch(input){
                case 1:
                    addBillItem(order);
                    break;
                case 2:
                    viewBillItem(order);
                    break;
                case 3:
                    removeBIllItem(order);
                    break;
                case 4:
                    updateBillItem(order);
                    break;
                case 5:
                    viewOrder(customer);
                    break;
                case 6:
                    couponCode(order);
                    break;
                case 7:
                    placeOrder(order, customer);
                    flag = false;
                    break;
                case 8:
                    cancelOrder(customer);
                    break;
                case 9:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
    public void addBillItem(Order order){
        System.out.print("Enter Product ID: "); int pId = sc.nextInt();
        System.out.print("Enter Quantity: "); int quantity = sc.nextInt();
        for (Stock stock : StockRepo.getStockList()) {
            if(stock.getProduct().getId() == pId){
                if(stock.getQuantity() >= quantity){
                    BillItem billItem = new BillItem(stock.getProduct(), quantity);
                    order.addBillItem(billItem);
                    System.out.println(stock.getProduct()+" addedd successfully");
                    return;
                }
                else{
                    System.out.println("Stock unavailable");
                    return;
                }
            }
        }
        System.out.println("Invalid Product ID");
    }
    public void viewBillItem(Order order){
        for (BillItem billItem : order.getBillItems()) {
            System.out.println(billItem);
        }
        System.out.println("\t\t\t\t\tTotal: "+order.getTotal());
    }
    public void removeBIllItem(Order order){
        System.out.print("Enter Product ID: "); int pId = sc.nextInt();
        order.deleteBIllItem(pId);
    }
    public void updateBillItem(Order order){
        System.out.print("Enter Product ID: "); int pId = sc.nextInt();
        System.out.print("Enter Quantity: "); int quantity = sc.nextInt();
        order.updateBillItem(pId, quantity);
    }
    public void couponCode(Order order){
        System.out.print("Enter Coupon Code: "); int coupon = sc.nextInt();
        for (Coupon cpn : CouponRepo.getCopounList()) {
            if (cpn.getCouponCode() == coupon) {
                double discount = order.getTotal() * (cpn.getDiscount()/100);
                order.setTotal(order.getTotal()-discount);
                System.out.println("Coupon Applied Successfully");
                return;
            }
        }
        System.out.println("Invalid CouponCode");
    }
    public void placeOrder(Order order,Customer customer){
        if(order.getBillItems()==null){
            System.out.println("Please add Products to place Order");
            return;
        }
        order.setCustomer(customer);
        OrderRepo.getOrderList().add(order);
        System.out.println("Order Placed Successfully");
    }
    public void cancelOrder(Customer customer){
        System.out.print("Enter Order ID: "); int orderId = sc.nextInt();
        for (Order order : OrderRepo.getOrderList()) {
            if(order.getCustomer().getId()== customer.getId() && order.getOrderId() == orderId){
                for (BillItem billItem : order.getBillItems()) {
                    for (Stock stock : StockRepo.getStockList()) {
                        if(billItem.getProduct().getName().equals(stock.getProduct().getName())){
                            stock.setQuantity(stock.getQuantity()+billItem.getQuantity());
                            break;
                        }
                    }
                }
                OrderRepo.getOrderList().remove(order);
                System.out.println("Order Cancelled Successfully");
                return;
            }
        }
        System.out.println("Invalid Order ID");
    }
    public void viewOrder(Customer customer){
        for (Order order : OrderRepo.getOrderList()) {
            if(order.getCustomer().getId() == customer.getId()){
                order.viewOrderDetails();
            }
        }
    }


}
