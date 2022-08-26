<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "menu.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Update Customer</title>
</head>
<body>
  
     <h2>Update customer</h2>
     
     <form action= "updateCustomer" method="post">
     <pre>
                    <input type="hidden" name= "id" value= "${customer.id}" />     
         First Name <input type= "text" name= "firstName" value= "${customer.firstName}"/>
         
         Last Name  <input type= "text" name= "lastName" value= "${customer.lastName}"/>
         
         Email      <input type= "text" name= "email" value= "${customer.email}"/>
         
         Mobile     <input type= "text" name= "mobile" value= "${customer.mobile}"/>
         
                    <input type= "submit" value= "update"/>
     
     </pre>
       </form>
       ${msg}
  
</body>

</html>