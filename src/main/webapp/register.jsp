<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">


<head>


<meta charset="UTF-8">

<title>Register | Inventory Management</title>


<script src="https://cdn.tailwindcss.com"></script>


<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">


<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">


<style>


body{

background:#F1F3F6;
font-family:'Inter',sans-serif;

}



.header{

background:#131A2C;

}



.card{

background:white;

border:1px solid #E7E9EE;

border-radius:14px;

box-shadow:0 15px 35px rgba(0,0,0,.10);

}



.input-box{

width:100%;

border:1px solid #D1D5DB;

border-radius:8px;

padding:12px 14px;

}



.input-box:focus{

outline:none;

border-color:#2874F0;

box-shadow:0 0 0 3px rgba(40,116,240,.15);

}



.btn{

background:#2874F0;

transition:.2s;

}



.btn:hover{

background:#1857C6;

}


</style>



</head>



<body class="min-h-screen flex flex-col">





<!-- Header -->


<header class="header text-white">


<div class="max-w-7xl mx-auto px-6 py-6">


<div class="flex items-center gap-4">


<div class="w-12 h-12 rounded-full bg-blue-600 flex items-center justify-center">

<i class="fa-solid fa-boxes-stacked text-xl"></i>

</div>




<div>


<h1 class="text-2xl font-extrabold">

Inventory Management System

</h1>


<p class="text-xs text-white/60 uppercase tracking-wide">

Seller Central ERP

</p>


</div>



</div>


</div>


</header>









<main class="flex-1 flex justify-center items-center px-5 py-10">



<div class="card w-full max-w-lg p-8">





<div class="text-center mb-7">


<div class="mx-auto w-16 h-16 rounded-full bg-blue-100 flex items-center justify-center">


<i class="fa-solid fa-user-plus text-blue-600 text-2xl"></i>


</div>



<h2 class="text-3xl font-extrabold text-gray-800 mt-4">


Create Account


</h2>


<p class="text-gray-500 text-sm mt-2">

Register to access inventory system

</p>



</div>







<form action="RegisterServlet" method="post">





<div class="grid md:grid-cols-2 gap-5">






<div>


<label class="font-semibold block mb-2">

<i class="fa-solid fa-user text-blue-600"></i>

Full Name

</label>


<input

class="input-box"

type="text"

name="fullName"

placeholder="Enter full name"

required>


</div>








<div>


<label class="font-semibold block mb-2">

<i class="fa-solid fa-envelope text-blue-600"></i>

Email

</label>


<input

class="input-box"

type="email"

name="email"

placeholder="Enter email"

required>


</div>








<div>


<label class="font-semibold block mb-2">

<i class="fa-solid fa-phone text-blue-600"></i>

Mobile

</label>


<input

class="input-box"

type="text"

name="mobile"

placeholder="Mobile number"

required>


</div>







<div>


<label class="font-semibold block mb-2">

<i class="fa-solid fa-user-tag text-blue-600"></i>

Username

</label>


<input

class="input-box"

type="text"

name="username"

placeholder="Username"

required>


</div>







<div>


<label class="font-semibold block mb-2">

<i class="fa-solid fa-lock text-blue-600"></i>

Password

</label>



<div class="relative">


<input

id="password"

class="input-box pr-12"

type="password"

name="password"

placeholder="Password"

required>



<button

type="button"

onclick="togglePassword()"

class="absolute right-4 top-3 text-gray-500">


<i id="eye"
class="fa-solid fa-eye"></i>


</button>


</div>


</div>








<div>


<label class="font-semibold block mb-2">

<i class="fa-solid fa-user-shield text-blue-600"></i>

Role

</label>



<select

name="role"

class="input-box">


<%--<option value="Admin">

Admin

</option>--%>


<option value="Employee">

Employee

</option>


</select>


</div>






</div>






<button

type="submit"

class="btn w-full text-white py-3 rounded-lg mt-7 font-semibold">


<i class="fa-solid fa-user-plus mr-2"></i>


Register


</button>



</form>







<%


String msg=(String)request.getAttribute("msg");


if(msg!=null){


%>



<div class="mt-5 bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded-lg">


<i class="fa-solid fa-circle-exclamation"></i>


<%=msg%>


</div>



<%

}

%>







<div class="text-center mt-7">


<p class="text-gray-600">


Already have an account?


<a href="Login.jsp"

class="text-blue-600 font-semibold hover:underline">


Login


</a>


</p>


</div>






</div>



</main>







<footer class="text-center text-gray-500 text-xs pb-6">


© 2026 Inventory Management System


<br>


Java Full Stack Project


</footer>








<script>


function togglePassword(){


let pass=document.getElementById("password");

let eye=document.getElementById("eye");



if(pass.type==="password"){


pass.type="text";

eye.classList.remove("fa-eye");

eye.classList.add("fa-eye-slash");


}

else{


pass.type="password";

eye.classList.remove("fa-eye-slash");

eye.classList.add("fa-eye");


}


}


</script>





</body>


</html>