<%@page import="java.util.List"%>
<%@page import="models.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min_1.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
	<link rel="stylesheet" href="css/estilos.css">
        <title>updateCustomer</title>
    </head>
    <body>
        <h1>Actualizar Informacion de Product</h1>
        <c:if test="${message!=null}">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Well done!</strong> ${message} <a href="#" class="alert-link">this important alert message</a>.
                </div>
        </c:if>
        <c:forEach items="${products}" var="product">
            <form method="POST" action="updateProduct?filter=${product.productId}"> 
                <table class="table table-hover border table-striped">
                    <th scope="col"><div class="form-group">
                            <label for="Name">ID: </label>
                            <input class="form-control form-control-sm" type="text" placeholder="Id" id="productID" name="productID" value="${product.productId}">
                        </div></th>
                    <th scope="col"><div class="form-group">
                            <label for="Name">Name: </label>
                            <input class="form-control form-control-sm" type="text" placeholder="Name" id="productName" name="productName" value="${product.productName}">
                        </div></th>
                    <th scope="col"><div class="form-group">
                            <label for="Name">Address: </label>
                            <input class="form-control form-control-sm" type="text" placeholder="Address" id="categoryID" name="categoryID" value="${product.categoryId.categoryName}">
                        </div></th>
                    <th scope="col"><div class="input-group mb-1">
                            <button class="btn btn-primary" type="submit" id="button-addon2" id="update" name="update">Actualizar Informacion</button>
                        </div></th>
                </tr>
            </form>           
        </c:forEach>
    </body>
</html>
