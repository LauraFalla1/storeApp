package data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Carro;

@Stateless
public class CarroDAOImp implements CarroDAO {
    @PersistenceContext(unitName = "dbStoreJTAPU") //Para indicat la unidad de persistencia JTA
    EntityManager em;
    @Override
    public List<Carro> findAllCarro() {
       return em.createNamedQuery("carro.findAll").getResultList();
        
    }

    @Override
    public void addCarro(Carro carro) {
        try {
            em.persist(carro);
        }
        catch(Exception e){
            System.out.println("Exception:" + e.getMessage());
        }    }
  
}
