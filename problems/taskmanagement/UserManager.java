package taskmanagement;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private static UserManager instance = null;

    private UserManager() {
        users = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }

        return instance;
    }

    public void createUser(String name) {
        users.add(new User(name));
    }

    public boolean deleteUser(int id) {

        this.users = users.stream().filter(user -> user.getId() != id).toList();
        return true;
    }

    public User getUser(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }

        return null;
    }

    public void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }
        System.out.println("Users:");
        for (User user : users) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getName());
        }
    }

}
