package MainApp.DAO;

import MainApp.models.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> showUsers();

    void deleteUserById(int id);

    User getUserById(int id);

    void updateUser(User userToUpdate);


}
