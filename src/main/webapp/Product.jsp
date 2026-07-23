<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List,dto.ProductDTO,dto.UserDTO"%>


<%

List<ProductDTO> products =
(List<ProductDTO>)request.getAttribute("products");


UserDTO user =
(UserDTO)session.getAttribute("user");


boolean isAdmin =
user != null && "Admin".equalsIgnoreCase(user.getRole());

%>



<!DOCTYPE html>
<html lang="en">


<head>


<meta charset="UTF-8">

<title>Product Management</title>


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


.table-head{

background:#131A2C;

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


<i class="fa-solid fa-box text-blue-600"></i>

Product Management


</h1>


<p class="text-gray-500 mt-1">

Manage inventory products

</p>


</div>



<div class="bg-blue-100 text-blue-700 px-4 py-2 rounded-full font-semibold">


<i class="fa-solid fa-user-shield"></i>

<%=isAdmin?"Admin":"Employee"%>


</div>



</div>





<!-- Add Product -->


<% if(isAdmin){ %>


<div class="card p-7 mb-8">


<h2 class="text-xl font-bold text-blue-700 mb-6">


<i class="fa-solid fa-plus"></i>

Add Product


</h2>



<form action="Product" method="post">


<input type="hidden" name="action" value="add">



<div class="grid grid-cols-1 md:grid-cols-2 gap-5">



<div>

<label class="font-semibold">
Product Name
</label>

<input class="input mt-2"
type="text"
name="productName"
required
placeholder="Enter product name">

</div>




<div>

<label class="font-semibold">
Category ID
</label>

<input class="input mt-2"
type="number"
name="categoryId"
required>

</div>





<div>

<label class="font-semibold">
Supplier ID
</label>

<input class="input mt-2"
type="number"
name="supplierId"
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
Quantity
</label>

<input class="input mt-2"
type="number"
name="quantity"
required>

</div>





<div>

<label class="font-semibold">
Description
</label>

<input class="input mt-2"
type="text"
name="description"
required>

</div>





<div>

<label class="font-semibold">
Manufacture Date
</label>

<input class="input mt-2"
type="date"
name="manufactureDate"
required>

</div>





<div>

<label class="font-semibold">
Expiry Date
</label>

<input class="input mt-2"
type="date"
name="expiryDate"
required>

</div>



</div>





<button

class="mt-7 bg-blue-600 hover:bg-blue-700 text-white px-7 py-3 rounded-lg font-semibold">


<i class="fa-solid fa-save"></i>

Add Product


</button>



</form>


</div>


<% } %>







<!-- Product Table -->


<div class="card overflow-hidden">


<div class="p-6">


<h2 class="text-xl font-bold text-green-600">


<i class="fa-solid fa-list"></i>

Product List


</h2>


</div>





<div class="overflow-x-auto">


<table class="w-full">



<thead class="table-head text-white">


<tr>


<th class="p-4">ID</th>
<th>Product</th>
<th>Category</th>
<th>Supplier</th>
<th>Price</th>
<th>Qty</th>
<th>Description</th>
<th>MFG</th>
<th>EXP</th>


<% if(isAdmin){ %>

<th>Action</th>

<% } %>


</tr>


</thead>





<tbody>



<%

if(products!=null && !products.isEmpty()){


for(ProductDTO p:products){


%>



<tr class="border-b text-center hover:bg-gray-50">


<td class="p-4">
<%=p.getProductId()%>
</td>



<td class="font-semibold">

<i class="fa-solid fa-box text-blue-600"></i>

<%=p.getProductName()%>

</td>




<td>
<%=p.getCategoryName()%>
</td>



<td>
<%=p.getSupplierName()%>
</td>




<td>

₹ <%=p.getPrice()%>

</td>




<td>

<span class="bg-green-100 text-green-700 px-3 py-1 rounded-full">

<%=p.getQuantity()%>

</span>

</td>




<td>

<%=p.getDescription()%>

</td>




<td>
<%=p.getManufactureDate()%>
</td>




<td>
<%=p.getExpiryDate()%>
</td>




<% if(isAdmin){ %>


<td>


<form action="Product" method="post"
onsubmit="return confirm('Delete Product?')">


<input type="hidden"
name="action"
value="delete">


<input type="hidden"
name="productId"
value="<%=p.getProductId()%>">


<button

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

<td colspan="10"
class="text-center py-6 text-red-600">


<i class="fa-solid fa-box-open text-xl"></i>

<br>

No Products Found


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