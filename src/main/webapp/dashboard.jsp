<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="dto.UserDTO" %>

<%
UserDTO user = (UserDTO)session.getAttribute("user");

if(user==null){
    response.sendRedirect("Login.jsp");
    return;
}

String role = user.getRole();

Integer totalProducts =
(Integer)request.getAttribute("totalProducts");

Integer totalCategories =
(Integer)request.getAttribute("totalCategories");

Integer totalSuppliers =
(Integer)request.getAttribute("totalSuppliers");

Integer totalCustomers =
(Integer)request.getAttribute("totalCustomers");

Integer availableStock =
(Integer)request.getAttribute("availableStock");

Double totalSales =
(Double)request.getAttribute("totalSales");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<meta name="viewport"
content="width=device-width, initial-scale=1.0">

<title>Dashboard</title>

<script src="https://cdn.tailwindcss.com"></script>

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<link rel="preconnect"
href="https://fonts.googleapis.com">

<link
href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap"
rel="stylesheet">

<style>

body{

background:#F1F3F6;
font-family:'Inter',sans-serif;

}

.topbar{

background:#131A2C;

}

.role-chip{

background:rgba(255,255,255,.08);
border:1px solid rgba(255,255,255,.15);

}

.card{

background:white;
border:1px solid #E7E9EE;
border-radius:10px;
box-shadow:0 2px 8px rgba(0,0,0,.05);

}

.icon-tile{

width:52px;
height:52px;
display:flex;
align-items:center;
justify-content:center;
border-radius:12px;

}

.action-tile{

background:white;
border:1px solid #E7E9EE;
border-radius:10px;

}

.eyebrow{

font-size:12px;
font-weight:bold;
text-transform:uppercase;
color:#6B7280;

}

</style>

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="topbar text-white">

<div class="max-w-7xl mx-auto px-6 py-6 flex justify-between items-center">

<div>

<p class="text-xs uppercase">

Seller Central

</p>

<h1 class="text-2xl font-bold">

Inventory Management Dashboard

</h1>

</div>

<div class="flex items-center gap-3">

<div
class="w-10 h-10 rounded-full bg-blue-600 flex items-center justify-center font-bold">

<%=user.getFullName().substring(0,1).toUpperCase()%>

</div>

<div>

<p class="font-semibold">

<%=user.getFullName()%>

</p>

<span class="role-chip px-3 py-1 rounded-full text-sm">

<%=role%>

</span>

</div>

</div>

</div>

</div>

<div class="max-w-7xl mx-auto px-6 py-8">

<h2 class="text-xl font-bold mb-5">

Overview

</h2>

<div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-5">
<!-- Products -->

<div class="card p-6">

<div class="flex justify-between items-center">

<div>

<p class="eyebrow">

Products

</p>

<h2 class="text-3xl font-bold mt-2">

<%=totalProducts%>

</h2>

<p class="text-sm text-green-600 mt-2">

<i class="fa-solid fa-arrow-trend-up"></i>

Listed Items

</p>

</div>

<div class="icon-tile bg-blue-100">

<i class="fa-solid fa-box text-2xl text-blue-600"></i>

</div>

</div>

</div>

<!-- Categories -->

<div class="card p-6">

<div class="flex justify-between items-center">

<div>

<p class="eyebrow">

Categories

</p>

<h2 class="text-3xl font-bold mt-2">

<%=totalCategories%>

</h2>

<p class="text-sm text-gray-500 mt-2">

<i class="fa-solid fa-sitemap"></i>

Active Groups

</p>

</div>

<div class="icon-tile bg-red-100">

<i class="fa-solid fa-layer-group text-2xl text-red-600"></i>

</div>

</div>

</div>

<!-- Suppliers -->

<div class="card p-6">

<div class="flex justify-between items-center">

<div>

<p class="eyebrow">

Suppliers

</p>

<h2 class="text-3xl font-bold mt-2">

<%=totalSuppliers%>

</h2>

<p class="text-sm text-gray-500 mt-2">

