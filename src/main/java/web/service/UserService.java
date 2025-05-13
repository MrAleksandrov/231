package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers ();
    public void save(User user);
    public void update(User user);
    public void delete(Long id);
    public User getUserById(Long id);
}
