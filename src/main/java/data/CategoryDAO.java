
package data;
import java.util.List;
import models.Category;

public interface CategoryDAO {
    public List<Category> findAllCategory();
    public List<Category> findAllCategory(String filter);
//    public List<Category> findCategorybyId();
    public void insertCategory(Category category);
    public void deleteCategory(Category category);
    public void updateCategory(Category category);
}
