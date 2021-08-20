<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Online Shop</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/style.css">
</head>

<body>
	<header>
		<div class="header">
			<div class="logo">
				<img src="resources/images/logox.png" alt="logo">
			</div>
			<nav class="desktop-nav" style="margin-top: 6px">
				<ul class="menu" >
					<li class="menu-item"><a href="#" class="menu-link"
						style="font-size: 20px; color: black;">Men</a></li>
					<li class="menu-item"><a href="#" class="menu-link"
						style="font-size: 20px; color: black;">Women</a></li>
					<li class="menu-item"><a href="#" class="menu-link"
						style="font-size: 20px; color: black;">Children</a></li>

				</ul>
			</nav>
			<div class="search-container" style="margin-left: 80px">
				<form action="#">
					<input type="text" placeholder=".  Search....." name="search" size="50" style="height: 27px; border-radius: 10px;">
					<button type="submit">
						<i class="fa fa-search"></i>
					</button>
				</form>
			</div>

			<nav class="mobile-nav">
				<div class="mobile-nav-icon">
					<span></span> <span></span> <span></span>
				</div>
			</nav>
			<div class="cart" style="margin-left: 200px; margin-top: 5px">
				<a href="#" class="fa fa-shopping-cart" style="font-size: 20px; color: black;">
					Cart</a>
			</div>
			<div class="account" style="margin-left: 15px; ; margin-top: 5px">
				<a href="login" class="fa fa-user" style="font-size: 20px; color: black;">
					${status != 'notlogin' ? acc.username : "Login"} </a>
			</div>
		</div>
	</header>
	<main>
		<section class="products">
			<div class="heading">
				<h2>Featured products</h2>
				<p>Everything that's new</p>
			</div>
			<div class="products-item">
				<c:forEach items="${listPro}" var="pro" varStatus="status">
					<div class="item">
						<div class="item-image">
							<img src="resources/images/${pro.img}" />
							<div class="button item-button">
								<a href="productDetail">Add to Cart</a> <a href="productDetail?id=${pro.id}">Quick View</a>
							</div>
						</div>
						<div class="item-title">
							<h5>${pro.name}</h5>
							<p>${pro.price}$</p>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="button viewAll-button">
				<a href="#">view all items</a>
			</div>
		</section>
	</main>
</body>

</html>