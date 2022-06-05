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

import models.User;
import service.UserService;
 


@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet","/updateUser","/throwUpdateUser","/adduser" })
public class UserServlet extends HttpServlet {

    @Inject
    private UserService uService;
          
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        System.out.println(request.getParameter("action"));
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             String action = request.getParameter("action");
        if (action == null){
             action=request.getServletPath();
            }
        //String filter = request.getParameter("filter");
        //System.out.println("Action CS:" + action);
        switch (action) {
            case "users" : { 
                List<User> Lp = uService.findAllUser();
            request.setAttribute("User", Lp);
            request.getRequestDispatcher("/users.jsp").forward(request, response);
        };break;
            case "/adduser":
                addUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            case "/updateUser":
                updateUser(request, response);
                break;
            case "/throwUpdateUser":
                throwUpdateUser(request, response);
                break;
            case "search":searchBar(request, response);
                break;
        }
       
      

       return;
        }
        
        
    }
    
    protected void searchBar(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
    
     String filter = request.getParameter("filter");
     int typeSearch = Integer.parseInt(request.getParameter("typeSearch"));
     User usuario = new User();
     List<User> listUser  = new ArrayList<>();
     if(filter==""){
       request.setAttribute("message","<h3 style=`color:red;`>Error empty input can´t be found!</h3>");
            request.setAttribute("User", listUser);
            request.getRequestDispatcher("/users.jsp").forward(request, response);
            return ;
     }
     switch(typeSearch){
         case 1 : {
          usuario.setId(Integer.parseInt(filter));
          if(uService.findAllUserByID(usuario)!= null){
                listUser.add(uService.findAllUserByID(usuario));
          }
          request.setAttribute("message","sucess!");
          
         }; break;
         case 2 : {
             listUser = uService.findAllUser(filter);
            request.setAttribute("message","sucess " + listUser.size() + " have been found!");
         };break;
         default : {
                 request.setAttribute("message","<h3 style=`color:red;`>Error!</h3>");
                 };break;
                 
     }
                 request.setAttribute("User", listUser);
            request.getRequestDispatcher("/users.jsp").forward(request, response);
           return;
    }
 
 protected void addUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User U  = new User();
        PrintWriter out  = response.getWriter();
       
        U.setId(Integer.parseInt(request.getParameter("ID")));
        U.setUser(request.getParameter("User"));
        U.setPwd(request.getParameter("Password"));
        
        uService.insertUser(U);
         request.setAttribute("message","User successfully added!");
        }
 
   protected void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        User U = new User();
        String userId =request.getParameter("ID");
        PrintWriter out = response.getWriter();

        U.setId(Integer.parseInt(userId));
               

        U = uService.findAllUserByID(U);
      
        
        if (U != null) {
            uService.deleteUser(U);
            request.setAttribute("message", "User successfully deleted!");
        }
        else {
            request.setAttribute("message", "Error id delete User!");
        }
        
        List<User> u = uService.findAllUser();
            request.setAttribute("User", u);
                     request.getRequestDispatcher("/users.jsp").forward(request, response);

       return;

    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
      protected void throwUpdateUser(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String filter = request.getParameter("filter");
        if (filter == null) filter = "";
        List<User> u = uService.findIdUser(Integer.parseInt(filter));
        System.out.println();
        request.setAttribute("user", u);
        request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
        return;
    }
    protected void updateUser(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        User u = new User();
        u.setId(Integer.parseInt(request.getParameter("id")));
        u.setUser(request.getParameter("user"));
        u.setPwd(request.getParameter("pwd"));
        uService.updateUser(u);
        System.out.println(u.getUser());
        System.out.println(u.getPwd());
        request.setAttribute("message","User successfully Update!");
        
        List<User> cus = uService.findAllUser();
        request.setAttribute("User", cus);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
        return;
   
    }
  
    
    
}