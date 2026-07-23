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
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Dashboard | Inventory Management</title>

<script src="https://cdn.tailwindcss.com"></script>

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">

<style>

:root{
    --bg:         #F1F3F6;
    --navy:       #131A2C;
    --blue:       #2874F0;
    --blue-dark:  #1857C6;
    --orange:     #FF9F00;
    --green:      #26A541;
    --text:       #212121;
    --text-dim:   #6B7280;
    --card-line:  #E7E9EE;
}

body{
    background: var(--bg);
    font-family:'Inter', sans-serif;
    color: var(--text);
}

/* Top bar */
.topbar{
    background: var(--navy);
}
.topbar .role-chip{
    background: rgba(255,255,255,0.08);
    border: 1px solid rgba(255,255,255,0.14);
}

.card{
    background:#fff;
    border:1px solid var(--card-line);
    border-radius:10px;
    box-shadow: 0 1px 2px rgba(20,23,32,0.04);
    transition: box-shadow .18s ease, transform .18s ease;
}
.card:hover{
    box-shadow: 0 10px 24px -12px rgba(20,23,32,0.18);
    transform: translateY(-2px);
}

.icon-tile{
    width:52px; height:52px;
    border-radius:12px;
    display:flex; align-items:center; justify-content:center;
}

.trend-up{ color: var(--green); }

.action-tile{
    background:#fff;
    border:1px solid var(--card-line);
    border-radius:10px;
    transition: all .16s ease;
}
.action-tile:hover{
    border-color: var(--blue);
    box-shadow: 0 8px 20px -10px rgba(40,116,240,0.35);
    transform: translateY(-3px);
}

.eyebrow{
    font-size:0.72rem;
    font-weight:700;
    letter-spacing:0.06em;
    text-transform:uppercase;
    color: var(--text-dim);
}

</style>

</head>

<body class="min-h-screen">

<jsp:include page="navbar.jsp"/>

<!-- Top summary bar -->
<div class="topbar text-white">
    <div class="max-w-7xl mx-auto px-6 py-6 flex flex-col md:flex-row md:items-center md:justify-between gap-4">
        <div>
            <p class="text-xs uppercase tracking-wider text-white/60 font-semibold">Seller Central</p>
            <h1 class="text-2xl font-extrabold mt-1">Inventory Management Dashboard</h1>
        </div>
        <div class="flex items-center gap-3">
            <div class="w-10 h-10 rounded-full bg-[var(--blue)] flex items-center justify-center font-bold text-sm">
                <%=user.getFullName().substring(0,1).toUpperCase()%>
            </div>
            <div class="leading-tight">
                <p class="font-semibold text-sm"><%=user.getFullName()%></p>
                <span class="role-chip text-[11px] px-2 py-0.5 rounded-full font-medium uppercase tracking-wide"><%=role%></span>
            </div>
        </div>
    </div>
</div>

<div class="max-w-7xl mx-auto px-6 py-8">

<!-- Statistics -->
<div class="flex items-center justify-between mb-5">
    <h2 class="text-lg font-bold text-[var(--text)]">Overview</h2>
    <span class="text-xs text-[var(--text-dim)]"><i class="fa-regular fa-clock"></i> Updated just now</span>
</div>

