<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
      <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>all contacts</title>
</head>
<body>
    <h2>Contact | List</h2>
    <form action="listcontacts" method="post">
    <table>
         <tr>
         <th>First Name</th>
         <th>Last Name</th>
         <th>Email</th>
         <th>Mobile</th>
         <th>Source</th>
         </tr>
         <c:forEach var = "contact" items="${contacts}">
             <tr>
             <td><a href="contactInfo?id=${contact.id}">${contact.firstName}</a></td>
             <td>${contact.lastName}</td>
             <td>${contact.email}</td>
             <td>${contact.mobile}</td>
             <td>${contact.source}</td>
             </tr>
         </c:forEach>
    </table>
    
    </form>
</body>
</html>