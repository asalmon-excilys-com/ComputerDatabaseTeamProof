<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<%@ taglib uri="/WEB-INF/session.tld" prefix="session"%>  

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

	<h1>
		<c:out value="${page.tailleTable}"></c:out>
		computers found
	</h1>


	<div id="actions">



		<form action="TableauComputer.html" method="GET">

			<input type="search" id="searchbox" name="f" value="${page.f}"
				placeholder="Filter by computer name..."> <input
				type="submit" id="searchsubmit" value="Filter by name"
				class="btn primary">
				
				<input type="hidden" name="s" value="${page.s}">
		</form>


		<a class="btn success" id="add" href="ModifyOrAdd.html">Add a new computer</a>

	</div>

	<table class="computers zebra-striped">
		<thead>
			<tr>

				<session:headerTri />

			</tr>
		</thead>

		<tbody>

			<c:forEach items="${page.computers}" var="rs">
				<tr>
					<%-- 					<td><c:out value="${rs.name}"></c:out></td> --%>
					<td><a href="ModifyOrAdd.html?id=${rs.id}">${rs.name}</a></td>
					<td><c:choose>
							<c:when test="${rs.introduced == null}">
								<em>-</em>
							</c:when>
							<c:otherwise>
								<c:out value="${rs.introducedToString}"></c:out>
							</c:otherwise>
						</c:choose></td>

					<td><c:choose>
							<c:when test="${rs.discontinued == null}">
								<em>-</em>
							</c:when>
							<c:otherwise>
								<c:out value="${rs.discontinuedToString}"></c:out>
							</c:otherwise>
						</c:choose></td>

					<td><c:choose>
							<c:when test="${rs.company.id == null}">
								<em>-</em>
							</c:when>
							<c:otherwise>
								<c:out value="${rs.company.name}"></c:out>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div id="pagination" class="pagination">
		<ul>

			<c:choose>
				<c:when test="${page.p == 0}">
					<li class="prev disabled"><a>&larr; Previous</a></li>
				</c:when>
				<c:otherwise>
					<li class="prev"><a
						href="TableauComputer.html?p=${page.p-1}&s=${page.s}&f=${page.f}">&larr;
							Previous</a></li>
				</c:otherwise>
			</c:choose>



			<c:choose>
				<c:when test="${page.p*10+10 > page.tailleTable }">
					<li class="current"><a>Displaying ${page.p*10+1} to
							${page.tailleTable} of ${page.tailleTable}</a></li>
					<li class="next disabled"><a>Next &rarr;</a></li>
				</c:when>
				<c:otherwise>
					<li class="current"><a>Displaying ${page.p*10+1} to
							${page.p*10+10} of ${page.tailleTable}</a></li>
					<li class="next"><a
						href="TableauComputer.html?p=${page.p+1}&s=${page.s}&f=${page.f}">Next
							&rarr;</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>

	</section>

</body>
</html>