<%@page import="org.brewingjava.model.UserDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
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
</style>
<body>

<nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="mySidebar">
  <a class="w3-bar-item w3-button w3-border-bottom w3-large" href="#"><img src="./images/Logo.JPG" style="width:250px; height:63px;"></a>
  <a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="w3_close()">Close <i class="fa fa-remove"></i></a>
  <a class="w3-bar-item w3-button w3-teal" href="Welcome.jsp">Home</a>
  <a class="w3-bar-item w3-button" href="AboutUs.jsp">About Us</a>
  <a class="w3-bar-item w3-button" href="Team.jsp">Team</a>
  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=All">View All Books</a>
  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=featured">Featured Books</a>
  <div>
    <a class="w3-bar-item w3-button" onclick="myAccordion('demo')" href="javascript:void(0)">Categories <i class="fa fa-caret-down"></i></a>
    <div id="demo" class="w3-hide">
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Business and Finance">Business and Finance</a>
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Biography and Memoir">Biography and Memoir</a>
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Computers">Computers</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Entertainment">Entertainment</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=History">History</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Fiction">Fiction</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Science Fiction">Science Fiction</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Self-Help">Self-Help</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Health">Health</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Science and Nature">Science and Nature</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Poetry">Poetry</a>
    </div>
  </div>
</nav>

<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" id="myOverlay"></div>

<div class="w3-main" style="margin-left:250px;">

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

		<div class="w3-container" style="padding:32px">

<h3>What is BookWorm?</h3>
<ul class="w3-leftbar w3-theme-border" style="list-style:none">
 <li>Room for book lovers.</li>
 <li>Easier to browse, shop and get delivered at yours doorstep.</li>
 <li>We use third party standardized delivery service at no extra cost.</li>
 <li>Our mission is to bring the power of reading to your world.</li> <!--  copied from https://www.kobo.com  -->
 <li>Every 10th customer gets a free book from us.</li>
</ul>
<br>
<h2>Beautiful Book Quotes...!!</h2>
<div class="w3-container w3-sand w3-leftbar">
<p><i>Make it as simple as possible, but not simpler.</i><br>
Albert Einstein</p>
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
