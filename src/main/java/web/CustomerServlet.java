
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
import models.Customer;
import service.CustomerService;


@WebServlet(name = "CustomerServlet", urlPatterns = {"/store","/add","/delete","/throwUpdate","/update"})
public class CustomerServlet extends HttpServlet {

    @Inject
    CustomerService cService;

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
            case "customers":
                listCustomers(request, response);
                break;
            case "/add":
                insertCustomer(request, response);
                break;
            case "/throwUpdate":
                throwUpdateCustomer(request, response);
                break;
            case "/update":
                updateCustomer(request, response);
                break;
            case "/delete":
                deleteCustomer(request, response);
                //listAllCustomers(request, response);
                break;
            case "search":
                searchBar(request, response);
        }
        listCustomers(request, response);
        //return;
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
             action=request.getServletPath();
            }
        //String filter = request.getParameter("filter");
        //System.out.println("Action CS:" + action);
        switch (action) {
            case "customers":
                listCustomers(request, response);
                break;
            case "/add":
                insertCustomer(request, response);
                break;
            case "/throwUpdate":
                throwUpdateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                listAllCustomers(request, response);
                break;
            case "search":
                searchBar(request, response);
        }
        listCustomers(request, response);
        //return;

    }

    protected void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        //System.out.println(filter);
        if (filter == null) filter = "";
        List<Customer> c = cService.findAllCustomer(filter);
        request.setAttribute("customers", c);
        request.getRequestDispatcher("/customers.jsp").forward(request, response);
        return;
    }
    protected void listAllCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        //System.out.println(filter);
        if (filter == null) {
            filter = "";
        }
        List<Customer> c = cService.findAllCustomer(filter);
        request.setAttribute("customers", c);
        request.getRequestDispatcher("/customers.jsp").forward(request, response);
        return;
    }
    
    protected void searchBar(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
    
     String filter = request.getParameter("filter");
     int typeSearch = Integer.parseInt(request.getParameter("typeSearch"));
     Customer usuario = new Customer();
     List<Customer> listCustomer  = new ArrayList<>();
     if(filter==""){
       request.setAttribute("message","<h3 style=`color:red;`>Error empty input can´t be found!</h3>");
            request.setAttribute("customers", listCustomer);
            request.getRequestDispatcher("/customers.jsp").forward(request, response);
            return ;
     }
     switch(typeSearch){
         case 1 : {
          usuario.setCustomerID(filter);
          if(cService.findCustomerbyId(usuario)!= null){
                listCustomer.add(cService.findCustomerbyId(usuario));
          }
          request.setAttribute("message","sucess!");
          
         }; break;
         case 2 : {
             listCustomer = cService.findAllCustomer(filter);
            request.setAttribute("message","sucess " + listCustomer.size() + " have been found!");
         };break;
         default : {
                 request.setAttribute("message","<h3 style=`color:red;`>Error!</h3>");
                 };break;
                 
     }
                 request.setAttribute("customers", listCustomer);
            request.getRequestDispatcher("/customers.jsp").forward(request, response);
           return;
    }

    protected void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Customer c = new Customer();
        c.setCustomerID(request.getParameter("customerID"));
        c.setCustomerName(request.getParameter("customerName"));
        c.setAddress(request.getParameter("address"));
        c.setCity(request.getParameter("city"));
        c.setState(request.getParameter("state"));
        c.setPhone(Long.parseLong(request.getParameter("phone")));
        c.setMobileno(Long.parseLong(request.getParameter("mobileno")));
        c.setEmail(request.getParameter("email"));
        c.setNotes("");
        cService.insertCustomer(c);
        request.setAttribute("message","Customer successfully added!");
        

    }

    protected void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Customer c = new Customer();
        String customerId=request.getParameter("customerId");
        c.setCustomerID(customerId);
        System.out.println("delete.customerId: "+customerId);
        c = cService.findCustomerbyId(c);
        if (c != null) {
            cService.deleteCustomer(c);
            request.setAttribute("message", "Customer successfully deleted!");
        }
        else {
            request.setAttribute("message", "Error id delete Customer!");
        }
        
        
        //doGet(request, response);
    }
    
    protected void throwUpdateCustomer(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        //System.out.println(filter);
        if (filter == null) filter = "";
        List<Customer> c = cService.findIdCustomer(filter);
        System.out.println();
        request.setAttribute("customers", c);
        request.getRequestDispatcher("/updateCustomer.jsp").forward(request, response);
        return;
    }
    
    protected void updateCustomer(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        Customer c = new Customer();
        c.setCustomerID(request.getParameter("customerID"));
        c.setCustomerName(request.getParameter("customerName"));
        c.setAddress(request.getParameter("address"));
        c.setCity(request.getParameter("city"));
        c.setState(request.getParameter("state"));
        c.setPhone(Long.parseLong(request.getParameter("phone")));
        c.setMobileno(Long.parseLong(request.getParameter("mobileno")));
        c.setEmail(request.getParameter("email"));
        c.setNotes("");
        cService.updateCustomer(c);
        System.out.println(c.getCustomerID());
        System.out.println(c.getCustomerName());
        request.setAttribute("message","Customer successfully Update!");
        
        
        List<Customer> cus = cService.findAllCustomer();
        request.setAttribute("customers", cus);
        request.getRequestDispatcher("/customers.jsp").forward(request, response);
        return;
    }
}
