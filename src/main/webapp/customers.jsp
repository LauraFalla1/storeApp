<%@page import="java.util.List"%>
<%@page import="models.Customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min_1.css" rel="stylesheet" type="text/css"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
	<link rel="stylesheet" href="css/estilos.css">
        <title>Customers</title>
    </head>
    <body>
        <div class="container">
            <h1 >Customer List</h1>
            <c:if test="${message!=null}">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>¡Your action has been executed successfully!</strong> ${message} <a href="#" class="alert-link">.
                </div>
            </c:if>
             <form method="POST" action="CustomerServlet?action=search"> 
                <div class="form-group">
                    <div class="input-group mb-1">
                        <input type="hidden" id="typeSearch" name="typeSearch" value="1"  />
                        <input type="Number" name="filter" id="filter" class="form-control" placeholder="Buscar" required="" aria-label="Nombre del cliente" aria-describedby="button-addon2">
                        <button class="btn-info" type="submit" id="button-addon2">Search</button>
              
                    </div>
                    <div class="text-center my-3 text-uppercase">
                        
                        <div class="form-check form-check-inline">
                          <input class="form-check-input" onclick="changeValue(1)" checked type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                          <label class="form-check-label" for="inlineRadio1">Id </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" onclick="changeValue(2)" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                          <label class="form-check-label" for="inlineRadio2">User</label>
                        </div>
                 
                    </div>
                                       
                  
                        
                        
              
                </div>
            </form>
            <div class="form-group m-0">
                <table class="table table-hover border table-striped">
                    <thead>
                    <form method="POST" action="add"> 
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Address</th>
                            <th scope="col">City</th>
                            <th scope="col">State</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Mobile</th>
                            <th scope="col">Email</th>
                            <th scope="col">Acción</th>
                        </tr>
                        <tr>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="Id" id="customerID" name="customerID">
                                </div></th>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="Name" id="customerName" name="customerName">
                                </div></th>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="Address" id="address" name="address">
                                </div></th>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="City" id="city" name="city">
                                </div></th>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="State" id="state" name="state">
                                </div></th>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="Phone" id="phone" name="phone">
                                </div></th>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="Mobile" id="mobileno" name="mobileno">
                                </div></th>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="Email" id="email" name="email">
                                </div></th>
                            <th scope="col"><div class="input-group mb-1">
                                    <button class="btn btn-primary" type="submit" id="button-addon2" id="add" name="add">Add</button>
                                </div></th>
                        </tr>
                    </form>
                    </thead>
                    <tbody>
                <c:forEach items="${customers}" var="customer">
                            <tr class="table-active">
                                <td id="customerID_One">${customer.customerID}</td>
                                <td id="">${customer.customerName}</td>
                                <td id="">${customer.address}</td>
                                <td id="">${customer.city}</td>
                                <td id="">${customer.state}</td>
                                <td id="">${customer.phone}</td>
                                <td id="">${customer.mobileno}</td>
                                <td >${customer.email}</td>  
                                
                                <td><div class="btn-group" role="group" aria-label="Basic example">
                                        <form method="POST" action="throwUpdate?filter=${customer.customerID}">  
                                            <button type="submit" class="btn btn-primary" id="btn-abrir-popup">Update</button>  
                                        </form>  
                                        <form method="POST" action="delete?customerId=${customer.customerID}">
                                            <button type="submit" class="btn btn-primary" id="borrar" name="borrar" class="jsBtn_2">Delete</button>
                                        </form>

                                    </div></td> 
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    
    <script>
        const filter = document.getElementById("filter");

        function changeValue (value){
            
            document.getElementById("typeSearch").value = value;
            if(value==2){
               filter.removeAttribute("type");
               filter.setAttribute("type","Text");
            }else{
                filter.removeAttribute("type");
               filter.setAttribute("type","Number");
            }
            
        }
    </script>    
    
</html>
