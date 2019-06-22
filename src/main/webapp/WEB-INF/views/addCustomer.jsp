<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>Customer</title>
		<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"> 
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Customer</h1>
					<p>Add User Detail</p>
				</div>
			</div>
		</section>
		<section class="container">
			<form:form method="POST" modelAttribute="newCustomer" class="form-horizontal">
				<fieldset>
					<legend>Add new Customer</legend>	
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="CustomerId">Customer Id</label>
						<div class="col-lg-10">
							<form:input id="customerId" path="customerId" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="CustomerName">Customer Name</label>
						<div class="col-lg-10">
							<form:input id="customerName" path="customerName" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="CustomerAddress">Customer Address</label>
						<div class="col-lg-10">
							<form:input id="customerAddress" path="customerAddress" type="text" class="form:input-large"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="noOfOrdersmade">Order</label>
						<div class="col-lg-10">
							<form:input id="noOfOrdersMade" path="noOfOrdersMade" type="number" class="form:input-large"/>
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