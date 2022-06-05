
package data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import models.Customer;
import models.Product;

@Stateless //Indica que esta clase no permite crear objetos
public class ProductDAOImp implements ProductDAO{
    
    @PersistenceContext(unitName = "dbStoreJTAPU") //Para indicat la unidad de persistencia JTA
    EntityManager em;

    @Override
    public List<Product> findAllProduct() {
        return em.createNamedQuery("Product.findAll").getResultList();
    }
    
    
    @Override
    public List<Product> findAllProduct(String filter) {
        Query query;
        query = em.createQuery("SELECT c FROM Product c WHERE c.productName LIKE :filter ORDER BY c.productName");
        query.setParameter("filter", "%"+filter+"%");
        return query.getResultList();
    }
    
    @Override
    public List<Product> findIdProduct(Integer filter) {
        Query query;
        query = em.createQuery("SELECT p FROM Product p WHERE p.productId = :filter");
        query.setParameter("filter", filter);
        return  query.getResultList();
    }

    @Override
    public Product findProductbyId(Product product) {
        return em.find(Product.class, product.getProductId());
    }
    
    @Override
    public List<Product> findByProductName(String product) {
        Query query =em.createQuery("SELECT p FROM Product p WHERE p.productName = :productName");
        query.setParameter("productName", product);
        return query.getResultList();
    }

    @Override
    public void insertProduct(Product product) {
        try {
            em.persist(product);
        }
        catch(Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
        
    }

    @Override
    public void deleteProduct(Product product) {
        em.remove(em.merge(product));
    }

    @Override
    public void updateProduct(Product product) {
        em.merge(product);        
    }

    
}

