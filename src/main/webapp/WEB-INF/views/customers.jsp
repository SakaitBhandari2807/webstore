<%@ taglib prefix="c" 
        uri="http://java.sun.com/jsp/jstl/core"%> 
 
        <html> 
        <head> 
        <meta http-equiv="Content-Type" content="text/html; 
        charset=ISO-8859-1"> 
        <link rel="stylesheet" 
   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> 
        <title>Products</title> 
        </head> 
        <body> 
           <section> 
              <div class="jumbotron"> 
                 <div class="container"> 
                    <h1>Products</h1> 
                    <p>All the available products in our store</p> 
                 </div> 
              </div> 
           </section> 
 
           <section class="container"> 
              <div class="row"> 
                 <c:forEach items="${customers}" var="customer"> 
                    <div class="col-sm-6 col-md-3"> 
                       <div class="thumbnail"> 
                          <div class="caption"> 
                             <h3>${customer.customerId}</h3> 
                             <p>${customer.customerName}</p> 
                             <p>${customer.customerAddress}</p> 
                             <p>Ordered :${customer.noOfOrdersMade} Items</p> 
                          </div> 
                       </div> 
                    </div> 
                 </c:forEach>
              </div> 
           </section> 
        </body> 
        </html>