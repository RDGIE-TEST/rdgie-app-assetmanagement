<%@ include file="../templates/header.jsp"%>

<!-- Registration form - START -->
<div class="row">
	<form:form action="createEmployee" method="post" commandName="employee"
		role="form">
		<div class="col-lg-6">
			<div class="well well-sm">
				<strong><span class="glyphicon glyphicon-asterisk"></span>Required
					Field</strong>
			</div>
			<div class="form-group">
				<label for="InputFirstName">First Name</label>
				<div class="input-group">
					<form:input path="firstname" type="text" class="form-control"
						name="InputFirstName" id="InputFirstName"
						placeholder="Enter First Name" required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="InputName">Last Name</label>
				<div class="input-group">
					<form:input path="lastname" type="text" class="form-control"
						name="InputLastName" id="InputLastName"
						placeholder="Enter Last Name" required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			
			<div class="form-group">
				<label for="InputEmail">Email</label>
				<div class="input-group">
					<form:input path="email" type="email" class="form-control"
						name="InputEmail" id="InputEmail"
						placeholder="Enter Email" required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
						
			<div class="form-group">
				<label for="InputPhone">Phone</label>
				<div class="input-group">
					<form:input path="phone" type="text" class="form-control"
						id="InputPhone" name="InputPhone" placeholder="Enter Phone"
						required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			
			<!-- Start of identifier -->
				
			
			<div id="identifier">
				<div class="form-group">
					<label for="InputIdentifierType">Identifier Type</label>
					<div class="input-group">
						<form:select path="identifier.identifierType.name" type="text"
							class="form-control" name="InputIdentifierType"
							id="InputIdentifierType" placeholder="" required="required">
							
							<c:if test="${ empty employee.firstname}">
								<option value="">Select Identifier Type</option>
								<c:forEach var="identifierType" items="${identifierTypeList}">
									<option value="${identifierType.name}">${identifierType.name}</option>
								</c:forEach>
							</c:if>

							<c:if test="${! empty employee.firstname}">
								<c:forEach var="identifierType" items="${identifierTypeList}">
									<option value="${identifierType.name}" ${identifierType.name == employee.identifier.identifierType.name ? 'selected' : ''}>${identifierType.name}</option>
								</c:forEach>
							</c:if>
							
						</form:select>
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-asterisk"></span></span>
					</div>
				</div>
				<div class="form-group">
					<label for="InputIdentifierValue">Identifier Value</label>
					<div class="input-group">
						<form:input path="identifier.identifierValue" type="text"
							class="form-control" name="InputIdentifierValue"
							id="InputIdentifierValue" placeholder="Enter Identifier Value"
							required="required" />
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-asterisk"></span></span>
					</div>
				</div>
			</div>
			<!-- End of identifier -->
			
			<c:if test="${!empty employee.firstname}">
				<input type="submit" name="submit" id="submit"
					value="<spring:message text="Edit Employee"/>"
					class="btn btn-info pull-right">
			</c:if>
			<c:if test="${empty employee.firstname}">
				<input type="submit" name="submit" id="submit"
					value="<spring:message text="Add Employee"/>"
					class="btn btn-info pull-right">
			</c:if>
		</div>
	</form:form>
	<div class="col-lg-5 col-md-push-1">
		<div class="col-md-12">
			<div class="alert alert-success">
				<strong><span class="glyphicon glyphicon-ok"></span>
					Success! Message sent.</strong>
			</div>
			<div class="alert alert-danger">
				<span class="glyphicon glyphicon-remove"></span><strong>
					Error! Please check all page inputs.</strong>
			</div>
		</div>
	</div>
</div>
<!-- Registration form - END -->

<%@ include file="../templates/footer.jsp"%>

