<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "menu.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Customer</title>
</head>
<body>
    <h2>List Of Customers</h2>
    
    <table>
      <tr>
      <th>First Name </th>
      <th>Last Name </th>
      <th>Email </th>
      <th>Mobile Number </th>
      <th>Delete </th>
      <th>Update </th>
      </tr>
    
    <c:forEach var = "customer" items= "${customers}">
    
    <tr>
      <td>${customer.firstName} </td>
      <td>${customer.lastName}  </td>
      <td>${customer.email}  </td>
      <td>${customer.mobile}  </td>
      <td> <a href="delete?id=${customer.id}">delete</a>    </td>
      <td> <a href="update?id=${customer.id}">update</a>    </td>
    </tr>

      </c:forEach>
    
    </table>
    
</body>
</html>