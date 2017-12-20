<%--
 * header.jsp
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
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	
<!-- Bootstrap -->
<link rel="stylesheet" href="styles/common.css" type="text/css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximun-scale=1.0, minimun-scale=1.0">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<header>
		<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
		<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-1" aria-expanded="false" >
						<span class="sr-only">Menu</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					
					<a href="https://authb.agoraus1.egc.duckdns.org/"  class="navbar-brand">Home</a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-1">
					<ul class="nav navbar-nav">
						<li><a href=""><spring:message code="master.page.login" /></a></li>
						<li><a href=""><spring:message code="master.page.amdvotes"/></a></li>
						<li><a href=""><spring:message	code="master.page.amdcensos"/></a></li>
						<li><a href=""><spring:message	code="master.page.cabina"/></a></li>
						<li><a href=""><spring:message	code="master.page.visualizar"/></a></li>
					</ul>
				</div>
			</div>
		</nav>
		
	</header>
	<section class="jumbotron " >
		<div class="container">
			<h4 class="jumbotron-text"><spring:message code="master.page.amdvotes"/></span></h4>
		</div>
	
	</section>
	

	



