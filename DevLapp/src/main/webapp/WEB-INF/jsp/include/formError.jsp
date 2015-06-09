<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

				<form:errors path="*">
					<spring:bind path="*">
						<div class="warning_block" id="errors">
							<strong>Oeps, er is iets niet goed gegaan!</strong>
							<div>
								<p>Tot onze spijt kon het formulier niet worden verwerkt. Corrigeer het volgende en probeer opnieuw:</p>
								<ul>
									<c:forEach items="${status.errorMessages}" var="error">
										<li>&bull; ${error}</li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</spring:bind>
				</form:errors>
