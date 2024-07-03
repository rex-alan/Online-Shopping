import java.util.*;
public class OrderRepo {
    private static ArrayList<Order> orderList = new ArrayList<>();

    public static ArrayList<Order> getOrderList() {
        return orderList;
    }
    public static void setOrderList(ArrayList<Order> orderList) {
        OrderRepo.orderList = orderList;
    }
}
