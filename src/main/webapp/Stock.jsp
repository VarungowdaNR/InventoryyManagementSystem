<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List,dto.StockDTO,dto.UserDTO"%>


<%

List<StockDTO> stocks =
(List<StockDTO>)request.getAttribute("stocks");


String success =
(String)request.getAttribute("success");


String error =
(String)request.getAttribute("error");


UserDTO user =
(UserDTO)session.getAttribute("user");


boolean isAdmin =
user != null && "Admin".equalsIgnoreCase(user.getRole());

%>



<!DOCTYPE html>
<html lang="en">


<head>


<meta charset="UTF-8">

<title>Stock Management</title>


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


</style>


</head>


<body>


<jsp:include page="navbar.jsp"/>



<div class="max-w-7xl mx-auto px-6 py-8">



<!-- Header -->


<div class="flex justify-between items-center mb-7">


<div>


<h1 class="text-3xl font-extrabold text-gray-800">


<i class="fa-solid fa-warehouse text-blue-600"></i>

Stock Management


</h1>


<p class="text-gray-500">

Manage inventory stock movement

</p>


</div>


<div class="bg-blue-100 text-blue-700 px-4 py-2 rounded-full font-semibold">


<i class="fa-solid fa-user-shield"></i>

<%=isAdmin?"Admin":"Employee"%>


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






<% if(isAdmin){ %>



<div class="grid md:grid-cols-2 gap-6 mb-8">





<!-- STOCK IN -->


<div class="card p-6">


<h2 class="text-xl font-bold text-green-600 mb-5">


<i class="fa-solid fa-arrow-down"></i>

Stock In


</h2>



<form action="Stock" method="post">


<input type="hidden" name="action" value="add">



<label class="font-semibold">

Product ID

</label>

<input class="input mt-2 mb-4"
type="number"
name="productId"
required>



<label class="font-semibold">

Quantity

</label>

<input class="input mt-2 mb-4"
type="number"
name="stockIn"
required>




<label class="font-semibold">

Stock Date

</label>

<input class="input mt-2 mb-4"
type="date"
name="stockDate"
required>



<label class="font-semibold">

Remarks

</label>

<input class="input mt-2"
type="text"
name="remarks">





<button

class="mt-6 bg-green-600 hover:bg-green-700 text-white px-6 py-3 rounded-lg font-semibold">


<i class="fa-solid fa-plus"></i>

Add Stock


</button>



</form>


</div>








<!-- STOCK OUT -->


<div class="card p-6">


<h2 class="text-xl font-bold text-red-600 mb-5">


<i class="fa-solid fa-arrow-up"></i>

Stock Out


</h2>




<form action="Stock" method="post">


<input type="hidden" name="action" value="stockOut">



<label class="font-semibold">

Product ID

</label>


<input class="input mt-2 mb-4"
type="number"
name="productId"
required>




<label class="font-semibold">

Quantity

</label>


<input class="input mt-2 mb-4"
type="number"
name="stockOut"
required>




<label class="font-semibold">

Stock Date

</label>


<input class="input mt-2 mb-4"
type="date"
name="stockDate"
required>




<label class="font-semibold">

Remarks

</label>


<input class="input mt-2"
type="text"
name="remarks">





<button

class="mt-6 bg-red-600 hover:bg-red-700 text-white px-6 py-3 rounded-lg font-semibold">


<i class="fa-solid fa-minus"></i>

Stock Out


</button>



</form>



</div>



</div>



<% } %>







<!-- STOCK LIST -->


<div class="card overflow-hidden">


<div class="p-6">


<h2 class="text-xl font-bold text-blue-700">


<i class="fa-solid fa-list"></i>

Stock History


</h2>


</div>





<div class="overflow-x-auto">


<table class="w-full">


<thead class="bg-[#131A2C] text-white">


<tr>


<th class="p-4">ID</th>

<th>Product</th>

<th>Stock In</th>

<th>Stock Out</th>

<th>Date</th>

<th>Remarks</th>


<% if(isAdmin){ %>

<th>Action</th>

<% } %>


</tr>


</thead>




<tbody>



<%

if(stocks!=null && !stocks.isEmpty()){


for(StockDTO s:stocks){


%>




<tr class="border-b text-center hover:bg-gray-50">



<td class="p-4">

<%=s.getStockId()%>

</td>



<td>

<i class="fa-solid fa-box text-blue-600"></i>

<%=s.getProductId()%>


</td>



<td>


<span class="bg-green-100 text-green-700 px-3 py-1 rounded-full">

<%=s.getStockIn()%>

</span>


</td>




<td>


<span class="bg-red-100 text-red-700 px-3 py-1 rounded-full">

<%=s.getStockOut()%>

</span>


</td>




<td>

<%=s.getStockDate()%>

</td>



<td>

<%=s.getRemarks()%>

</td>





<% if(isAdmin){ %>


<td>


<form action="Stock" method="post">


<input type="hidden"
name="action"
value="delete">


<input type="hidden"
name="stockId"
value="<%=s.getStockId()%>">



<button

onclick="return confirm('Delete Stock?')"

class="bg-red-600 hover:bg-red-700 text-white px-4 py-2 rounded-lg">


<i class="fa-solid fa-trash"></i>

Delete


</button>



</form>


</td>


<% } %>




</tr>



<%

}

}else{

%>


<tr>

<td colspan="<%=isAdmin?7:6%>"
class="text-center py-6 text-red-600">


<i class="fa-solid fa-box-open text-xl"></i>


<br>

No Stock Found


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