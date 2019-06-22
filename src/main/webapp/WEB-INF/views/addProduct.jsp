<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<title>Products</title>
		<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"> 
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Products</h1>
					<p>Add Product</p>
				</div>
			</div>
		</section>
		<section class="container">
			<form:form method="POST" modelAttribute="newProduct" class="form-horizontal">
			<fieldset>
				<legend>Add new Product</legend>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">Product Id</label>
					<div class="col-lg-10">
						<form:input id="productId" path="productId" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productName">productName</label>
					<div class="col-lg-10">
						<form:input id="productName" path="productName" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="manufacturer">manufacturer</label>
					<div class="col-lg-10">
						<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="category">category</label>
					<div class="col-lg-10">
						<form:input id="category" path="category" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitsInStock">unitsInStock</label>
					<div class="col-lg-10">
						<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
					</div>
				</div>
				
				
				<div class="form-group"> 
                     <label class="control-label col-lg-2" 
                      for="description">Description</label> 
                     <div class="col-lg-10"> 
                        <form:textarea id="description" path="description" rows = "2"/> 
                     </div> 
                </div> 
 
                   
               <div class="form-group"> 
                     <label class="control-label col-lg-2" for="unitPrice">Unit Price</label> 
                    <div class="col-lg-10"> 
                        <form:input  id="unitPrice" path="unitPrice" type="text" class="form:input-large"/> 
                     </div> 
               </div>
                  
			   <div class="form-group"> 
                     <label class="control-label col-lg-2" 
                      for="condition">Condition</label> 
                     <div class="col-lg-10"> 
                        <form:radiobutton path="condition" value="New" />New  
                        <form:radiobutton path="condition" value="Old" />Old  
                        <form:radiobutton path="condition" value="Refurbished" />Refurbished 
                     </div> 
               </div>
               
               <div class="form-group"> 
                     <div class="col-lg-offset-2 col-lg-10"> 
                        <input type="submit" id="btnAdd" class="btn 
                         btn-primary" value ="Add"/> 
                     </div> 
               </div>
               
			</fieldset>
			</form:form>
		</section>
	</body>
</html>