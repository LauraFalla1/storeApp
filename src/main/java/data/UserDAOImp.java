package data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.User;

@Stateless
public class UserDAOImp implements UserDAO{
    
    @PersistenceContext(unitName = "dbStoreJTAPU") //Para indicat la unidad de persistencia JTA
    EntityManager em;

    
    
    @Override
    public User validateUser(String user, String pwd) {
        try {
            Query query;
        query = em.createQuery("SELECT u FROM User u WHERE u.user = :user AND u.pwd = :pwd");
        query.setParameter("user", user);
        query.setParameter("pwd", pwd);
        return (User)query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        
    }

    @Override
    public List<User> findAllUser() {
     return em.createNamedQuery("User.findAll").getResultList();   
    }

    @Override
    public void insertUser(User user) {
       try {
            em.persist(user);
        }
        catch(Exception e){
            System.out.println("Exception:" + e.getMessage());
        }    
    }

    @Override
    public void deleteUser(User user) {
    em.remove(em.merge(user));    
    }

    @Override
    public void updateUser(User user) {
            em.merge(user); 
    }

    @Override
     public List<User> findIdUser(Integer filter) {
        Query query;
        query = em.createQuery("SELECT u FROM User u WHERE u.id IN (:filter)");
        query.setParameter("filter", filter);
        return  query.getResultList();
    }
    @Override
    public User findAllUserById(User user) {
         return em.find(User.class, user.getId());
    }

    @Override
    public List<User> findAllUser(String filter) {
        Query query;
        query = em.createQuery("SELECT u FROM User u WHERE u.user LIKE :filter ORDER BY u.user");
        query.setParameter("filter", "%"+filter+"%");
        return query.getResultList();
    }

   
    
}