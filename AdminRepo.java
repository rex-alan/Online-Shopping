import java.util.*;
public class AdminRepo {
    private ArrayList<Admin> adminList = new ArrayList<>();

    public ArrayList<Admin> getAdminList() {
        return adminList;
    }
    public void setAdminList(ArrayList<Admin> adminList) {
        this.adminList = adminList;
    }

    public void viewAdmins(){
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }
}
