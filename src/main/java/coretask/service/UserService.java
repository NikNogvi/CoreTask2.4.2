package coretask.service;

import coretask.model.Role;
import coretask.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public void editUser(User user);

    public User getUserById(long id);

    public void deleteUser(long id);

    User getUserByUsername(String username);


}
