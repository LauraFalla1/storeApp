
package data;

import java.util.List;
import models.Customer;
import models.Product;
public interface ProductDAO {
    public List<Product> findAllProduct();
    public List<Product> findAllProduct(String filter);
    public List<Product> findIdProduct(Integer filter);
    public Product findProductbyId(Product product);
    public List<Product> findByProductName(String product);
    public void insertProduct(Product product);
    public void deleteProduct(Product product);
    public void  updateProduct(Product product);
}
