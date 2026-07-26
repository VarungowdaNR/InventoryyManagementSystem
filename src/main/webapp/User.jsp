<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List,dto.UserDTO"%>

<%
List<UserDTO> users =
(List<UserDTO>)request.getAttribute("users");

String success =
(String)request.getAttribute("success");

String error =
(String)request.getAttribute("error");
%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<title>User Management</title>

<script src="https://cdn.tailwindcss.com"></script>

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<style>

body{
background:#F1F3F6;
font-family:Inter,sans-serif;
}

.card{
background:white;
border:1px solid #E5E7EB;
border-radius:12px;
box-shadow:0 4px 12px rgba(0,0,0,.05);
}

</style>

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="max-w-7xl mx-auto px-6 py-8">

<!-- Header -->

<div class="flex justify-between items-center mb-7">

<div>

<h1 class="text-3xl font-extrabold text-gray-800">

<i class="fa-solid fa-users text-blue-600"></i>

User Management

</h1>

<p class="text-gray-500">

Manage all registered users

</p>

</div>

<div class="bg-blue-100 text-blue-700 px-4 py-2 rounded-full font-semibold">

<i class="fa-solid fa-user-shield"></i>

Admin Panel

</div>

</div>

<!-- Messages -->

<%
if(success!=null){
%>

<div class="mb-5 bg-green-100 border border-green-400 text-green-700 p-4 rounded-lg">

<i class="fa-solid fa-circle-check"></i>

<%=success%>

</div>

<%
}

if(error!=null){
%>

<div class="mb-5 bg-red-100 border border-red-400 text-red-700 p-4 rounded-lg">

<i class="fa-solid fa-circle-exclamation"></i>

<%=error%>

</div>

<%
}
%>

<div class="card overflow-hidden">

<div class="p-6">

<h2 class="text-xl font-bold text-blue-700">

<i class="fa-solid fa-list"></i>

User List

</h2>

</div>

<div class="overflow-x-auto">

<table class="w-full">

<thead class="bg-[#131A2C] text-white">

<tr>

<th class="p-4">ID</th>

<th>Name</th>

<th>Email</th>

<th>Mobile</th>

<th>Username</th>

<th>Role</th>

<th>Action</th>

</tr>

</thead>

<tbody>

<%

if(users!=null && !users.isEmpty()){

for(UserDTO u:users){

%>

<tr class="border-b text-center hover:bg-gray-50">

<td class="p-4">

<%=u.getUserId()%>

</td>

<td><%=u.getFullName()%>
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

<span class="bg-blue-100 text-blue-700 px-3 py-1 rounded-full">

<%=u.getRole()%>

</span>

</td>

<td>

<form action="User" method="post">

<input
type="hidden"
name="action"
value="delete">

<input
type="hidden"
name="userId"
value="<%=u.getUserId()%>">

<button
type="submit"
class="bg-red-600 hover:bg-red-700 text-white px-4 py-2 rounded-lg">

<i class="fa-solid fa-trash"></i>

Delete

</button>

</form>

</td>

</tr>

<%

}

}else{

%>

<tr>

<td colspan="7"
class="text-center py-6 text-red-600">

<i class="fa-solid fa-users-slash text-2xl"></i>

<br>

No Users Found

</td>

</tr>

<%

}

%>

</tbody>

</table>

</div>

</div>
</div>

</body>

</html>