<i class="fa-solid fa-handshake"></i>

Partnered Vendors

</p>

</div>

<div class="icon-tile bg-yellow-100">

<i class="fa-solid fa-truck text-2xl text-yellow-600"></i>

</div>

</div>

</div>

<!-- Customers -->

<div class="card p-6">

<div class="flex justify-between items-center">

<div>

<p class="eyebrow">

Customers

</p>

<h2 class="text-3xl font-bold mt-2">

<%=totalCustomers%>

</h2>

<p class="text-sm text-green-600 mt-2">

<i class="fa-solid fa-users"></i>

Registered Buyers

</p>

</div>

<div class="icon-tile bg-green-100">

<i class="fa-solid fa-users text-2xl text-green-600"></i>

</div>

</div>

</div>

<!-- Available Stock -->

<div class="card p-6">

<div class="flex justify-between items-center">

<div>

<p class="eyebrow">

Available Stock

</p>

<h2 class="text-3xl font-bold mt-2">

<%=availableStock%>

</h2>

<p class="text-sm text-gray-500 mt-2">

<i class="fa-solid fa-warehouse"></i>

Units In Hand

</p>

</div>

<div class="icon-tile bg-blue-100">

<i class="fa-solid fa-boxes-stacked text-2xl text-blue-600"></i>

</div>

</div>

</div>

<!-- Total Sales -->

<div class="card p-6">

<div class="flex justify-between items-center">

<div>

<p class="eyebrow">

Total Sales

</p>

<h2 class="text-3xl font-bold mt-2">

₹ <%=totalSales%>

</h2>

<p class="text-sm text-green-600 mt-2">

<i class="fa-solid fa-cart-shopping"></i>

Lifetime Revenue

</p>

</div>

<div class="icon-tile bg-yellow-100">

<i class="fa-solid fa-cart-shopping text-2xl text-yellow-600"></i>

</div>

</div>

</div>

</div>
<!-- Quick Access -->

<div class="mt-10">

<h2 class="text-xl font-bold mb-5">

Manage

</h2>

<div class="grid grid-cols-2 md:grid-cols-4 gap-5">

<a href="Category" class="action-tile p-6 text-center">

<i class="fa-solid fa-layer-group text-2xl text-red-600"></i>

<p class="mt-3 font-semibold">

Category

</p>

</a>

<a href="Product" class="action-tile p-6 text-center">

<i class="fa-solid fa-box text-2xl text-blue-600"></i>

<p class="mt-3 font-semibold">

Product

</p>

</a>

<a href="Supplier" class="action-tile p-6 text-center">

<i class="fa-solid fa-truck text-2xl text-yellow-600"></i>

<p class="mt-3 font-semibold">

Supplier

</p>

</a>

<a href="Customer" class="action-tile p-6 text-center">

<i class="fa-solid fa-users text-2xl text-green-600"></i>

<p class="mt-3 font-semibold">

Customer

</p>

</a>

<a href="Stock" class="action-tile p-6 text-center">

<i class="fa-solid fa-warehouse text-2xl text-blue-600"></i>

<p class="mt-3 font-semibold">

Stock

</p>

</a>

<a href="Sales" class="action-tile p-6 text-center">

<i class="fa-solid fa-cart-shopping text-2xl text-orange-500"></i>

<p class="mt-3 font-semibold">

Sales

</p>

</a>

<%
if(user.getRole().equalsIgnoreCase("Admin")){
%>

<a href="User" class="action-tile p-6 text-center">

<i class="fa-solid fa-user-gear text-2xl text-blue-600"></i>

<p class="mt-3 font-semibold">

Users

</p>

</a>

<%
}
%>

<a href="Logout" class="action-tile p-6 text-center">

<i class="fa-solid fa-right-from-bracket text-2xl text-gray-600"></i>

<p class="mt-3 font-semibold">

Logout

</p>

</a>

</div>

</div>

<footer class="text-center text-gray-500 text-sm mt-12 mb-5">

© 2026 Inventory Management System

</footer>

</div>

</body>

</html>