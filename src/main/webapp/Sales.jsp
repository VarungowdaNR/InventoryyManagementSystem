<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<%@ page import="java.util.List,dto.SalesDTO"%>


<%

List<SalesDTO> sales =
(List<SalesDTO>)request.getAttribute("sales");


String success =
(String)request.getAttribute("success");


String error =
(String)request.getAttribute("error");

%>



<!DOCTYPE html>

<html lang="en">


<head>


<meta charset="UTF-8">


<title>Sales Management</title>


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


<i class="fa-solid fa-file-invoice-dollar text-green-600"></i>

Sales Management


</h1>


<p class="text-gray-500 mt-1">

Track customer sales and revenue

</p>


</div>



<div class="bg-green-100 text-green-700 px-4 py-2 rounded-full font-semibold">


<i class="fa-solid fa-chart-line"></i>

Revenue


</div>


</div>







<!-- Message -->


<%

if(success!=null){

%>


<div id="message"

class="mb-5 bg-green-100 border border-green-400 text-green-700 p-4 rounded-lg">


<i class="fa-solid fa-circle-check"></i>

<%=success%>


</div>


<%

}



if(error!=null){

%>


<div id="message"

class="mb-5 bg-red-100 border border-red-400 text-red-700 p-4 rounded-lg">


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







<!-- Add Sale -->


<div class="card p-7 mb-8">



<h2 class="text-xl font-bold text-blue-700 mb-6">


<i class="fa-solid fa-plus-circle"></i>

Add New Sale


</h2>





<form action="Sales" method="post">


<input type="hidden" name="action" value="add">





<div class="grid md:grid-cols-3 gap-6">



<div>


<label class="font-semibold">

Customer ID

</label>


<input

class="input mt-2"

type="number"

name="customerId"

placeholder="Enter Customer ID"

required>


</div>





<div>


<label class="font-semibold">

Total Amount

</label>


<input

class="input mt-2"

type="number"

step="0.01"

name="totalAmount"

placeholder="Enter amount"

required>


</div>





<div>


<label class="font-semibold">

Sale Date

</label>


<input

class="input mt-2"

type="datetime-local"

name="saleDate"

required>


</div>



</div>





<button

class="mt-7 bg-blue-600 hover:bg-blue-700 text-white px-7 py-3 rounded-lg font-semibold">


<i class="fa-solid fa-save"></i>

Save Sale


</button>



</form>


</div>








<!-- Sales Table -->


<div class="card overflow-hidden">


<div class="p-6">


<h2 class="text-xl font-bold text-green-600">


<i class="fa-solid fa-receipt"></i>

Sales History


</h2>


</div>





<div class="overflow-x-auto">


<table class="w-full">



<thead class="bg-[#131A2C] text-white">


<tr>


<th class="p-4">

Sale ID

</th>


<th>

Customer ID

</th>


<th>

Amount

</th>


<th>

Sale Date

</th>


<th>

Action

</th>


</tr>


</thead>





<tbody>



<%

if(sales!=null && !sales.isEmpty()){



for(SalesDTO s:sales){


%>





<tr class="border-b text-center hover:bg-gray-50">


<td class="p-4 font-semibold">


<%=s.getSaleId()%>


</td>




<td>


<i class="fa-solid fa-user text-blue-600"></i>


<%=s.getCustomerId()%>


</td>




<td>


<span class="bg-green-100 text-green-700 px-3 py-1 rounded-full font-semibold">


₹ <%=s.getTotalAmount()%>


</span>


</td>





<td>

<%=s.getSaleDate()%>

</td>





<td>


<form action="Sales" method="post">


<input type="hidden"

name="action"

value="delete">



<input type="hidden"

name="saleId"

value="<%=s.getSaleId()%>">





<button


onclick="return confirm('Delete this sale?')"


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


<td colspan="5"

class="text-center py-6 text-red-600">


<i class="fa-solid fa-file-circle-xmark text-xl"></i>


<br>


No Sales Found


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