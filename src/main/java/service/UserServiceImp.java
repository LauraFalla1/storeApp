package service;

import data.UserDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import models.User;

@Stateless
public class UserServiceImp implements UserService{
    
    @Inject
    UserDAO userDAO;

    @Override
    public User validateUser(String user, String pwd) {
        return userDAO.validateUser(user, pwd);
        
    }

    @Override
    public List<User> findAllUser() {
    return userDAO.findAllUser();
    }

    @Override
    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
       userDAO.updateUser(user); 
    }

    @Override
    public User findAllUserByID(User user) {
        return userDAO.findAllUserById(user);
    }
    
    @Override
    public List<User> findIdUser(Integer filter) {
        return userDAO.findIdUser(filter);
    }

    @Override
    public List<User> findAllUser(String filter) {
        return userDAO.findAllUser(filter);
    }
    }

    
    
    
