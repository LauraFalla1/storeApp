<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min_1.css" rel="stylesheet" type="text/css"/>
        <title>Sales</title>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
    <body class="text-info">
        <div class="container w-100 mx-auto bg-gradient "  >
            <h1 >Sales List </h1>
            <c:if test="${message!=null}">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Well done!</strong> ${message} <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </c:if>
            
            <form method="POST" action="SalesServlet?action=search">
                <div class="form-group">
                    <div class="input-group mb-1">
                        <input type="Number" name="filter" required="" id="filter" class="form-control" placeholder="Buscar" aria-label="Nombre del cliente" aria-describedby="button-addon2">
                        <select id="selectInput" onchange="changeInput()" name="typeSearch" class="bg-primary text-white text-center text-uppercase">
                            <option value="1" selected>ID</option>
                            <option value="2">Customer_ID</option>
                        </select>
                        <button class="btn-info" type="submit" id="button-addon2">Search</button>
                    </div>
                </div>
            </form>
            <div class="form-group mx-auto w-100 my-5">
                <table class="table table-hover  text-white text-center border table-striped">
                    <thead>
                        <tr >
                            <th scope="col">ID</th>
                            <th scope="col">CustomerID</th>
                            <th scope="col">ProductID</th>
                            <th scope="col">Cant</th>
                            <th scope="col">Price</th>
                            <th scope="col">Options</th>
                         
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Sales}" var="Sales">
                   
                            <tr class="table-active">
                                <td>${Sales.getSaleID()}</td>
                                <td>${Sales.getCustomerId()}</td>                              
                                <td>
                                     
                                    <table class="table table-hover border table-striped bg-white ">
                                        <thead>
                                           <th scope="col"> Product Name</th>
                                           <th scope="col" >Cantidad</th>
                                           <th scope="col" >Price</th>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${carroAll}" var="car">
                                            <c:if test="${car.getSalesID() == Sales.getSaleID()}">
                                                <tr class="table-active text-center " style="height: 30px; overflow:scroll;">
                                                <td class="text-center ">${car.productName}</td>
                                                <td class="text-center ">${car.cantidad}</td>
                                                <td class="text-center ">${car.cantidad * car.precio}</td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>    
                                        </tbody>
                                        
                                    </table>
                                </td>
                                <td >${Sales.getCant()}</td>
                                <td >${Sales.getPrice()}</td>
                         
                                <td><div class="btn-group" role="group" aria-label="Basic example">
                                      
                                         
                                   
                                        <form method="POST" action="SalesServlet?action=delete">
                                            <input type="hidden" value="${Sales.getSaleID()}" name="SaleID"/>
                                        <button type="submit" class="btn btn-primary " id="borrar" name="borrar">Delete</button>
                                        </form>

                                    </div></td> 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                
                <!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade bg-black text-info text-uppercase text-center " id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <form class="modal-dialog" method="POST" action="SalesServlet?action=update">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Update Sales</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
         <input class="form-control bg-dark text-white text-center form-control-sm my-3" type="text" placeholder="ID" id="SalesID" name="SalesID">
         <input class="form-control bg-dark text-white text-center form-control-sm my-3" type="text" placeholder="CustomerID" id="CustomerID" name="CustomerID">
         <input class="form-control bg-dark text-white text-center form-control-sm my-3" type="text" placeholder="ProductID" id="ProductID" name="ProductID">
         <input class="form-control bg-dark text-white text-center form-control-sm my-3" type="text" placeholder="CANT" id="CANT" name="CANT">
         <input class="form-control bg-dark text-white text-center form-control-sm my-3" type="text" placeholder="Price" id="price" name="price">
        
      </div>
      <div class="modal-footer">
        
        <button type="submit" class="btn btn-primary">Update</button>
      </div>
    </div>
  </form>
</div>

            </div>
        </div>
    </body>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>


</html>
