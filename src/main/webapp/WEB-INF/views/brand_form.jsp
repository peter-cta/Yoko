<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New/Edit Brand</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Brand</h1>
		<form:form action="saveBrand" method="post" modelAttribute="brand">
			<table cellpadding="5">
				<form:hidden path="id"/>
				<tr>
					<td>Name:</td>
					<td><form:input path="name"/></td>
				</tr>
				
				<tr>
					<td>Address:</td>
					<td><form:input  path="address"/></td>
				</tr>
				
				<tr>
					<td>Phone:</td>
					<td><form:input  path="phone"/></td>
				</tr>
				
				<tr>
					<td>Description:</td>
					<td><form:input  path="des"/></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="Save"/></td>
				</tr>
			</table>	
		</form:form>
	</div>
</body>
</html>