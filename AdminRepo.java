import java.util.*;
public class AdminRepo {
    private static ArrayList<Admin> adminList = new ArrayList<>();

    public static ArrayList<Admin> getAdminList() {
        return adminList;
    }
    public void setAdminList(ArrayList<Admin> adminList) {
        AdminRepo.adminList = adminList;
    }

    public void viewAdmins(){
        for (Admin admin : adminList) {
            System.out.println(admin);
        }
    }
}
