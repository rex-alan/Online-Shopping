import java.util.*;
public class StockRepo {
    private static ArrayList<Stock> stockList = new ArrayList<>();

    public static ArrayList<Stock> getStockList() {
        return stockList;
    }
    public static void setStockList(ArrayList<Stock> stockList) {
        StockRepo.stockList = stockList;
    }
    public void searchProduct(String name){
        for (Stock stock : stockList) {
            if(stock.getProduct().getName().equals(name)){
                System.out.println(stock+" price: "+stock.getProduct().getPrice());
            }
        }
        System.out.println("Invalid Name");
    }
    public static void viewStocks(){
        for (Stock stock : stockList) {
            System.out.println(stock);
        }
    }
    @Override
    public String toString(){
        String s = "";
        for (Stock stock : stockList) {
            s+=stock.toString()+"\n";
        }
        return s;
    }
}
