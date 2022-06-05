package service;

import data.ProductDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import models.Product;

@Stateless
public class ProductServiceImp implements ProductService{
    
    @Inject
    private ProductDAO pDAO;

    @Override
    public List<Product> findAllProduct() {
        return pDAO.findAllProduct();
    }
    
    @Override
    public List<Product> findAllProduct(String filter) {
        return pDAO.findAllProduct(filter);
    }
    
    @Override
    public List<Product> findIdProduct(Integer filter) {
        return pDAO.findIdProduct(filter);
    }
    
    @Override
    public List<Product> findByProductName(String product) {
        return pDAO.findByProductName(product);
    }
    
    @Override
    public Product findProductbyId(Product product) {
        return pDAO.findProductbyId(product);
    }

    @Override
    public void insertProduct(Product product) {
        pDAO.insertProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        pDAO.deleteProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        pDAO.updateProduct(product);
    }
    
}