<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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


	<h1>Create a new Computer</h1>



	<form action="saveComputer.html" method="POST">


		<fieldset>

			<div class="clearfix ${nameError }">
				<label for="name">Computer name</label>
				<div class="input">

					<input type="text" id="name" name="name" value=""> <span
						class="help-inline">Required</span>
				</div>
			</div>
			<div class="clearfix ${introducedError}">
				<label for="introduced">Introduced date</label>
				<div class="input">

					<input type="text" id="introduced" name="introduced" value="">

					<span class="help-inline">Date (&#x27;yyyy-MM-dd&#x27;)</span>
				</div>
			</div>
			<div class="clearfix ${discontinuedError}">
				<label for="discontinued">Discontinued date</label>
				<div class="input">

					<input type="text" id="discontinued" name="discontinued" value="">

					<span class="help-inline">Date (&#x27;yyyy-MM-dd&#x27;)</span>
				</div>
			</div>
			<div class="clearfix ">
				<label for="company">Company</label>
				<div class="input">

					<select id="company" name="company">

						<option class="blank" value="">-- Choose a company --</option>


						<c:forEach items="${page.companies}" var="cie">

								<c:choose>
									<c:when test="${cie.id == computer.company.id }">
										<option value="${cie.id }" selected>${cie.name }</option>
									</c:when>
									<c:otherwise>
										<option value="${cie.id }">${cie.name }</option>
									</c:otherwise>

								</c:choose>
							</c:forEach>

					</select> <span class="help-inline"></span>
				</div>
			</div>

		</fieldset>

		<div class="actions">
			<input type="submit" value="Create this computer" class="btn primary">
			or <a href="TableauComputer.html" class="btn">Cancel</a>
		</div>


	</form>



	</section>

</body>
</html>