<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<%@ page import="java.util.List,dto.SupplierDTO,dto.UserDTO"%>


<%

List<SupplierDTO> suppliers =
(List<SupplierDTO>)request.getAttribute("suppliers");


UserDTO user =
(UserDTO)session.getAttribute("user");


boolean isAdmin =
user != null && "Admin".equalsIgnoreCase(user.getRole());


String success =
(String)request.getAttribute("success");


String error =
(String)request.getAttribute("error");


%>



<!DOCTYPE html>
<html lang="en">


<head>


<meta charset="UTF-8">

<title>Supplier Management</title>


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


<i class="fa-solid fa-truck text-orange-500"></i>

Supplier Management


</h1>


<p class="text-gray-500">

Manage supplier and vendor details

</p>


</div>



<div class="bg-orange-100 text-orange-600 px-4 py-2 rounded-full font-semibold">


<i class="fa-solid fa-handshake"></i>

Vendors


</div>


</div>






<!-- Message -->


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







<!-- ADD SUPPLIER -->


<% if(isAdmin){ %>


<div class="card p-7 mb-8">


<h2 class="text-xl font-bold text-blue-700 mb-6">


<i class="fa-solid fa-user-plus"></i>

Add New Supplier


</h2>




<form action="Supplier" method="post">


<input type="hidden"
name="action"
value="add">



<div class="grid grid-cols-1 md:grid-cols-2 gap-5">



<div>

<label class="font-semibold">

Supplier Name

</label>

<input

class="input mt-2"

type="text"

name="supplierName"

placeholder="Enter Supplier Name"

required>


</div>





<div>


<label class="font-semibold">

Contact Person

</label>


<input

class="input mt-2"

type="text"

name="contactPerson"

placeholder="Enter Contact Person"

required>


</div>






<div>


<label class="font-semibold">

Mobile Number

</label>


<input

class="input mt-2"

type="text"

name="mobile"

placeholder="Enter Mobile Number"

required>


</div>






<div>


<label class="font-semibold">

Email

</label>


<input

class="input mt-2"

type="email"

name="email"

placeholder="Enter Email"

required>


</div>






<div class="md:col-span-2">


<label class="font-semibold">

Address

</label>


<input

class="input mt-2"

type="text"

name="address"

placeholder="Enter Address"

required>


</div>



</div>






<button

class="mt-6 bg-blue-600 hover:bg-blue-700 text-white px-7 py-3 rounded-lg font-semibold">


<i class="fa-solid fa-save"></i>

Add Supplier


</button>




</form>


</div>



<% } %>








<!-- SUPPLIER LIST -->


<div class="card overflow-hidden">



<div class="p-6">


<h2 class="text-xl font-bold text-orange-600">


<i class="fa-solid fa-building"></i>

Supplier List


</h2>


</div>





<div class="overflow-x-auto">


<table class="w-full">



<thead class="bg-[#131A2C] text-white">


<tr>


<th class="p-4">

ID

</th>


<th>

Supplier

</th>


<th>

Contact

</th>


<th>

Mobile

</th>


<th>

Email

</th>


<th>

Address

</th>



<% if(isAdmin){ %>

<th>

Action

</th>

<% } %>



</tr>


</thead>





<tbody>



<%

if(suppliers!=null && !suppliers.isEmpty()){



for(SupplierDTO s:suppliers){


%>




<tr class="border-b text-center hover:bg-gray-50">



<td class="p-4 font-semibold">

<%=s.getSupplierId()%>

</td>




<td>


<i class="fa-solid fa-truck text-orange-500"></i>


<%=s.getSupplierName()%>


</td>




<td>

<%=s.getContactPerson()%>

</td>




<td>

<%=s.getMobile()%>

</td>




<td>

<%=s.getEmail()%>

</td>




<td>

<%=s.getAddress()%>

</td>






<% if(isAdmin){ %>


<td>



<form action="Supplier" method="post">


<input type="hidden"
name="action"
value="delete">



<input type="hidden"
name="supplierId"
value="<%=s.getSupplierId()%>">





<button

onclick="return confirm('Delete Supplier?')"

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


<i class="fa-solid fa-truck-ramp-box text-xl"></i>


<br>


No Suppliers Found


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