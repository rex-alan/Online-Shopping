public class Admin {
    private int id;
    private static int counter = 5;
    private String name;
    private String password;

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
        this.id = counter++;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", password=" + password + "]";
    }

    
    
}
