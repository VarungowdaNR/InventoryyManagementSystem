<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="dto.UserDTO" %>


<%
UserDTO user = (UserDTO) session.getAttribute("user");

if(user == null){
    response.sendRedirect("Login.jsp");
    return;
}

String role = user.getRole();

boolean isAdmin = role.equalsIgnoreCase("Admin");

%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<title>Navbar</title>

<script src="https://cdn.tailwindcss.com"></script>


<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">


<style>

.navbar{
    background:#131A2C;
}


.nav-link{

    color:#E5E7EB;
    font-size:13px;
    font-weight:500;
    padding:8px 10px;
    border-radius:8px;
    transition:.2s;

}


.nav-link:hover{

    background:#2874F0;
    color:white;

}


.logout{

    background:#DC2626;

}


.logout:hover{

    background:#B91C1C;

}


</style>


</head>


<body>


<nav class="navbar shadow-md">


<div class="max-w-7xl mx-auto px-5">


<div class="flex items-center justify-between h-20">



<!-- LOGO -->

<div class="flex items-center gap-3">


<div class="w-11 h-11 bg-blue-600 rounded-xl flex items-center justify-center">

<i class="fa-solid fa-boxes-stacked text-white text-lg"></i>

</div>



<div>

<h1 class="text-white font-bold text-lg">

Inventory

</h1>


<p class="text-gray-400 text-xs">

Management System

</p>


</div>


</div>





<!-- MENU -->


<div class="flex items-center gap-1 overflow-x-auto ml-8">



<a href="DashboardServlet" class="nav-link">

<i class="fa-solid fa-house"></i>

Dashboard

</a>




<a href="Category" class="nav-link">

<i class="fa-solid fa-layer-group"></i>

Category

</a>




<a href="Product" class="nav-link">

<i class="fa-solid fa-box"></i>

Product

</a>




<a href="Supplier" class="nav-link">

<i class="fa-solid fa-truck"></i>

Supplier

</a>




<a href="Customer" class="nav-link">

<i class="fa-solid fa-users"></i>

Customer

</a>




<a href="Stock" class="nav-link">

<i class="fa-solid fa-warehouse"></i>

Stock

</a>




<a href="Sales" class="nav-link">

<i class="fa-solid fa-cart-shopping"></i>

Sales

</a>





<!-- ADMIN ONLY -->

<%
if(isAdmin){
%>


<a href="User" class="nav-link">

<i class="fa-solid fa-user-gear"></i>

Users

</a>


<%
}
%>



</div>





<!-- USER PROFILE -->


<div class="flex items-center gap-3 ml-4">



<div class="text-right">


<p class="text-white text-sm font-semibold">

<%=user.getFullName()%>

</p>



<p class="text-xs text-blue-400 uppercase">

<%=role%>

</p>


</div>




<div class="w-10 h-10 rounded-full bg-blue-600 flex items-center justify-center text-white font-bold">


<%=user.getFullName().substring(0,1).toUpperCase()%>


</div>




<a href="Logout"
class="logout text-white px-3 py-2 rounded-lg text-sm">


<i class="fa-solid fa-power-off"></i>


</a>




</div>




</div>


</div>


</nav>


</body>


</html>