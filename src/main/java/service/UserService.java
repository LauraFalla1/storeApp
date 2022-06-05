/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import models.User;

public interface UserService {
    public User validateUser(String user, String pwd);
    public List<User> findAllUser();  
    public List<User> findAllUser(String filter);
    public List<User> findIdUser(Integer filter);
    public User findAllUserByID(User user);
    public void insertUser(User User);
    public void deleteUser(User User);
    public void updateUser(User User);
    
    
}