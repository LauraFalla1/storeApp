<%@page import="java.util.List"%>
<%@page import="models.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min_1.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
	<link rel="stylesheet" href="css/estilos.css">
        <title>updateUser</title>
    </head>
    <body>
        <h1>Actualizar Informacion de User</h1>
        <c:if test="${message!=null}">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                    <strong>Well done!</strong> ${message} <a href="#" class="alert-link">this important alert message</a>.
                </div>
        </c:if>
        <c:forEach items="${user}" var="user">
            <form method="POST" action="updateUser?filter=${user.id}"> 
                <table class="table table-hover border table-striped">
                    <th scope="col"><div class="form-group">
                            <label for="Name">ID: </label>
                            <input class="form-control form-control-sm" type="text" placeholder="Id" id="id" name="id" value="${user.id}">
                        </div></th>
                    <th scope="col"><div class="form-group">
                            <label for="Name">User: </label>
                            <input class="form-control form-control-sm" type="text" placeholder="Name" id="user" name="user" value="${user.user}">
                        </div></th>
                    <th scope="col"><div class="form-group">
                            <label for="Name">Password: </label>
                            <input class="form-control form-control-sm" type="text" placeholder="Address" id="pwd" name="pwd" value="${user.pwd}">
                        </div></th>
                    <th scope="col"><div class="input-group mb-1">
                            <button class="btn btn-primary" type="submit" id="button-addon2" id="updateUser" name="updateUser">Actualizar Informacion</button>
                        </div></th>
                </tr>
            </form>           
        </c:forEach>
    </body>
</html>
