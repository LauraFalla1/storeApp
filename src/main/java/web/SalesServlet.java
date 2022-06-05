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
import javax.servlet.http.HttpSession;
import models.Carro;
import models.Sales;
import service.CarroService;
import service.SalesService;


@WebServlet(name = "SalesServlet", urlPatterns = {"/SalesServlet"})
public class SalesServlet extends HttpServlet {

    @Inject
    private SalesService sService;
    
    @Inject
    private CarroService cService;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null){
             action=request.getServletPath();
            }
        PrintWriter out  = response.getWriter();
        out.print(action);
        //String filter = request.getParameter("filter");
        //System.out.println("Action CS:" + action);
        switch (action) {
            case "sales" : { 
            List<Sales> Lp = sService.findAllSales();
            request.setAttribute("Sales", Lp);
            request.getRequestDispatcher("/sales.jsp").forward(request, response);
        };break;
            case "add":
                addSales(request, response);
                break;
            case "delete":
                deleteSales(request, response);
                break;
            case "update":
                updateSales(request, response);
                break;
            case "search": searchBar(request, response);
                break;
        }
       
        List<Sales> Lp = sService.findAllSales();
            request.setAttribute("carroAll",cService.findAllCarro());
            request.setAttribute("Sales", Lp);
            request.getRequestDispatcher("/sales.jsp").forward(request, response);
       return;
       
    }
    
    
    
    // Metodos 
    protected void searchBar(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
    
     String filter = request.getParameter("filter");
     int typeSearch = Integer.parseInt(request.getParameter("typeSearch"));
     Sales ventas = new Sales();
     List<Sales> listSales  = new ArrayList<>();
     if(filter==""){
       request.setAttribute("message","<h3 style=`color:red;`>Error empty input can´t be found!</h3>");
            request.setAttribute("Sales", listSales);
            request.getRequestDispatcher("/sales.jsp").forward(request, response);
            return ;
     }
     switch(typeSearch){
         case 1 : {
          ventas.setSaleID(Integer.parseInt(filter));
          if(sService.findSalesbyId(ventas)!= null){
                listSales.add(sService.findSalesbyId(ventas));
          }
          request.setAttribute("message","sucess!");
          
         }; break;
         case 2 : {
          listSales = sService.findSalesbyCustomerID(filter);
            request.setAttribute("message","sucess " + listSales.size() + " have been found!");
         };break;
         default : {
                 request.setAttribute("message","<h3 style=`color:red;`>Error!</h3>");
                 };break;
                 
     }
            request.setAttribute("Sales", listSales);
            request.getRequestDispatcher("/sales.jsp").forward(request, response);
           return;
                           

 
 }
    
 protected void addSales(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Sales S  = new Sales();
        int price=0;
        int cantidad=0;
        PrintWriter out  = response.getWriter();
        HttpSession session = request.getSession();
        List<Carro> carro =  (List<Carro> ) session.getAttribute("carro");
        S.setSaleID(Integer.parseInt(request.getParameter("SalesID")));
        S.setCustomerId(request.getParameter("CustomerID"));
        for(int i=0;i<carro.size();i++){
            carro.get(i).setSalesID(S.getSaleID());
            cService.addCarro(carro.get(i));
            price+=carro.get(i).getCantidad() * Integer.parseInt(carro.get(i).getPrecio());
            cantidad+= carro.get(i).getCantidad();
        }
        S.setPrice(""+price);
        S.setCant(cantidad);
        session.removeAttribute("carro");
        sService.insertSales(S);
          request.setAttribute("message","Sales successfully added!");
        }
 
  protected void updateSales(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Sales S  = new Sales();
        PrintWriter out  = response.getWriter();
        HttpSession session = request.getSession();
        List<Carro> carro =  (List<Carro> ) session.getAttribute("carro");
        S.setSaleID(Integer.parseInt(request.getParameter("SalesID")));
        S.setCustomerId(request.getParameter("CustomerID"));
        S.setCant(Integer.parseInt(request.getParameter("CANT")));
        

        
        sService.updateSales(S);
          request.setAttribute("message","Sales successfully updated!");
        }
 
 
   protected void deleteSales(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       Sales S = new Sales();
        String saleId=request.getParameter("SaleID") ;
        PrintWriter out = response.getWriter();
      
        S.setSaleID(Integer.parseInt(saleId));
        System.out.println("delete.SaleID: "+saleId);
        S = sService.findSalesbyId(S);
        
        if (S != null) {
            sService.deleteSales(S);
            request.setAttribute("message", "Sales successfully deleted!");
        }
        else {
            request.setAttribute("message", "Error id delete Product!");
        }
        

    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   
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

}
