<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Login | Inventory Management</title>

<script src="https://cdn.tailwindcss.com"></script>

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">


<style>

:root{
    --bg:#F1F3F6;
    --navy:#131A2C;
    --blue:#2874F0;
    --orange:#FF9F00;
    --text:#212121;
    --line:#E7E9EE;
}


body{
    background:var(--bg);
    font-family:'Inter',sans-serif;
}


/* Top Brand */

.header{
    background:var(--navy);
}


/* Login Card */

.login-card{

    background:white;
    border:1px solid var(--line);
    border-radius:12px;

    box-shadow:
    0 10px 25px rgba(0,0,0,0.08);

}


.input-box{

    width:100%;
    border:1px solid #D1D5DB;
    border-radius:8px;
    padding:12px 15px;
    outline:none;

}


.input-box:focus{

    border-color:var(--blue);
    box-shadow:0 0 0 3px rgba(40,116,240,0.15);

}


.login-btn{

    background:var(--blue);
    transition:.2s;

}


.login-btn:hover{

    background:#1857C6;

}


</style>

</head>


<body class="min-h-screen">


<!-- Header -->

<div class="header text-white">

    <div class="max-w-7xl mx-auto px-6 py-6">

        <div class="flex items-center gap-3">

            <div class="w-12 h-12 rounded-full bg-blue-600 flex items-center justify-center">

                <i class="fa-solid fa-boxes-stacked text-xl"></i>

            </div>


            <div>

                <h1 class="text-2xl font-extrabold">

                    Inventory Management System

                </h1>

                <p class="text-xs text-white/60 uppercase tracking-wider">

                    Seller Central

                </p>

            </div>


        </div>

    </div>

</div>



<!-- Login Section -->


<div class="flex items-center justify-center px-5 py-12">


<div class="login-card w-full max-w-md p-8">



<div class="text-center mb-7">


<div class="mx-auto w-16 h-16 rounded-full bg-blue-100 flex items-center justify-center">

<i class="fa-solid fa-user-lock text-2xl text-blue-600"></i>

</div>


<h2 class="text-3xl font-extrabold mt-4 text-gray-800">

Login

</h2>


<p class="text-gray-500 text-sm mt-2">

Access your inventory dashboard

</p>


</div>




<form action="login" method="post">



<!-- Email -->

<div class="mb-5">


<label class="block text-gray-700 font-semibold mb-2">

<i class="fa-solid fa-envelope text-blue-600"></i>
Email

</label>


<input

type="email"

name="email"

placeholder="Enter Email"

required

class="input-box"

/>


</div>





<!-- Password -->


<div class="mb-6">


<label class="block text-gray-700 font-semibold mb-2">


<i class="fa-solid fa-lock text-blue-600"></i>
Password


</label>


<input

type="password"

name="password"

placeholder="Enter Password"

required

class="input-box"

/>


</div>




<button

type="submit"

class="login-btn w-full text-white font-semibold py-3 rounded-lg">

<i class="fa-solid fa-right-to-bracket mr-2"></i>

Login


</button>




</form>





<%

String msg=(String)request.getAttribute("msg");

if(msg!=null){

%>


<div class="mt-5 bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded-lg text-sm">


<i class="fa-solid fa-circle-exclamation"></i>

<%=msg%>


</div>


<%

}

%>





<div class="text-center mt-7">


<p class="text-gray-600">


Don't have an account?


<a href="register.jsp"

class="text-blue-600 font-semibold hover:underline">


Register


</a>


</p>


</div>




</div>


</div>



<footer class="text-center text-gray-500 text-xs pb-6">


© 2026 Inventory Management System · Java Full Stack Project


</footer>



</body>

</html>