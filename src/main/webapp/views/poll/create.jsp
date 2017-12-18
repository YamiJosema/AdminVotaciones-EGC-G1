


<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-end.js"></script>

<form:form action="poll/create.do" modelAttribute="poll">

	<form:hidden path="id" />
	<form:hidden path="questions" />

	<div>
		<form:label path="title">
			<spring:message code="poll.title" />:
		</form:label>
		<form:input path="title" />
		<form:errors cssClass="error" path="title" />
	</div>

	<div>
		<form:label path="description">
			<spring:message code="poll.description" />:
		</form:label>
		<form:input path="description" />
		<form:errors cssClass="error" path="description" />
	</div>

	<div>
		<form:label path="census">
			<spring:message code="poll.census" />:
			</form:label>
		<form:select id="censuses" path="census">
			<form:options items="${censuses}" itemValue="id" itemLabel="title" />
		</form:select>
		<form:errors cssClass="error" path="census" />
	</div>


	<div>
		<form:label path="startDate">
			<spring:message code="poll.startDate" />:
		</form:label>
		<form:input path="startDate" />
		<form:errors cssClass="error" path="startDate" />
	</div>

	<div>
		<form:label path="endDate">
			<spring:message code="poll.endDate" />:
		</form:label>
		<form:input path="endDate" />
		<form:errors cssClass="error" path="endDate" />
	</div>

	<br />

	<hr>
	<input type="submit" name="save" value="<spring:message code="poll.save" />" />&nbsp; 
	<br />

</form:form>