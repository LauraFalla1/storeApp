package data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.Sales;

@Stateless
public class SalesDAOimp implements SalesDAO {

    @PersistenceContext(unitName = "dbStoreJTAPU") //Para indicat la unidad de persistencia JTA
    EntityManager em;
     
    @Override
    public List<Sales> findAllSales() {
    Query query;
        query = em.createQuery("SELECT s FROM Sales s");
        return query.getResultList();  
    }

    @Override
    public List<Sales> findAllSales(String filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sales findSalesbyId(Sales sales) {
      return em.find(Sales.class, sales.getSaleID());
    }

    @Override
    public Sales findSalesbyEmail(Sales sales) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertSales(Sales sales) {
      try {
            em.persist(sales);
        }
        catch(Exception e){
            System.out.println("Exception:" + e.getMessage());
        }
    }

    @Override
    public void deleteSales(Sales sales) {
            em.remove(em.merge(sales));   
    }

    @Override
    public void updateSales(Sales sales) {
      em.merge(sales);
    }

   

    @Override
    public List<Sales> findSalesbyCustomerID(String filter) {
     Query query;
        query = em.createQuery("SELECT s FROM Sales s WHERE s.CustomerId LIKE :filter ORDER BY s.CustomerId");
        query.setParameter("filter", "%"+filter+"%");
        return query.getResultList(); 
    }
    
}

