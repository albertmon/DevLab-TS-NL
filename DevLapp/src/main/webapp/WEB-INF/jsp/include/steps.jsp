<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
$(document).ready(function() {

	$(".stepLink").click(function() {
		$("#formDestination").attr("value", $(this).attr("destination"));
		$("#inputForm").submit();
	});
	
});
</script>

			<div class="steps">
				<ul>
					<c:choose>
  						<c:when test="${empty outputWaterParametersForm}">
  							<li class="gray"><span>1</span><spring:message code="step.outputWaterParameters" /></li>
  						</c:when>
  						<c:when test="${not empty outputWaterParametersForm && param.stepId == 1}">
  							<li class="black"><span>1</span><spring:message code="step.outputWaterParameters" /></li>
  						</c:when>
  						<c:otherwise>
  							<li class="green"><a style="color:#39A536;" href="#" class="stepLink" destination="outputWaterParameters.do" ><span>1</span><spring:message code="step.outputWaterParameters" /></a></li>
  						</c:otherwise>
  					</c:choose>
					
					
					<c:choose>
  						<c:when test="${empty feedWaterParametersForm}">
  							<li class="gray"><span>2</span><spring:message code="step.feedwaterParameters" /></li>
  						</c:when>
  						<c:when test="${not empty feedWaterParametersForm && param.stepId == 2}">
  							<li class="black"><span>2</span><spring:message code="step.feedwaterParameters" /></li>
  						</c:when>
  						<c:otherwise>
  							<li class="green"><a style="color:#39A536;" href="#" class="stepLink" destination="feedWaterParameters.do" ><span>2</span><spring:message code="step.feedwaterParameters" /></a></li>
  						</c:otherwise>
  					</c:choose>
  					
  					
					<c:choose>
  						<c:when test="${empty treatmentPlantForm}">
  							<li class="gray"><span>3</span><spring:message code="step.treatmentPlantProcess" /></li>
  						</c:when>
  						<c:when test="${not empty treatmentPlantForm && param.stepId == 3}">
  							<li class="black"><span>3</span><spring:message code="step.treatmentPlantProcess" /></li>
  						</c:when>
  						<c:otherwise>
  							<li class="green"><a style="color:#39A536;" href="#" class="stepLink" destination="treatmentPlantSteps.do" ><span>3</span><spring:message code="step.treatmentPlantProcess" /></a></li>
  						</c:otherwise>
  					</c:choose>
					
					
					<c:choose>
  						<c:when test="${empty additionalInfoForm}">
  							<li class="gray"><span>4</span><spring:message code="step.additionalInfo" /></li>
  						</c:when>
  						<c:when test="${not empty additionalInfoForm && param.stepId == 4}">
  							<li class="black"><span>4</span><spring:message code="step.additionalInfo" /></li>
  						</c:when>
  						<c:otherwise>
  							<li class="green"><a style="color:#39A536;" href="#" class="stepLink" destination="additionalInfo.do" ><span>4</span><spring:message code="step.additionalInfo" /></a></li>
  						</c:otherwise>
  					</c:choose>
					

					<c:choose>
  						<c:when test="${empty adviceForm}">
  							<li class="gray last"><span>5</span><spring:message code="step.advice" /></li>
  						</c:when>
  						<c:when test="${not empty adviceForm && param.stepId == 5}">
  							<li class="black last"><span>5</span><spring:message code="step.advice" /></li>
  						</c:when>
  						<c:otherwise>
  							<li class="green last"><a style="color:#39A536;" href="#" class="stepLink" destination="advice.do" ><span>5</span><spring:message code="step.advice" /></a></li>
  						</c:otherwise>
  					</c:choose>
  					
				</ul>
			</div>		
