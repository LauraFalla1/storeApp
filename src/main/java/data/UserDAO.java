package data;

import java.util.List;
import models.User;


public interface UserDAO {
    public User validateUser(String user, String pwd);
    public List<User> findAllUser(); 
    public List<User> findAllUser(String filter);
    public List<User> findIdUser(Integer filter);
    public User findAllUserById(User user);
    public void insertUser(User User);
    public void deleteUser(User User);
    public void updateUser(User User);
    
}