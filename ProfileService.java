import java.util.*;

public class ProfileService {
    private List<User> users = new ArrayList<>();

    public User register(String username, String password, boolean isSeller) {
        User u = new User(username, password, isSeller);
        users.add(u);
        return u;
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
