<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<title>BookWorm</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-teal.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: "Roboto", sans-serif
}

.w3-bar-block .w3-bar-item {
	padding: 16px;
	font-weight: bold
}

.t1 {
	margin: 0px auto;
	margin-left: auto;
	margin-right: auto;
}

.booktable {
	margin: 0px auto;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<body>

	<nav
		class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card"
		style="z-index: 3; width: 250px;" id="mySidebar">
			<a class="w3-bar-item w3-button w3-border-bottom w3-large" href="#"><img src="./images/Logo.JPG" style="width: 250px; height: 63px;"></a> 
			<a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="w3_close()">Close <i class="fa fa-remove"></i></a>
			<a class="w3-bar-item w3-button w3-teal" href="Welcome.jsp">Home</a>
			<a class="w3-bar-item w3-button" href="AboutUs.jsp">About Us</a> 
			<a class="w3-bar-item w3-button" href="Team.jsp">Team</a> 
			<a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=All">View All Books</a> <a class="w3-bar-item w3-button"
			href="${pageContext.request.contextPath}/ShowBooks?category=featured">Featured Books</a>
			
		<div>
			<a class="w3-bar-item w3-button" onclick="myAccordion('demo')" href="javascript:void(0)">Categories <i class="fa fa-caret-down"></i></a>
				<div id="demo" class="w3-hide">
				<a class="w3-bar-item w3-button"
					href="${pageContext.request.contextPath}/ShowBooks?category=Business and Finance">Business
					and Finance</a> <a class="w3-bar-item w3-button"
					href="${pageContext.request.contextPath}/ShowBooks?category=Biography and Memoir">Biography
					and Memoir</a> <a class="w3-bar-item w3-button"
					href="${pageContext.request.contextPath}/ShowBooks?category=Computers">Computers</a>
				<a class="w3-bar-item w3-button"
					href="${pageContext.request.contextPath}/ShowBooks?category=Entertainment">Entertainment</a>
				<a class="w3-bar-item w3-button"
					href="${pageContext.request.contextPath}/ShowBooks?category=History">History</a>
				<a class="w3-bar-item w3-button"
					href="${pageContext.request.contextPath}/ShowBooks?category=Fiction">Fiction</a>
				<a class="w3-bar-item w3-button"
					href="${pageContext.request.contextPath}/ShowBooks?category=Science Fiction">Science
					Fiction</a> <a class="w3-bar-item w3-button"
					href="${pageContext.request.contextPath}/ShowBooks?category=Self-Help">Self-Help</a>
				<a class="w3-bar-item w3-button"
					href="${pageContext.request.contextPath}/ShowBooks?category=Health">Health</a>
				<a class="w3-bar-item w3-button"
					href="${pageContext.request.contextPath}/ShowBooks?category=Science and Nature">Science
					and Nature</a> <a class="w3-bar-item w3-button"
					href="${pageContext.request.contextPath}/ShowBooks?category=Poetry">Science
					and Nature</a>
			</div>
		</div>
	</nav>

	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" id="myOverlay"></div>

	<div class="w3-main" style="margin-left: 250px;">

		<div id="myTop" class="w3-container w3-top w3-theme w3-large">
			<p>
				<i class="fa fa-bars w3-button w3-teal w3-hide-large w3-xlarge"
					onclick="w3_open()"></i> <span id="myIntro" class="w3-hide">Welcome
					to Bookworm, place where Canada shop</span>
			</p>

		</div>


		<header class="w3-container w3-theme" style="padding: 64px 32px">
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

		<%
			}
		%>
		<div class="w3-container" style="padding: 32px">

			<h3>Let's see what we got for you !!</h3>

			<p>Based on your recent click</p>

			<h4>Book Details</h4>

			<br>
			<%
				ArrayList bookDetails = (ArrayList) request.getAttribute("Bookdetails");
				String error = (String) request.getAttribute("error");
			%>
			<%
				if (error == null) {
			%>

			<%
				if (bookDetails.size() != 0) {
			%>

			<table class="t1" style="display: inline-block;" border="0"
				align="center">
				<td><img src="./images/book.jpg" alt="Book" height="160px"
					width="100px"></td>
			</table>
			<table class="booktable" style="display: inline-block;" border="0"
				width="60%" height="50%">

				<tr>
					<td><b>Details</b></td>
				</tr>
				<c:forEach var="items" items="${Bookdetails}">
					<tr>
						<td><b>Author</b> : ${items.author}</td>
					</tr>
					<tr>
						<td><b>ID</b> : ${items.bookid}</td>
					</tr>
					<tr>
						<td><b>Title</b> : ${items.title}</td>
					</tr>
					<tr>
						<td><b>Category</b> : ${items.category}</td>
					</tr>
					<tr>
						<td><b>Price</b>: ${items.price}</td>
					</tr>
				</c:forEach>
			</table>

			<%
				} else {
			%>
			<h3 style="color: red;">Error Processing your request. Try again
				later</h3>
			<%
				}
				} else {
			%>
			<h3 style="color: red;">Error Processing your request. Try again
				later</h3>
			<%
				}
			%>

			<b><a href="javascript:close_window();"> Close Page</a></b>
			<h2>Beautiful Book Quotes...!!</h2>
			<div class="w3-container w3-sand w3-leftbar">
				<p>
					<i>Good books don't give up all their secrets at once.</i><br>
					Stephen King
				</p>
			</div>
		</div>

		<footer class="w3-container w3-theme" style="padding: 22px">
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
		window.onscroll = function() {
			myFunction()
		};
		function myFunction() {
			if (document.body.scrollTop > 80
					|| document.documentElement.scrollTop > 80) {
				document.getElementById("myTop").classList.add("w3-card-4",
						"w3-animate-opacity");
				document.getElementById("myIntro").classList
						.add("w3-show-inline-block");
			} else {
				document.getElementById("myIntro").classList
						.remove("w3-show-inline-block");
				document.getElementById("myTop").classList.remove("w3-card-4",
						"w3-animate-opacity");
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
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-theme", "");
			}
		}
		var idList = new Array();
		$('.submitbutton').click(function(e) {
			var _bookId = $(this).parent().find('.bookId').val();
			var _bookName = $(this).parent().find('.title').val();
			console.log(_bookName);
			//DO your AJAX call here
			idList.push(_bookId);
			console.log(idList.length);
			var i;
			for (i = 0; i < idList.length; i++) {
				console.log(idList[i]);
			}
			document.getElementById("idList").value = idList;
			document.location.href = "Homepage.jsp?idList=" + idList;
			//idList = '@Session["idList"]'
			alert(_bookName + ' Added to cart ');
			return false;
		});

		function close_window() {
			if (confirm("Close Window?")) {
				close();
			}
		}
	</script>

</body>
</html>