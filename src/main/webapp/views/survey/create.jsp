


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


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
 <script>
 $.datepicker.regional['es'] = {
 closeText: 'Cerrar',
 prevText: '<Ant',
 nextText: 'Sig>',
 currentText: 'Hoy',
 monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
 monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
 dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
 dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
 dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
 weekHeader: 'Sm',
 dateFormat: 'dd/mm/yy',
 firstDay: 1,
 isRTL: false,
 showMonthAfterYear: false,
 yearSuffix: ''
 };
 $.datepicker.setDefaults($.datepicker.regional['es']);
 $(function() {
	    $( "#datepicker" ).datepicker();
	    $( "#datepicka" ).datepicker();
	  });
</script>

  <br/>
  <br/>
  <br/>
 <div class ="container">
	<div class="container-fluid">
	<div class="col-md-8 col-md-offset-2">
	<form:form action="${actionURL}" modelAttribute="survey">
	<div class="panel panel-default">
	
		<div class="panel-heading">
			<h4><strong><spring:message code = "survey.create"/></strong></h4>
		</div>
		<div class="panel-body">
				<div Class="texto">
				<form:hidden path="id" />
				<form:hidden path="version" />
				<form:hidden path="questions" />
				<div class="form-group">
				<form:label  path="name" size="50">
					<spring:message  code="survey.name" />:
				</form:label>
				<form:input class="form-control" path="name"/>
				<form:errors cssClass="error" path="name" />
				</div>
				<div class="form-group">
				<form:label path="description">
					<spring:message code="survey.description" />:
				</form:label>
				<form:input class="form-control" path="description" />
				<form:errors cssClass="error" path="description" />
				</div>
				<form:label path="photo" for="archivo"><spring:message code="survey.photo" />:</form:label>
				<form:input type="file" id="archivo" path="photo" class="btn-link"/>
					<p class="help-block">Max: 5 MB</p>
				<form:errors cssClass="error" path="photo" />
			
			</div>
			<jstl:if test="${survey.id != 0 and survey.questions.size()>0}">
				<jstl:forEach var="question" items="${survey.questions}">
		    		<label><spring:message code="survey.question"/></label><jstl:out value="${question.text}"/>
					<br>
				</jstl:forEach>
			</jstl:if>
			<br/>
			
			
			
			<input class="btn btn-primary" type="submit" name="addQuestion" value="<spring:message code="survey.add.question" />" />
			&nbsp; 
			<input class="btn btn-primary" type="button" name="cancel" 
				value="<spring:message code="survey.cancel" />"
				onclick="javascript: window.location.replace('http://localhost:8080/CreacionAdminVotaciones/');" />
			<br />
	</div>


</div>
</form:form>
</div></div>
  </div>
  <br/>
  <br/>
  <br/>
  <br/>
