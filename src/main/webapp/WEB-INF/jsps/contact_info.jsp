<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contact info</title>
</head>
<body>
     <h2>Contact | Details</h2>
     <hr>
     First Name :${contacts.firstName}  <br>
     Last Name :${contacts.lastName} <br>
     Email :${contacts.email} <br>
     Mobile :${contacts.mobile} <br>
     Source :${contacts.source} <br>
     ${msg}
     
     <form action="compose" method="post">
         <input type="hidden" name="email" value="${lead.email}">
         <input type="submit" value="Send Email">
     </form>
     
     <form action="convertLead" method="post">
         <input type="hidden" name="id" value="${lead.id}">
         <input type="submit" value="Convert">
     </form>
</body>
</html>