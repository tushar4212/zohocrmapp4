<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>compose</title>
</head>
<body>
      <div>
         ${msg}
      </div>
     
      <form action="sendEmail" method="post">
          <pre>
           To <input type="text" name="to" value="${lead.email}">
           Subject <input type="text" name="subject">
           <textarea name="message" rows="5" cols="50"></textarea>
           <input type="submit" value="send">
          </pre>
      </form>
</body>
</html>