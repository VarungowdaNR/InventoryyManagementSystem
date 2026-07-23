<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List,dto.CustomerDTO"%>


<%

List<CustomerDTO> customers =
(List<CustomerDTO>)request.getAttribute("customers");


String success =
(String)request.getAttribute("success");


String error =
(String)request.getAttribute("error");

%>



<!DOCTYPE html>
<html lang="en">


<head>


<meta charset="UTF-8">

<title>Customer Management</title>


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
box-shadow:0 0 0 3px rgba(40,116,240,.15);

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


<i class="fa-solid fa-users text-green-600"></i>

Customer Management


</h1>


<p class="text-gray-500 mt-1">

Manage customer information

</p>


</div>



<div class="bg-green-100 text-green-700 px-4 py-2 rounded-full font-semibold">


<i class="fa-solid fa-user"></i>

Customers


</div>


</div>





<!-- Messages -->


<%

if(success!=null){

%>

<div id="message"
class="mb-5 bg-green-100 border border-green-400 text-green-700 px-5 py-3 rounded-lg">

<i class="fa-solid fa-circle-check"></i>

<%=success%>

</div>


<%

}


if(error!=null){

%>

<div id="message"
class="mb-5 bg-red-100 border border-red-400 text-red-700 px-5 py-3 rounded-lg">

<i class="fa-solid fa-circle-exclamation"></i>

<%=error%>

</div>


<%

}

%>



<script>

setTimeout(()=>{

let m=document.getElementById("message");

if(m)
m.style.display="none";

},3000);


</script>







<!-- Add Customer -->


<div class="card p-7 mb-8">


<h2 class="text-xl font-bold text-blue-700 mb-6">


<i class="fa-solid fa-user-plus"></i>

Add New Customer


</h2>




<form action="Customer" method="post">


<input type="hidden" name="action" value="add">



<div class="grid md:grid-cols-2 gap-6">



<div>

<label class="font-semibold">

Customer Name

</label>


<input

class="input mt-2"

type="text"

name="customerName"

placeholder="Enter customer name"

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

placeholder="Enter mobile number"

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

placeholder="Enter email">


</div>






<div>

<label class="font-semibold">

Address

</label>


<textarea

class="input mt-2"

name="address"

rows="3"

placeholder="Enter address"></textarea>


</div>



</div>




<div class="mt-7 flex gap-4">


<button

class="bg-blue-600 hover:bg-blue-700 text-white px-7 py-3 rounded-lg font-semibold">


<i class="fa-solid fa-save"></i>

Save Customer


</button>




<button

type="reset"

class="bg-gray-600 hover:bg-gray-700 text-white px-7 py-3 rounded-lg">


Reset


</button>



</div>




</form>


</div>







<!-- Customer List -->


<div class="card overflow-hidden">



<div class="p-6">


<h2 class="text-xl font-bold text-green-600">


<i class="fa-solid fa-address-book"></i>

Customer List


</h2>


</div>





<div class="overflow-x-auto">


<table class="w-full">


<thead class="bg-[#131A2C] text-white">


<tr>


<th class="p-4">

ID

</th>


<th>Name</th>

<th>Mobile</th>

<th>Email</th>

<th>Address</th>

<th>Action</th>


</tr>


</thead>




<tbody>



<%

if(customers!=null && !customers.isEmpty()){


for(CustomerDTO c:customers){


%>



<tr class="border-b text-center hover:bg-gray-50">


<td class="p-4">

<%=c.getCustomerId()%>

</td>



<td class="font-semibold">


<i class="fa-solid fa-user text-green-600"></i>

<%=c.getCustomerName()%>


</td>




<td>

<%=c.getMobile()%>

</td>



<td>

<%=c.getEmail()%>

</td>




<td>

<%=c.getAddress()%>

</td>




<td>



<form action="Customer" method="post">


<input type="hidden"
name="action"
value="delete">



<input type="hidden"
name="customerId"
value="<%=c.getCustomerId()%>">



<button

onclick="return confirm('Delete Customer?')"

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

<td colspan="6"
class="text-center py-6 text-red-600">


<i class="fa-solid fa-users-slash text-xl"></i>


<br>

No Customers Found


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