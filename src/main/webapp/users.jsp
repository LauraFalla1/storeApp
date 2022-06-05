<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min_1.css" rel="stylesheet" type="text/css"/>
        <title>Users</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
    <body >
        <div class="container " >
            <h1 >Users List</h1>
            <c:if test="${message!=null}">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Well done!</strong> ${message} <a href="#" class="alert-link">this important alert message</a>.
                </div>
            </c:if>
             <form method="POST" action="UserServlet?action=search"> 
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
            <div class="form-group mx-auto w-100 my-5">
                <table class="table table-hover border table-striped">
                    <thead>
                    <form method="POST" action="UserServlet?action=add"> 
                        <tr >
                            <th scope="col">ID</th>
                            <th scope="col">User</th>
                            <th scope="col">Password</th>

                        </tr>
                        <tr>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="ID" id="ID" name="ID">
                                </div></th>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="User" id="User" name="User">
                                </div></th>
                            <th scope="col"><div class="form-group">
                                    <input class="form-control form-control-sm" type="text" placeholder="Password" id="Password" name="Password">
                                </div></th>



                            <th scope="col"><div class="input-group ">
                                    <button class="btn btn-success" type="submit" id="button-addon2" id="add" name="add">Add</button>
                                </div></th>
                        </tr>
                    </form>
                    </thead>
                    <tbody>
                        <c:forEach items="${User}" var="User">
                            <tr class="table-active" >
                                <td>${User.getId()}</td>
                                <td>${User.getUser()}</td>
                                <td>${User.getPwd()}</td>

                                <td><div class="btn-group" role="group" aria-label="Basic example">
                                        <form method="POST" action="throwUpdateUser?filter=${User.getId()}" >   
                                            <button  type="submit" class="btn btn-primary" id="btn-abrir-popup">Update</button>  
                                        </form>  
                                        <form method="POST" action="UserServlet?action=delete">
                                            <input type="hidden" value="${User.getId()}" name="ID"/>
                                            <button type="submit" class="btn btn-primary" id="borrar" name="borrar" class="jsBtn_2">Delete</button>
                                        </form>

                                    </div></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <!-- Button trigger modal -->


                <!-- Modal -->
                <div class="modal fade bg-black text-info text-uppercase text-center " id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">Update users</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <input class="form-control bg-dark text-black text-center form-control-sm my-3" type="text" placeholder="id" id="address" name="id">
                                <input class="form-control bg-dark text-white text-center form-control-sm my-3" type="text" placeholder="id" id="address" name="id">
                                <input class="form-control bg-dark text-white text-center form-control-sm my-3" type="text" placeholder="id" id="address" name="id">
                                <input class="form-control bg-dark text-white text-center form-control-sm my-3" type="text" placeholder="id" id="address" name="id">
                                <input class="form-control bg-dark text-white text-center form-control-sm my-3" type="text" placeholder="id" id="address" name="id">

                            </div>
                            <div class="modal-footer">

                                <button type="button" class="btn btn-primary">Update</button>
                            </div>
                        </div>
                    </div>
                </div>

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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</html>
