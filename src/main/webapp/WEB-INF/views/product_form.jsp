<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New/Edit Product</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Product</h1>
		<form:form action="saveProduct" method="post" modelAttribute="product">
			<table cellpadding="5">
				<form:hidden path="id"/>
				<tr>
					<td>Name:</td>
					<td><form:input path="name"/></td>
				</tr>
				
				<tr>
					<td>Image:</td>
					<td><form:input type="file"  path="img"/></td>
				</tr>
				
				<tr>
					<td>Price:</td>
					<td><form:input path="price"/></td>
				</tr>
				
				<tr>
					<td>Description:</td>
					<td><form:input path="des"/></td>
				</tr>
				
				<tr>
					<td>Brand:</td>
					<td><form:input path="brandID"/></td>
				</tr>

				
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Save"/></td>
				</tr>
			</table>	
		</form:form>
	</div>
</body>
</html>