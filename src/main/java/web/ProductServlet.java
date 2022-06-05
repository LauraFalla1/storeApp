
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ProductService;
import models.Product;
import models.Category;
import service.CategoryService;


@WebServlet(name = "ProductServlet", urlPatterns = {"/addProduct","/deleteProduct","/throwUpdateProduct","/updateProduct","/store"})
public class ProductServlet extends HttpServlet {

    
    @Inject
    ProductService cService;
    
    @Inject
    CategoryService catService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(req, resp);
        String action = request.getParameter("action");
        
        if (action == null){
             action=request.getServletPath();
            }
        //String filter = request.getParameter("filter");
        System.out.println("Action CS:" + action);
        switch (action) {
            case "products":
                listAllProduct(request, response);
                break;
            case "/addProduct":
                insertProduct(request, response);
                break;
            case "/throwUpdateProduct":
                throwUpdateProduct(request, response);
                break;
            case "/updateProduct":
                updateProduct(request, response);
                break;
            case "/deleteProduct":
                deleteProduct(request, response);
                listAllProduct(request, response);
                break;
            case "search" : searchBar(request, response);
                break;
        }
        listAllProduct(request, response);
        return;
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
             action=request.getServletPath();
            }
        //String filter = request.getParameter("filter");
        System.out.println("Action GET ProductServlet:" + action);
        switch (action) {
            case "products":
                listAllProduct(request, response);
                
                break;
            case "/addProduct":
                insertProduct(request, response);
                break;
            case "/throwUpdateProduct":
                throwUpdateProduct(request, response);
                break;
            case "/updateProduct":
                updateProduct(request, response);
                System.out.println("recibio");
                break;
            case "deleteProduct":
                deleteProduct(request, response);
                listAllProduct(request, response);
                break;
            case "search" : searchBar(request, response);
                break;
        }
        listAllProduct(request, response);
        return;

    }

    protected void listAllProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        if (filter == null) {
            filter = "";
        }
        List<Product> c = cService.findAllProduct(filter);
        request.setAttribute("products", c);
        request.getRequestDispatcher("/products.jsp").forward(request, response);
        
        return;
    }
    
    protected void searchBar(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
    
     String filter = request.getParameter("filter");
     int typeSearch = Integer.parseInt(request.getParameter("typeSearch"));
     Product usuario = new Product();
     List<Product> listProduct  = new ArrayList<>();
     if(filter==""){
       request.setAttribute("message","<h3 style=`color:red;`>Error empty input can´t be found!</h3>");
            request.setAttribute("products", listProduct);
            request.getRequestDispatcher("/products.jsp").forward(request, response);
            return ;
     }
     switch(typeSearch){
         case 1 : {
          usuario.setProductId(Integer.parseInt(filter));
          if(cService.findProductbyId(usuario)!= null){
                listProduct.add(cService.findProductbyId(usuario));
          }
          request.setAttribute("message","sucess!");
          
         }; break;
         case 2 : {
             listProduct = cService.findAllProduct(filter);
            request.setAttribute("message","sucess " + listProduct.size() + " have been found!");
         };break;
         default : {
                 request.setAttribute("message","<h3 style=`color:red;`>Error!</h3>");
                 };break;
                 
     }
                 request.setAttribute("products", listProduct);
            request.getRequestDispatcher("/products.jsp").forward(request, response);
           return;
    }
    
    protected void categoryNames(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        if (filter == null) {
            filter = "";
        }
        List<Category> cat = catService.findAllCategory();
        request.setAttribute("categorys", cat);
        request.getRequestDispatcher("/products.jsp").forward(request, response);
        return;
    }

    protected void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> cat = catService.findAllCategory();
        Product c = new Product();
        c.setProductId(Integer.parseInt(request.getParameter("productID")));
        c.setProductName(request.getParameter("productName"));
        c.setPrice(request.getParameter("price"));
        String categoryName = request.getParameter("category");
        System.out.println(categoryName);
        if(categoryName.equals("Zapatos Hombre")){
            System.out.println("entro al if de hombre");
            c.setCategoryId(cat.get(0));
        } else if (categoryName.equals("Zapatos Mujer")) {
            c.setCategoryId(cat.get(1));
        }
        cService.insertProduct(c);
        request.setAttribute("message","Product successfully added!");
    }

    protected void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product c = new Product();
        String productId=request.getParameter("productId");
        c.setProductId(Integer.parseInt(productId));
        System.out.println("delete.productId: "+productId);
        c = cService.findProductbyId(c);
        if (c != null) {
            cService.deleteProduct(c);
            request.setAttribute("message", "Product successfully deleted!");
        }
        else {
            request.setAttribute("message", "Error id delete Customer!");
        }
    }
    
    protected void throwUpdateProduct(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        if (filter == null) filter = "";
        List<Product> c = cService.findIdProduct(Integer.parseInt(filter));
        System.out.println();
        request.setAttribute("products", c);
        request.getRequestDispatcher("/updateProduct.jsp").forward(request, response);
        return;
    }
    
    protected void updateProduct(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Category> cat = catService.findAllCategory();
        Product c = new Product();
        c.setProductId(Integer.parseInt(request.getParameter("productID")));
        c.setProductName(request.getParameter("productName"));
        String categoryName = request.getParameter("categoryID");
        System.out.println(categoryName);
        if(categoryName.equals("Zapatos Hombre")){
            System.out.println("entro al if de hombre");
            c.setCategoryId(cat.get(0));
        } else if (categoryName.equals("Zapatos Mujer")) {
            c.setCategoryId(cat.get(1));
        }
        cService.updateProduct(c);
        System.out.println(c.getProductId());
        System.out.println(c.getProductName());
        request.setAttribute("message","Product successfully Update!");
        
        
        List<Product> cus = cService.findAllProduct();
        request.setAttribute("products", cus);
        request.getRequestDispatcher("/products.jsp").forward(request, response);
        return;
    }

}
