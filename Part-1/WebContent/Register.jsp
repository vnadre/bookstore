<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</style>
<body>

<!-- code referenced from https://stackoverflow.com/questions/24176684/how-to-show-alert-in-a-jsp-from-a-servlet-and-then-redirect-to-another-jsp -->
	<c:if test="${not empty error}">
		<script>
			window.addEventListener("load", function() {
				alert("This account name already exists. Try again!");
			});
		</script>
	</c:if>
<!-- code end -->

<nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="mySidebar">
  <a class="w3-bar-item w3-button w3-border-bottom w3-large" href="#"><img src="./images/Logo.JPG" style="width: 250px; height: 63px;"></a>
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

<div class="w3-container" style="padding:32px">

<form action="${pageContext.request.contextPath}/Register" onsubmit="return validate();" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
<h2 class="w3-center">Registration</h2>
 
 <div class="w3-row w3-section">
    <div class="w3-rest">
      <input class="w3-input w3-border" id="fname" name="fname" type="text" placeholder="First Name">
    </div>
</div>

<div class="w3-row w3-section">
    <div class="w3-rest">
      <input class="w3-input w3-border" id="lname" name="lname" type="text" placeholder="Last Name">
    </div>
</div>

<div class="w3-row w3-section">
    <div class="w3-rest">
      <input class="w3-input w3-border" id="accountname" name="accountname" type="text" placeholder="Account Name">
    </div>
</div>

<div class="w3-row w3-section">
    <div class="w3-rest">
      <input class="w3-input w3-border" id="password" name="password" type="password" pattern=".{6,}" title="Six or more characters" placeholder="Password">
    </div>
</div>

<div class="w3-row w3-section">
    <div class="w3-rest">
      <input class="w3-input w3-border" id="confirmpassword" name="confirmpassword" type="password" placeholder="Confirm Password">
    </div>
</div>

<div class="w3-row w3-section">
    <div class="w3-rest">
      <input class="w3-input w3-border" id="billing" name="billing" type="text" placeholder="Billing Address">
    </div>
</div>

<input type="checkbox" id="check" onclick="makeSame()">&nbsp;Same as above

<div class="w3-row w3-section">
    <div class="w3-rest">
      <input class="w3-input w3-border" id="shipping" name="shipping" type="text" placeholder="Shipping Address">
    </div>
</div>

<p class="w3-center">
<button class="w3-button w3-section w3-blue w3-ripple" type="submit" > Register </button>
</p>
</form>
<form action="${pageContext.request.contextPath}/Login.jsp" method="get">
<button class="w3-button w3-section w3-blue w3-ripple" type="submit" style="display:block; margin:auto;"> Back To Login </button>
</form>




<h2>Beautiful Book Quotes...!!</h2>
<div class="w3-container w3-sand w3-leftbar">
<p><i>There is no friend as loyal as a book.</i><br>
Ernest Hemingway</p>
</div>
</div>

<footer class="w3-container w3-theme" style="padding:22px">
  <p>Copyright © 2018 Brewing Java Corporation</p>
</footer>
     
</div>

<script>

//	***Our code starts
//Make the billing and shipping address same 
function makeSame() {
	var checkBox = document.getElementById("check");
	var billingAdd = document.getElementById("billing").value;
	if (checkBox.checked == true) {
		document.getElementById("shipping").value = billingAdd;
	}
}

function validate() {
	var accname = document.getElementById("accountname").value;
	var pass = document.getElementById("password").value;
	var confirmpass = document.getElementById("confirmpassword").value;
	var billingAdd = document.getElementById("billing").value;
	var shippingAdd = document.getElementById("shipping").value;
	
	if (accname === "" || confirmpass === "" || pass === "" || billingAdd === "" || shippingAdd === "") {
		alert("None of the fields should be left blank!!");
		return false;
	}
	else if (pass != confirmpass) {
		alert("Passwords don't match!");
		return false;
	}
	else {
		document.form.submit();
        return true;
	}
}

//	***Our code ends


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