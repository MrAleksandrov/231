package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    void update(User user);
    void delete(int id);
    User getUserById(long id);
    List<User> getAllUsers();
}