<div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-5">

    <!-- Products -->
    <div class="card p-6">
        <div class="flex items-start justify-between">
            <div>
                <p class="eyebrow">Products</p>
                <p class="text-3xl font-extrabold mt-2">${totalProducts}</p>
                <p class="text-xs trend-up font-semibold mt-2"><i class="fa-solid fa-arrow-trend-up"></i> Listed items</p>
            </div>
            <div class="icon-tile" style="background:#E8F0FE;">
                <i class="fa-solid fa-box text-xl" style="color:var(--blue)"></i>
            </div>
        </div>
    </div>

    <!-- Categories -->
    <div class="card p-6">
        <div class="flex items-start justify-between">
            <div>
                <p class="eyebrow">Categories</p>
                <p class="text-3xl font-extrabold mt-2">${totalCategories}</p>
                <p class="text-xs text-[var(--text-dim)] font-medium mt-2"><i class="fa-solid fa-sitemap"></i> Active groups</p>
            </div>
            <div class="icon-tile" style="background:#FDECE8;">
                <i class="fa-solid fa-layer-group text-xl" style="color:#E4572E"></i>
            </div>
        </div>
    </div>

    <!-- Suppliers -->
    <div class="card p-6">
        <div class="flex items-start justify-between">
            <div>
                <p class="eyebrow">Suppliers</p>
                <p class="text-3xl font-extrabold mt-2">${totalSuppliers}</p>
                <p class="text-xs text-[var(--text-dim)] font-medium mt-2"><i class="fa-solid fa-handshake"></i> Partnered vendors</p>
            </div>
            <div class="icon-tile" style="background:#FFF3DE;">
                <i class="fa-solid fa-truck text-xl" style="color:var(--orange)"></i>
            </div>
        </div>
    </div>

    <!-- Customers -->
    <div class="card p-6">
        <div class="flex items-start justify-between">
            <div>
                <p class="eyebrow">Customers</p>
                <p class="text-3xl font-extrabold mt-2">${totalCustomers}</p>
                <p class="text-xs trend-up font-semibold mt-2"><i class="fa-solid fa-arrow-trend-up"></i> Registered buyers</p>
            </div>
            <div class="icon-tile" style="background:#E9F9EC;">
                <i class="fa-solid fa-users text-xl" style="color:var(--green)"></i>
            </div>
        </div>
    </div>

    <!-- Available Stock -->
    <div class="card p-6">
        <div class="flex items-start justify-between">
            <div>
                <p class="eyebrow">Available Stock</p>
                <p class="text-3xl font-extrabold mt-2">${availableStock}</p>
                <p class="text-xs text-[var(--text-dim)] font-medium mt-2"><i class="fa-solid fa-warehouse"></i> Units in hand</p>
            </div>
            <div class="icon-tile" style="background:#E8F0FE;">
                <i class="fa-solid fa-boxes-stacked text-xl" style="color:var(--blue)"></i>
            </div>
        </div>
    </div>

    <!-- Total Sales -->
    <div class="card p-6">
        <div class="flex items-start justify-between">
            <div>
                <p class="eyebrow">Total Sales</p>
                <p class="text-3xl font-extrabold mt-2">₹ ${totalSales}</p>
                <p class="text-xs trend-up font-semibold mt-2"><i class="fa-solid fa-arrow-trend-up"></i> Lifetime revenue</p>
            </div>
            <div class="icon-tile" style="background:#FFF3DE;">
                <i class="fa-solid fa-cart-shopping text-xl" style="color:var(--orange)"></i>
            </div>
        </div>
    </div>

</div>

<!-- Quick Access -->
<div class="flex items-center justify-between mt-10 mb-5">
    <h2 class="text-lg font-bold">Manage</h2>
</div>

<div class="grid grid-cols-2 md:grid-cols-4 gap-5">

    <a href="Category" class="action-tile p-6 text-center block">
        <i class="fa-solid fa-layer-group text-2xl" style="color:#E4572E"></i>
        <p class="font-semibold mt-3 text-sm">Category</p>
    </a>

    <a href="Product" class="action-tile p-6 text-center block">
        <i class="fa-solid fa-box text-2xl" style="color:var(--blue)"></i>
        <p class="font-semibold mt-3 text-sm">Product</p>
    </a>

    <a href="Supplier" class="action-tile p-6 text-center block">
        <i class="fa-solid fa-truck text-2xl" style="color:var(--orange)"></i>
        <p class="font-semibold mt-3 text-sm">Supplier</p>
    </a>

    <a href="Customer" class="action-tile p-6 text-center block">
        <i class="fa-solid fa-users text-2xl" style="color:var(--green)"></i>
        <p class="font-semibold mt-3 text-sm">Customer</p>
    </a>

    <a href="Stock" class="action-tile p-6 text-center block">
        <i class="fa-solid fa-warehouse text-2xl" style="color:var(--blue)"></i>
        <p class="font-semibold mt-3 text-sm">Stock</p>
    </a>

    <a href="Sales" class="action-tile p-6 text-center block">
        <i class="fa-solid fa-cart-shopping text-2xl" style="color:var(--orange)"></i>
        <p class="font-semibold mt-3 text-sm">Sales</p>
    </a>

    <% if(isAdmin){ %>
    <a href="User" class="action-tile p-6 text-center block">
        <i class="fa-solid fa-user-gear text-2xl" style="color:var(--blue)"></i>
        <p class="font-semibold mt-3 text-sm">Users</p>
    </a>
    <% } %>

    <a href="Logout" class="action-tile p-6 text-center block">
        <i class="fa-solid fa-right-from-bracket text-2xl text-[var(--text-dim)]"></i>
        <p class="font-semibold mt-3 text-sm">Logout</p>
    </a>

</div>

<footer class="text-center text-[var(--text-dim)] text-xs mt-14 pb-8">
    © 2026 Inventory Management System &nbsp;·&nbsp; Java Full Stack Project
</footer>

</div>

</body>

</html>
