<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List,dto.SaleItemsDTO,dto.UserDTO"%>

<%

List<SaleItemsDTO> saleItems =
(List<SaleItemsDTO>)request.getAttribute("saleItems");

UserDTO user =
(UserDTO)session.getAttribute("user");


String role="";

if(user!=null){
    role=user.getRole();
}


String success=(String)request.getAttribute("success");

String error=(String)request.getAttribute("error");

%>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<title>Sale Items Management</title>

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

.input{

width:100%;
padding:12px;
border:1px solid #D1D5DB;
border-radius:8px;

}

.input:focus{

outline:none;
border-color:#2874F0;

}

.table-head{

background:#131A2C;

}

</style>

</head>


<body>


<jsp:include page="navbar.jsp"/>



<div class="max-w-7xl mx-auto px-6 py-8">


<div class="flex justify-between items-center mb-7">


<div>

<h1 class="text-3xl font-extrabold text-gray-800">

<i class="fa-solid fa-cart-shopping text-blue-600"></i>

Sale Items Management

</h1>


<p class="text-gray-500">

Manage sold products

</p>

</div>



<div class="bg-blue-100 text-blue-700 px-4 py-2 rounded-full font-semibold">

<i class="fa-solid fa-user-shield"></i>

<%=role%>

</div>


</div>





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





<!-- ADD SALE ITEM -->

<%

if(user!=null &&
(user.getRole().equalsIgnoreCase("Admin") ||
 user.getRole().equalsIgnoreCase("Employee"))){

%>



<div class="card p-7 mb-8">


<h2 class="text-xl font-bold text-blue-700 mb-6">

<i class="fa-solid fa-plus"></i>

Add Sale Item

</h2>



<form action="SaleItems" method="post">


<input type="hidden"
name="action"
value="add">



<div class="grid grid-cols-1 md:grid-cols-2 gap-5">


<div>

<label class="font-semibold">

Sale ID

</label>


<input class="input mt-2"
type="number"
name="saleId"
required>

</div>




<div>

<label class="font-semibold">

Product ID

</label>


<input class="input mt-2"
type="number"
name="productId"
required>

</div>




<div>

<label class="font-semibold">

Quantity

</label>


<input class="input mt-2"
type="number"
name="quantity"
required>

</div>




<div>

<label class="font-semibold">

Price

</label>


<input class="input mt-2"
type="number"
step="0.01"
name="price"
required>

</div>




<div>

<label class="font-semibold">

Subtotal

</label>


<input class="input mt-2"
type="number"
step="0.01"
name="subtotal"
required>

</div>



</div>



<button
class="mt-7 bg-blue-600 hover:bg-blue-700 text-white px-7 py-3 rounded-lg font-semibold">


<i class="fa-solid fa-save"></i>

Add Sale Item


</button>



</form>


</div>


<%

}

%>





<!-- SALE ITEMS TABLE -->


<div class="card overflow-hidden">


<div class="p-6">


<h2 class="text-xl font-bold text-green-600">

<i class="fa-solid fa-list"></i>

Sale Items List

</h2>


</div>





<div class="overflow-x-auto">


<table class="w-full">


<thead class="table-head text-white">


<tr>


<th class="p-4">

ID

</th>


<th>

Sale ID

</th>


<th>

Product ID

</th>


<th>

Quantity

</th>


<th>

Price

</th>


<th>

Subtotal

</th>



<%

if(user!=null &&
(user.getRole().equalsIgnoreCase("Admin") ||
 user.getRole().equalsIgnoreCase("Employee"))){

%>


<th>

Action

</th>


<%

}

%>


</tr>


</thead>




<tbody>


<%

if(saleItems!=null && !saleItems.isEmpty()){


for(SaleItemsDTO s:saleItems){

%>



<tr class="border-b text-center hover:bg-gray-50">



<td class="p-4">

<%=s.getSaleItemId()%>

</td>



<td>

<%=s.getSaleId()%>

</td>



<td>

<%=s.getProductId()%>

</td>



<td>

<span class="bg-green-100 text-green-700 px-3 py-1 rounded-full">

<%=s.getQuantity()%>

</span>


</td>



<td>

₹ <%=s.getPrice()%>

</td>



<td>

₹ <%=s.getSubtotal()%>

</td>





<%

if(user!=null &&
(user.getRole().equalsIgnoreCase("Admin") ||
 user.getRole().equalsIgnoreCase("Employee"))){

%>



<td>


<form action="SaleItems" method="post">


<input type="hidden"
name="action"
value="delete">



<input type="hidden"
name="saleItemId"
value="<%=s.getSaleItemId()%>">


<button
class="bg-red-600 hover:bg-red-700 text-white px-4 py-2 rounded-lg">


<i class="fa-solid fa-trash"></i>

Delete


</button>


</form>


</td>



<%

}

%>



</tr>



<%

}


}else{

%>


<tr>


<td colspan="7"
class="text-center py-6 text-red-600">


<i class="fa-solid fa-cart-shopping text-xl"></i>

<br>

No Sale Items Found


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