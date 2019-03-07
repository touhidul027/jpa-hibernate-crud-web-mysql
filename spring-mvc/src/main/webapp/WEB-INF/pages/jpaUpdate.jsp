<%@ page contentType="text/html; charset=ISO-8859-1" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<a href="options.mvc" >options</a></p>

<h2>User Registration Form</h2>

<mvc:form method="POST" modelAttribute="person" action="doUpdate.mvc" >
	<table>
		<tr>
	        <td><mvc:label path="id">id</mvc:label></td>
	        <td> <mvc:input path="id" /> </td>
	    </tr>
	   
	    <tr>
	        <td><mvc:label path="firstName">First Name</mvc:label></td>
	        <td><mvc:input path="firstName" /></td>
	    </tr>
	    
	    <tr>
	        <td><mvc:label path="lastName">Last Name</mvc:label></td>
	        <td><mvc:input path="lastName" /></td>
	    </tr>
	     
        <tr>
	        <td colspan="2">
                <input type="submit" value="Submit" />
	        </td>
	    </tr>
	</table>  
</mvc:form>
 
		
</body>
</html>