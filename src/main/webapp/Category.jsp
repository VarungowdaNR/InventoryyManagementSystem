<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List,dto.CategoryDTO,dto.UserDTO"%>


<%

List<CategoryDTO> categories =
(List<CategoryDTO>)request.getAttribute("categories");


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

<title>Category Management</title>


<script src="https://cdn.tailwindcss.com"></script>


<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">


<style>

body{

background:#F1F3F6;
font-family:'Inter',sans-serif;

}


.card{

background:white;
border:1px solid #E7E9EE;
border-radius:12px;

box-shadow:0 2px 8px rgba(0,0,0,0.05);

}


.table-head{

background:#131A2C;

}


</style>


</head>



<body>


<jsp:include page="navbar.jsp"/>



<div class="max-w-7xl mx-auto px-6 py-8">



<!-- Header -->


<div class="flex justify-between items-center mb-6">


<div>


<h1 class="text-3xl font-extrabold text-gray-800">

<i class="fa-solid fa-layer-group text-blue-600"></i>

Category Management

</h1>


<p class="text-gray-500 text-sm mt-1">

Manage product categories

</p>


</div>


<span class="bg-blue-100 text-blue-700 px-4 py-2 rounded-full text-sm font-semibold">


<i class="fa-solid fa-user-shield"></i>

<%=isAdmin?"Admin":"Employee"%>


</span>



</div>





<!-- Messages -->


<%

if(success!=null){

%>


<div id="message"
class="mb-5 p-4 rounded-lg bg-green-100 border border-green-400 text-green-700">


<i class="fa-solid fa-circle-check"></i>

<%=success%>


</div>


<%

}


if(error!=null){

%>


<div id="message"
class="mb-5 p-4 rounded-lg bg-red-100 border border-red-400 text-red-700">


<i class="fa-solid fa-circle-exclamation"></i>

<%=error%>


</div>


<%

}

%>




<script>

setTimeout(()=>{

let msg=document.getElementById("message");

if(msg)
msg.style.display="none";


},3000);


</script>






<!-- Add Category -->


<% if(isAdmin){ %>


<div class="card p-6 mb-8">


<h2 class="text-xl font-bold text-blue-700 mb-5">

<i class="fa-solid fa-plus"></i>

Add Category

</h2>



<form action="Category" method="post">


<input type="hidden" name="action" value="add">



<div class="grid md:grid-cols-2 gap-6">



<div>


<label class="font-semibold text-gray-700">

Category Name

</label>


<input

type="text"

name="categoryName"

placeholder="Enter category name"

required

class="w-full mt-2 px-4 py-3 border rounded-lg focus:ring-2 focus:ring-blue-500 outline-none">


</div>




<div>


<label class="font-semibold text-gray-700">

Description

</label>


<input

type="text"

name="description"

placeholder="Enter description"

required

class="w-full mt-2 px-4 py-3 border rounded-lg focus:ring-2 focus:ring-blue-500 outline-none">


</div>



</div>




<button

class="mt-6 bg-blue-600 hover:bg-blue-700 text-white px-6 py-3 rounded-lg font-semibold">


<i class="fa-solid fa-save"></i>

Add Category


</button>



</form>


</div>


<% } %>








<!-- Category Table -->


<div class="card overflow-hidden">


<table class="w-full">


<thead class="table-head text-white">


<tr>


<th class="py-4">ID</th>

<th>Name</th>

<th>Description</th>


<% if(isAdmin){ %>

<th>Action</th>

<% } %>


</tr>


</thead>




<tbody>



<%

if(categories!=null && !categories.isEmpty()){


for(CategoryDTO c:categories){

%>



<tr class="border-b text-center hover:bg-gray-50">



<td class="py-4 font-semibold">

<%=c.getCategoryId()%>

</td>



<td>

<i class="fa-solid fa-tag text-blue-600"></i>

<%=c.getCategoryName()%>


</td>




<td class="text-gray-600">


<%=c.getDescription()%>


</td>





<% if(isAdmin){ %>



<td>


<form action="Category" method="post">


<input type="hidden"
name="action"
value="delete">



<input type="hidden"
name="categoryId"
value="<%=c.getCategoryId()%>">


<button

onclick="return confirm('Delete this category?')"

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

<td colspan="<%=isAdmin?4:3%>"
class="py-6 text-center text-red-600">


<i class="fa-solid fa-box-open text-xl"></i>

<br>

No Categories Found


</td>


</tr>



<%

}

%>



</tbody>



</table>


</div>




</div>


</body>


</html>