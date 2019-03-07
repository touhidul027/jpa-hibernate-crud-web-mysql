<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;
}
</style>


</head>
<body>

<a href="options.mvc" >options</a></p>


	ALL the persons list is on the way. 
     
 
  <c:if test="${not empty persons}">  
    
  <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th>Update</th>
      <th>Delete</th>
     </tr>
  </thead>
  
 <c:forEach var="person" items="${persons }">  
  <tbody>
    <tr>
      <th scope="row">${person.id}</th>
      <td>${person.firstName}</td>
	  <td>${person.lastName}</td>
	  <td><a href="update.mvc?id=${person.id}" >update</a></td>
	  <td><a href="delete.mvc?id=${person.id}">delete</a></td>
    </tr>    
  </tbody>
 </c:forEach>
  
</table>
 </c:if>   
	
</body>
</html>