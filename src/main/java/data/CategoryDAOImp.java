
package data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import models.Category;

@Stateless //Indica que esta clase no permite crear objetos
public class CategoryDAOImp implements CategoryDAO{
    
    @PersistenceContext(unitName = "dbStoreJTAPU") //Para indicat la unidad de persistencia JTA
    EntityManager em;

    @Override
    public List<Category> findAllCategory() {
        return em.createNamedQuery("Category.findAll").getResultList();
    }
    
    @Override
    public List<Category> findAllCategory(String filter) {
        Query query;
        query = em.createQuery("SELECT c FROM Category c WHERE c.categoryName LIKE :filter ORDER BY c.categoryName");
        query.setParameter("filter", "%"+filter+"%");
        return query.getResultList();
    }
//    
//    @Override
//    public List<Category> findCategorybyId() {
//        return em.createNamedQuery("Category.findByCategoryId").getResultList();
//    }

    @Override
    public void insertCategory(Category category) {
        try {
            em.persist(category);
        }
        catch(Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
    }

    @Override
    public void deleteCategory(Category category) {
        em.remove(em.merge(category));
    }

    @Override
    public void updateCategory(Category category) {
        em.merge(category);        
    }
    
}
