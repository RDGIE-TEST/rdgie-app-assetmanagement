<%@ include file="../templates/header.jsp"%>

<!-- Registration form - START -->
<div class="row">
	<form:form action="createItem" method="post" commandName="item"	role="form">
		<div class="col-lg-6">
			<div class="well well-sm">
				<strong><span class="glyphicon glyphicon-asterisk"></span>Required
					Field</strong>
			</div>
			<div class="form-group">
				<label for="InputItemName">Item Name</label>
				<div class="input-group">
					<form:input path="itemName" type="text" class="form-control"
						name="InputItemName" id="InputItemName"
						placeholder="Enter Item Name" required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="InputItemTag">Item Tag Name</label>
				<div class="input-group">
					<form:input path="itemTag" type="text" class="form-control"
						name="InputItemTag" id="InputItemTag"
						placeholder="Enter Item Tag Name" required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>

			<div class="form-group">
				<label for="InputItemCondition">Item Condition</label>
				<div class="input-group">
					<form:select path="itemCondition" class="form-control"
						name="InputItemCondition" id="InputItemCondition" placeholder=""
						required="required">
						<form:option value="NONE" label="--- Select Item Condition ---" />
						<form:options items="${itemConditionList}" />
					</form:select>

					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>

			<div class="form-group">
				<label for="InputItemStatus">Item Status</label>
				<div class="input-group">
					<form:select path="status" class="form-control"
						name="InputItemStatus" id="InputItemStatus" placeholder=""
						required="required">
						<form:option value="NONE" label="--- Select Item Status ---" />
						<form:options items="${itemStatusList}" />
					</form:select>

					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			
			<div class="form-group">
				<label for="InputName">Identifier Type</label>
				<div class="input-group">
					<form:select path="identifier.identifierType.name" type="text"
						class="form-control" name="InputIdentifierType"
						id="InputIdentifierType" placeholder="" required="required">
						<c:if test="${ empty item.itemName}">
							<option value="">Select Identifier Type</option>
							<c:forEach var="identifierType" items="${identifierTypeList}">
								<option value="${identifierType.name}">${identifierType.name}</option>
							</c:forEach>
						</c:if>

						<c:if test="${! empty item.itemName}">
							<c:forEach var="identifierType" items="${identifierTypeList}">
								<option value="${identifierType.name}"
									${identifierType.name == item.identifier.identifierType.name ? 'selected' : ''}>${identifierType.name}</option>
							</c:forEach>
						</c:if>
					</form:select>
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="InputName">Identifier Value</label>
				<div class="input-group">
					<form:input path="identifier.identifierValue" type="text"
						class="form-control" name="InputIdentifierValue"
						id="InputIdentifierValue" placeholder="Enter Identifier Value"
						required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			<c:if test="${!empty item.itemName}">
				<input type="submit" name="submit" id="submit"
					value="<spring:message text="Edit Item"/>"
					class="btn btn-info pull-right">
			</c:if>
			<c:if test="${empty item.itemName}">
				<input type="submit" name="submit" id="submit"
					value="<spring:message text="Add Item"/>"
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
