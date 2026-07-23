<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<%@ page import="java.util.List" %>
<%@ page import="dto.UserDTO" %>


<%

List<UserDTO> users =
(List<UserDTO>)request.getAttribute("users");

%>



<!DOCTYPE html>
<html>

<head>

<title>User Management</title>

<script src="https://cdn.tailwindcss.com"></script>

</head>


<body class="bg-gray-100">


<jsp:include page="navbar.jsp"/>



<div class="max-w-6xl mx-auto p-6">


<h1 class="text-3xl font-bold mb-6">

User Management

</h1>




<div class="bg-white shadow rounded-lg overflow-hidden">


<table class="w-full">


<thead class="bg-blue-600 text-white">


<tr>

<th class="p-3">ID</th>

<th class="p-3">Name</th>

<th class="p-3">Email</th>

<th class="p-3">Mobile</th>

<th class="p-3">Username</th>

<th class="p-3">Role</th>

<th class="p-3">Action</th>


</tr>


</thead>



<tbody>


<%

if(users!=null){

for(UserDTO u: users){

%>


<tr class="border-b text-center">


<td class="p-3">

<%=u.getUserId()%>

</td>



<td>

<%=u.getFullName()%>

</td>



<td>

<%=u.getEmail()%>

</td>



<td>

<%=u.getMobile()%>

</td>



<td>

<%=u.getUsername()%>

</td>



<td>

<span class="px-3 py-1 rounded bg-blue-100">

<%=u.getRole()%>

</span>

</td>



<td>


<form action="User" method="post">


<input type="hidden"
name="action"
value="delete">


<input type="hidden"
name="userId"
value="<%=u.getUserId()%>">



<button

onclick="return confirm('Delete User?')"

class="bg-red-600 text-white px-3 py-1 rounded">


Delete


</button>


</form>


</td>



</tr>


<%

}

}

%>



</tbody>


</table>


</div>



</div>


</body>


</html>