<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    </head>
    <body class="bg-transparent " >
        <div class="modal fade text-info text-uppercase text-center " id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <form class="modal-dialog bg" method="POST" action="SalesServlet?action=add">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Sales</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body ">
                        <input type="Number" placeholder="Sale Id" name="SalesID" required></input>
                        <br>
                        <label for="customersId">Customers</label>
                        <br>
                        <select name="CustomerID" required class="text-center form-input form-group my-3">
                            <c:forEach items="${customers}" var="c">
                                <option class="text-uppercase text-start" value="${c.customerID}">ID: ${c.customerID}  NAME : ${c.customerName} </option>
                            </c:forEach>
                        </select>
                        <table class="table table-hover border table-striped">
                            <thead>
                                <tr class="text-center text-info">
                                    <th scope="col"> Product Name</th>
                                    <th scope="col" >Cantidad</th>
                                    <th scope="col" >Price</th>

                                </tr>  
                                <c:forEach items="${carro}" var="car">
                                    <tr class="table-active" style="height: 30px; overflow:scroll;">
                                        <td class="text-dark">${car.productName}</td>
                                        <td class="text-dark">${car.cantidad}</td>
                                        <td class="text-dark">${car.cantidad * car.precio}</td>
                                    </tr>
                                </c:forEach>


                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" id="sales" name="sales"  >BUY</button>
                    </div>
                </div>
            </form>
        </div>

       
        <button  class=" btn btn-primary mx-2 my-3 position-relative "   data-bs-toggle="modal" data-bs-target="#staticBackdrop">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="white" class="bi bi-cart" viewBox="0 0 16 16">
            <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
            </svg>
            <path fill-rule="evenodd" d="M11.5 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L11 2.707V14.5a.5.5 0 0 0 .5.5zm-7-14a.5.5 0 0 1 .5.5v11.793l3.146-3.147a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 .708-.708L4 13.293V1.5a.5.5 0 0 1 .5-.5z"/>
            </svg>
            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                <c:if test="${carro!=null}">
                    ${carro.size()}
                </c:if>
                <c:if test="${carro==null}">
                    0
                </c:if>
                <span class="visually-hidden">unread messages</span>
            </span>
        </button>





    </div>          

    <div class="d-flex flex-wrap  text-center p-3 text-white justify-content-center">

        <c:forEach items="${Products}" var="Product">

            <form class="card mx-2 my-2 bg-info text-white text-uppercase shadow"  style="width: 18rem;" method="POST" action="PSelectServlet?action=addToCar">
                <div class="card-body bg-opacity-10 "  >
                    <h5 class="card-title">${Product.getProductName()}</h5>
                    <p>${product.getPrice()}</p>
                    <h6 class="card-subtitle mb-2 text-white">${Product.getCategoryId().getCategoryName()}</h6>
                    
                    <input class="form-control form-control-sm" type="hidden"  id="id" name="id" value="${Product.getProductId()}">
                    <input class="form-control form-control-sm" type="hidden"  id="pn" name="pn" value="${Product.getProductName()}">
                    <input class="form-control form-control-sm" type="hidden" placeholder="Quantity" id="p" name="p"  value="${Product.getPrice()}">
                    <input class="form-control form-control-sm" type="Number" placeholder="Put the quantity here!" id="c" name="c" required>
                </div>                       
                <button type="submit" class="btn btn-primary">BUY</button>

            </form>


        </c:forEach>


    </div>

</body>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</html>
