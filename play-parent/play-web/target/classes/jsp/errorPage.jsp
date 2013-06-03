<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>      
<!DOCTYPE html>
<html>
<head>
<title>Computers database</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="main.css">
</head>
<body>

	<header class="topbar">
	<h1 class="fill">
		<a href="TableauComputer.html"> Play 2.0 sample application
			&mdash; Computer database </a>
	</h1>
	</header>

	<section id="main">
	
		<h1>Error Page</h1>

			 <div class="alert-message warning">
	            <strong>Error: </strong>${exception.message}
	        </div>

	</section>

</body>
</html>