import java.util.*;
public class CustomerRepo {
    private static ArrayList<Customer> customerList = new ArrayList<>();

    public static ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    public static void setCustomerList(ArrayList<Customer> customerList) {
        CustomerRepo.customerList = customerList;
    }

    public void viewCustomers(){
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}
