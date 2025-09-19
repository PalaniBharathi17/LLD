public class User {
    private String username;
    private String password;
    private boolean seller;

    public User(String username, String password, boolean seller) {
        this.username = username;
        this.password = password;
        this.seller = seller;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public boolean isSeller() { return seller; }
}
