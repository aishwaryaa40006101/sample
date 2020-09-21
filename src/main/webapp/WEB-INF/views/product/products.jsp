<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  border-collapse: collapse;
  padding-top:50%;
  width: 50%;
}
a:hover{
color:red;
}

th, td {
  text-align: center;
  padding: 8px;
  border-bottom: 1px solid #ddd;
  
}

tr td:nth-child(1n+2)
{padding-left:35px;
}
tr:hover {background-color: #f5f5f5;}

th {
  background-color: #4CAF50;
  color: white;
}
table, th, td {
  
}
.button {
  background-color: #99bbff;
  border: none;
  color: black;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  margin: 4px 2px;
  cursor: pointer;

}

.button2 {
  background-color: #b9bdc6;
  border: none;
  color: black;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  margin: 4px 2px;
  cursor: pointer;
}

.button3{
 background-color: #99bbff;
 size="25%";
  border: none;
  color: black;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  font-size: 20px;
  margin:auto;
  display:block;
  width:155px;
}
</style>




<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
	
<h3 align="center">PRODUCTS LIST</h3>
<br/>
<br/>
<div>
<a href="${pageContext.request.contextPath}/product/index" class="button3" >Back</a><br>
</div>
<br/>
<br/>
<br/>
<table align="center" >
	<tr>
	<th style="background-color: #1f7a1f;">Product ID</th>
	<th style="background-color: #1f7a1f;">Product Name</th>
	<th style="background-color: #1f7a1f;">Product Cost</th>
	<th style="background-color: #1f7a1f;">Action</th>
	<th style="background-color: #1f7a1f;">Action</th>
	</tr>
	<c:forEach var="product" items="${products}">
	<tr>
	<td>${product.id}</td>
		<td>${product.name}</td>	
			<td>${product.cost}</td>
					
	<td><a href="${pageContext.request.contextPath}/product/update/${product.id}"class="button2" >Update Details</a>
		<td><a href="${pageContext.request.contextPath}/product/delete/${product.id}"class="button2" onClick="return confirm('Are you sure?')">Delete</a>
		
	</td>
	
	
	</tr>
	</c:forEach>
</table>


</body>
</html>