import java.util.Scanner;

public class AdminServices {
    static Scanner sc = new Scanner(System.in);
    public void addProduct(){
        System.out.print("Enter Product Name: "); String name = sc.next();
        System.out.print("Enter Price: "); double price = sc.nextDouble();
        Product product = new Product(name, price);
        ProductRepo.getProductList().add(product);
   } 
   public void viewProduct(){
        for (Product product : ProductRepo.getProductList()) {
            System.out.println(product);
        }
   }

   public void generateCouponCode(){
        System.out.print("Enter CouponCode: "); int cc = sc.nextInt();
        System.out.print("Enter discount percentage : "); float discount = sc.nextFloat();
        Coupon coupon = new Coupon(cc, discount);
        CouponRepo.getCopounList().add(coupon);
   }

   public void mamageStocks(){
        boolean flag = true;
        while (flag) {
            System.out.println("1.Add Stock\n2.View Stock\n3.delete Stock\n4.Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    addStock();
                    break;
                case 2:
                    viewStocks();
                    break;
                case 3:
                    deleteStock();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
   }
   public void addStock(){
        System.out.print("Enter Product ID: "); int pId = sc.nextInt();
        System.out.print("Enter quantity: "); int quantity = sc.nextInt();
        Stock stock = new Stock();
        stock.addStock(pId, quantity);
    
   }
   public void viewStocks(){
        StockRepo.viewStocks();
   }
   public void deleteStock(){
        System.out.print("Enter Product Id: "); int id = sc.nextInt();
        for (Stock stock : StockRepo.getStockList()) {
            if (stock.getProduct().getId() == id) {
                StockRepo.getStockList().remove(stock);
                System.out.println("Stock removed Successfully");
                return;
            }
        }
        System.out.println("Invalid Product ID");
   }
   public void shoppingHistory(){
        for (Order order : OrderRepo.getOrderList()) {
            System.out.println(order);
        }
   }

}
