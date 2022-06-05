package service;
import java.util.List;
import models.Product;

public interface ProductService {
    public List<Product> findAllProduct();
    public List<Product> findAllProduct(String filter);
    public List<Product> findIdProduct(Integer filter);
    public List<Product> findByProductName(String product);
    public Product findProductbyId(Product product);
    public void insertProduct(Product product);
    public void deleteProduct(Product product);
    public void updateProduct(Product product);
}