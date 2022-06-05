package service;

import data.CategoryDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import models.Category;

@Stateless
public class CategoryServiceImp implements CategoryService{
    
    @Inject
    private CategoryDAO pDAO;

    @Override
    public List<Category> findAllCategory() {
        return pDAO.findAllCategory();
    }
    
    @Override
    public List<Category> findAllCategory(String filter) {
        return pDAO.findAllCategory(filter);
    }
//    
//    
//    @Override
//    public List<Category> findCategorybyId() {
//        return pDAO.findCategorybyId();
//    }

    @Override
    public void insertCategory(Category category) {
        pDAO.insertCategory(category);
    }

    @Override
    public void deleteCategory(Category category) {
        pDAO.deleteCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        pDAO.updateCategory(category);
    }
    
}

