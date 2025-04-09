package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Class for managing the authentication of a user
 *
 */
public class Session {

    private User currentUser;
    private List<User> users;

    public Session(User currentUser) {
        this.currentUser = currentUser;
        this.users = new ArrayList<>();
    }

    public boolean authenticate() {
        return true;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void logout() {
        currentUser = null;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
