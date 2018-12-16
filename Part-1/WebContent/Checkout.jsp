<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import = "org.brewingjava.model.Books" %>

<!-- All of the below code is referenced unless specified from https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_examples_material  -->
<!DOCTYPE html>
<html>
<title>BookWorm</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"><style>
body {font-family: "Roboto", sans-serif}
.w3-bar-block .w3-bar-item{padding:16px;font-weight:bold}
table.booktable {
	margin-left: auto;
	margin-right: auto;
}
</style>
<body>
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" id="myOverlay"></div>

<div class="w3-main">

<div id="myTop" class="w3-container w3-top w3-theme w3-large">
  <p><i class="fa fa-bars w3-button w3-teal w3-hide-large w3-xlarge" onclick="w3_open()"></i>
  <span id="myIntro" class="w3-hide">Welcome to Bookworm, place where Canada shop</span></p>

</div>

<header class="w3-container w3-theme" style="padding:64px 32px">
  <h1 class="w3-xxxlarge">BookWorm</h1>
</header>
		<%
			String username = (String) session.getAttribute("userName");
			if (username == null) {
		%>
		<div style="float: left">
			<h4>
				&nbsp;&nbsp;&nbsp;&nbsp;Welcome:<b> Guest</b>
			</h4>
		</div>
		<%
			} else {
		%>
		<div style="float: left">
			<h4>
				&nbsp;&nbsp;&nbsp;&nbsp;Welcome:<b><%=username%></b>
			</h4>
		</div>
		<div style="float: right">
			<a href="${pageContext.request.contextPath}/Logout">Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>

		<%} %>
		<div class="w3-container" style="padding:55px">

<form action="" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin" style="margin-left:60px!important; margin-right:60px!important;">
<h2 class="w3-center">Check Out here</h2>
 
 			<%
				ArrayList userDetails = (ArrayList) session.getAttribute("UserDetails");
			%>
			<%
				if (userDetails.size() != 0) {
			%>
           <c:forEach var="items" items="${UserDetails}">
 
 <div class="w3-row w3-section w3-text-black">
    <div class="w3-rest">
    <label for="fname"><i class="fa fa-user"></i> First Name</label>
      <input class="w3-input w3-border" id="fname" name="firstname" type="text" value='${items.userInfo.fname}' readonly>
    </div>
</div>

<div class="w3-row w3-section w3-text-black">
    <div class="w3-rest">
    <label for="lname"><i class="fa fa-user"></i> Last Name</label>
      <input class="w3-input w3-border" id="lname" name="lastname" type="text" value='${items.userInfo.lname}' readonly>
    </div>
</div>

<div class="w3-row w3-section w3-text-black">
    <div class="w3-rest">
    <label for="username"><i class="fa fa-user"></i> UserName</label>
      <input class="w3-input w3-border" id="username" name="username" type="text" value='${items.accountInfo.username}' readonly>
    </div>
</div>

<div class="w3-row w3-section w3-text-black">
    <div class="w3-rest">
    <label for="billingaddress"><i class="fa fa-address-card-o"></i> Billing Address</label>
      <input class="w3-input w3-border" id="billingaddress" name="billingaddress" type="text" value='${items.userInfo.billing}' readonly>
    </div>
</div>

<div class="w3-row w3-section w3-text-black">
    <div class="w3-rest">
    <label for="shippingaddress"><i class="fa fa-institution"></i> Shipping Address</label>
      <input class="w3-input w3-border" id="shippingaddress" name="shippingaddress" type="text" value='${items.userInfo.shipping}' readonly>
    </div>
</div>
   </c:forEach> 

    <% } %>

</form>

<div class="w3-container" style="padding:10px">

<form action="" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin" style="margin-left:50px!important; margin-right:50px!important;">
<h2 class="w3-center">Cart<i class="fa fa-shopping-cart"></i></h2>
<p><span class="price"></span></p>
     <%
							ArrayList<Books> cartList = (ArrayList<Books>) session.getAttribute("CartList");
							if (!cartList.isEmpty()) {
						%>
						<table class="booktable" border="0" style="color: black;" >
							<tr>
								<td>Title</td>
								<td>Price(Inc Tax)</td>
							
							<%
								float total = 0;
									for (Books book : cartList) {
										total += book.getPrice();
							%>
							<tr>
								<td><%=book.getTitle()%></td>
								<td>$<%=book.getPrice()%></td>
							</tr>
							<%
							}
						%>
						</table>
						
      <div class="w3-row w3-section w3-text-black" style="text-align: center">
      <p>Total (Includes Tax (13%)) <span class="price" style="color:black"><b><%=total%></b></span></p>
      <% } else { %>
      <h3 style="color:red;">Error Processing your request. Try again later</h3>
      <% } %>
</div>
</form>
 </div>
 <p class="w3-center">
 <form action="${pageContext.request.contextPath}/CreateOrder" method="Post">
<div style="text-align: center;">
<button class="w3-button w3-section w3-blue w3-ripple" type="submit"> Create Order </button></div>
</form>
</p>

<h2>Beautiful Book Quotes...!!</h2>
<div class="w3-container w3-sand w3-leftbar">
<p><i>I have always imagined that Paradise will be a kind of library.</i><br>
 Jorge Luis Borges</p>
</div>
</div>

<footer class="w3-container w3-theme" style="padding:22px">
  <p>Copyright © 2018 Brewing Java Corporation</p>
</footer>
     
</div>

<script>

// Open and close the sidebar on medium and small screens
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}

// Change style of top container on scroll
window.onscroll = function() {myFunction()};
function myFunction() {
    if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
        document.getElementById("myTop").classList.add("w3-card-4", "w3-animate-opacity");
        document.getElementById("myIntro").classList.add("w3-show-inline-block");
    } else {
        document.getElementById("myIntro").classList.remove("w3-show-inline-block");
        document.getElementById("myTop").classList.remove("w3-card-4", "w3-animate-opacity");
    }
}

// Accordions
function myAccordion(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-theme";
    } else { 
        x.className = x.className.replace("w3-show", "");
        x.previousElementSibling.className = 
        x.previousElementSibling.className.replace(" w3-theme", "");
    }
}
</script>
</body>
</html> 