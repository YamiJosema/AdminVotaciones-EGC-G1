<%--
 * footer.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="date" class="java.util.Date" />
<!-- Bootstrap -->
<link rel="stylesheet" href="styles/common.css" type="text/css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">


<footer class="footer">
	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
		<div class="container-fluid">
			<div class="container">
				<div class="row margin-footer">
				<br>
			<div class="col-md-2 col-sm-2 col-xs-2">
				<a class="btn btn-customed btn-sm" id="idiomas" href="?language=en">En</a>
				<a class="btn btn-customed  btn-sm" id="idiomas" href="?language=es">Es</a>
				
			</div>
			<div class="col-md-8 col-sm-5 col-xs-6  align-text">
				<a class="btn btn-link align-text"><spring:message code="welcome.greeting.current.time" /> ${moment}</a>
			</div>
			
			<div class= "col-md-1 col-sm-2 col-sm-offset-1 col-xs-2 col-xs-offset-2">
				<a class="btn btn-customed  btn-sm " href="welcome/aboutus.do" > <spring:message code="about.boton" /></a>
			</div>
			
			
		</div>
			</div>
			</div>
		</nav>
		</footer>


