<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="nl.devlab.devLapp.form.NameForm"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="include/head.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	$('#formBlock').fancyfields({
		customScrollBar: true, cleanOnFocus: false
	});	

	$("#addButton").click(function() {
		$("#inputForm").attr("action", "addName.do");
		$("#inputForm").submit();
	});
	$("#deleteButton").click(function() {
		$("#inputForm").attr("action", "deleteName.do");
		$("#inputForm").submit();
	});
	
});
</script>

<body>
	<div class="main">
		<jsp:include page="include/title.jsp" />
		
		<!-- content holder -->
		<div class="content_holder">

			<form:form id="inputForm"  method="post" action="saveNameForm.do"  modelAttribute="nameForm">

				<div class="form_block form_block_wide" id="formBlock">
					<div class="cluster" >
						<h4><span><spring:message code="nameForm.label.cluster.nameEntry" /></span></h4>
						
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td style="width: 280px">
								<form:label path="name"><spring:message code="nameForm.label.name" /></form:label>
							</td>
							<td>
								<div class="input_bg">
									<form:input path="name" />
								</div>
							</td>
							<form:errors path="name">
							<td>
								<a href="#errors"><span class="warning"><spring:message code="error.invalidInput" /></span></a>
							</td>	
							</form:errors>
						</tr>
						</table>
						
						<a href="#" class="btn" id="addButton" style="margin-right: 60px;";">
							<span>
								<img src="img/icon_add.gif" alt="" style="margin-top:11px" /><spring:message code="button.add" />
							</span>
						</a>
												
					</div>
				</div>
				
				<div class="form_block form_block_wide" id="formBlock">
					<div class="cluster" >
						<h4><span><spring:message code="nameForm.label.cluster.nameList" /></span></h4>
						
						<table class="data dataTable">
						<thead>
							<tr>
								<th></th>
								<th><spring:message code="nameForm.label.nameId"/></th>
								<th><spring:message code="nameForm.label.name"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${nameList}" var="nameList" varStatus="status">
								<c:set var="nameEntity" value="${nameList}" scope="page" />
								<tr>
								    <td><form:radiobutton path="nameId" value="${nameEntity.nameId}"/></td>
								    <td><c:out value="${nameEntity.nameId}" /></td>
								    <td><c:out value="${nameEntity.name}" /></td>
								</tr>
							</c:forEach>
						</tbody>
						</table>
												
						<c:if  test="${!empty nameList}">
						<a href="#" class="btn" id="deleteButton" style="float:left;">
							<span>
								<img src="img/icon_remove.gif" alt="" style="margin-top:10px" /><spring:message code="button.delete" />
							</span>
						</a>
						</c:if>
					</div>
				</div>

				<div></div>
				
				<%@ include file="include/formError.jsp" %>
				
			</form:form>
							
		</div> <!-- content holder end -->
	</div> <!-- main end -->
</body>
</html>