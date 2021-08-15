<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New/Edit Account</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Account</h1>
		<form:form action="saveAccount" method="post" modelAttribute="account">
			<table cellpadding="5">
				<form:hidden path="id"/>
				<tr>
					<td>Username:</td>
					<td><form:input path="username"/></td>
				</tr>
				
				<tr>
					<td>Password:</td>
					<td><form:input  path="password"/></td>
				</tr>
				
				<tr>
					<td>Position:</td>
					<td><form:input  path="position"/></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit" value="Save"/></td>
				</tr>
			</table>	
		</form:form>
	</div>
</body>
</html>