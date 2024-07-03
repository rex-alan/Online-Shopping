import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        // Loaders loaders = new Loaders();
        // loaders.loadProduct();
        // loaders.loadCustomer();
        // loaders.loadWishlist();
        // loaders.loadCoupon();

        boolean flag = true;
        while (flag) {
            System.out.println("1.Admin\n2.User\n3.Exit");
            int input = sc.nextInt();
            switch(input){
                case 1:
                    admin();
                    break;
                case 2:
                    user();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }

    public static void admin(){
        AdminServices as = new AdminServices();
        boolean flag = true;
        while (flag) {
            System.out.println("1.Add new product\n2.View Product\n3.Generate CouponCode\n4.Manage Stocks\n5.Shopping History\n6.Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    as.addProduct();
                    break;
                case 2:
                    as.viewProduct();
                    break;
                case 3:
                    as.generateCouponCode();
                    break;
                case 4:
                    as.mamageStocks();
                    break;
                case 5:
                    as.shoppingHistory();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
    public static void user(){
        CustomerServices cs = new CustomerServices();
        boolean flag = true;
        while (flag) {
            System.out.println("1.Signin\n2.Signup\n3.Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    Customer customer = cs.signin();
                    if(customer != null){
                        userJob(customer);
                    }
                    break;
                case 2:
                    cs.signup();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
    public static void userJob(Customer customer){
        CustomerServices cs = new CustomerServices();
        boolean flag = true;
        while (flag) {
            System.out.println("1.See Available Products\t5.View WishList\n2.Search Products\t\t6.Order\n3.Add to Wishlist\t\t7.Exit\n4.Remove from Wishlist");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    cs.viewAvailableProducts();
                    break;
                case 2:
                    cs.searchProduct();
                    break;
                case 3:
                    cs.addToWishlist(customer);
                    break;
                case 4:
                    cs.removeFromWishlist(customer);
                    break;
                case 5:
                    cs.viewWishlist(customer);
                    break;
                case 6:
                    cs.orderProduct(customer);
                    break;
                case 7:
                    flag = false;
                    break;  
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }   
}
