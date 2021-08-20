<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<title>Dashboarch</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

</head>

<body>

	<div class="w3-sidebar w3-bar-block w3-light-grey w3-card"
		style="width: 130px">
		<div
			class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom">
			<i class="fas fa-user-secret me-2"></i>Admin
		</div>
		<button class="w3-bar-item w3-button tablink"
			onclick="openCity(event, 'Product')">Product</button>
		<button class="w3-bar-item w3-button tablink"
			onclick="openCity(event, 'Customer')">Customer</button>
		<button class="w3-bar-item w3-button tablink"
			onclick="openCity(event, 'Account')">Account</button>
		<button class="w3-bar-item w3-button tablink"
			onclick="openCity(event, 'Brand')">Brand</button>
		<a href="logout"
			class="list-group-item list-group-item-action bg-transparent text-danger fw-bold"><i
			class="fas fa-power-off me-2"></i>Logout</a>
	</div>




	<div style="margin-left: 130px">
		<nav
			class="navbar navbar-expand-lg navbar-primary bg-transparent py-4 px-4">
			<div class="d-flex align-items-center">
				<i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
				<h2 class="fs-2 m-0">Dashboard</h2>
			</div>

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle second-text fw-bold" href="#"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> <i class="fas fa-user me-2"></i>admin</a>
					</li>
				</ul>
			</div>
		</nav>


		<div id="Product" class="w3-container city">
			<h2 style="display: inline">List of Products</h2>
			<a href="newProduct" class="btn btn-primary fa fa-plus"
				style="position: fixed; left: 1200px;"> NEW</a>

			<div class="col">
				<table class="table bg-white rounded shadow-sm  table-hover">
					<thead>
						<tr>
							<th scope="col" width="50">#</th>
							<th scope="col">Name</th>
							<th scope="col">Image</th>
							<th scope="col">Price</th>
							<th scope="col">Description</th>
							<th scope="col">BrandID</th>
							<th scope="col">Actions</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listPro}" var="pro" varStatus="status">
							<tr>
								<th scope="row">${status.index + 1}</th>
								<td>${pro.name}</td>
								<td>${pro.img}</td>					
								<td>${pro.price}</td>
								<td>${pro.des}</td>
								<td>${pro.brandID}</td>
								<td>
									<a href="editProduct?id=${pro.id}">Edit</a>
									&nbsp;&nbsp; <a href="deleteProduct?id=${pro.id}">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

		<div id="Customer" class="w3-container city" style="display: none">

			<h2 style="display: inline">List of Customers</h2>
			<a href="newCustomer" class="btn btn-primary fa fa-plus"
				style="position: fixed; left: 1200px;"> NEW</a>

			<div class="col">
				<table class="table bg-white rounded shadow-sm  table-hover">
					<thead>
						<tr>
							<th scope="col" width="50">#</th>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Phone</th>
							<th scope="col">Address</th>
							<th scope="col">Account_id</th>
							<th scope="col">Actions</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listCus}" var="cus" varStatus="status">
							<tr>
								<th scope="row">${status.index + 1}</th>
								<td>${cus.name}</td>
								<td>${cus.email}</td>
								<td>${cus.phone}</td>
								<td>${cus.address}</td>
								<td>${cus.account_id}</td>
								<td>
									<a href="editCustomer?id=${cus.id}">Edit</a> 
									&nbsp;&nbsp; <a href="deleteCustomer?id=${cus.id}">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

		<div id="Account" class="w3-container city" style="display: none">

			<h2 class="col-2" style="display: inline">List of Accounts</h2>
			<a href="newAccount" class="btn btn-primary fa fa-plus"
				style="position: fixed; left: 1200px;"> NEW</a>

			<div class="col">
				<table class="table bg-white rounded shadow-sm  table-hover">
					<thead>
						<tr>
							<th scope="col" width="50">#</th>
							<th scope="col">UserName</th>
							<th scope="col">Password</th>
							<th scope="col">Position</th>
							<th scope="col">Actions</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listAcc}" var="acc" varStatus="status">
							<tr>
								<th scope="row">${status.index + 1}</th>
								<td>${acc.username}</td>
								<td>${acc.password}</td>
								<td>${acc.position}</td>
								<td><a href="editAccount?id=${acc.id}">Edit</a> &nbsp;&nbsp; <a
									href="deleteAccount?id=${acc.id}">Delete</a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

		<div id="Brand" class="w3-container city" style="display: none">

			<h2 style="display: inline">List of Brands</h2>
			<a href="newBrand" class="btn btn-primary fa fa-plus"
				style="position: fixed; left: 1200px;"> NEW</a>

			<div class="col">
				<table class="table bg-white rounded shadow-sm  table-hover">
					<thead>
						<tr>
							<th scope="col" width="50">#</th>
							<th scope="col">Name</th>
							<th scope="col">Address</th>
							<th scope="col">Phone</th>
							<th scope="col">Description</th>
							<th scope="col">Actions</th>


						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listBrand}" var="brand" varStatus="status">
							<tr>
								<th scope="row">${status.index + 1}</th>
								<td>${brand.name}</td>
								<td>${brand.address}</td>
								<td>${brand.phone}</td>
								<td>${brand.des}</td>
								<td><a href="editBrand?id=${brand.id}">Edit</a>
									&nbsp;&nbsp; <a href="deleteBrand?id=${brand.id}">Delete</a></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>

	</div>

	<script>
		function openCity(evt, cityName) {
			var i, x, tablinks;
			x = document.getElementsByClassName("city");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablink");
			for (i = 0; i < x.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" w3-red", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " w3-red";
		}
	</script>


</body>

</html>