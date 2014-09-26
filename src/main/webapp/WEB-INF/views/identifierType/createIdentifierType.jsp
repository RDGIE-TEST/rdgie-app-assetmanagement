<%@ include file="../templates/header.jsp" %>

<!-- Registration form - START -->
    <div class="row">
        <form:form action="createIdentifierType" method="post" commandName="identifierType" role="form">
            <div class="col-lg-6">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                <div class="form-group">
                    <label for="InputName">Name</label>
                    <div class="input-group">
                        <form:input path="name" type="text" class="form-control" name="InputName" id="Name" placeholder="Enter Identifier Type Name" required="required" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                                
			<c:if test="${!empty identifierType.name}">
				<input type="submit" name="submit" id="submit"
					value="<spring:message text="Edit Identifier Type"/>"
					class="btn btn-info pull-right">
			</c:if>
			<c:if test="${empty identifierType.name}">
				<input type="submit" name="submit" id="submit"
					value="<spring:message text="Add Identifier Type"/>"
					class="btn btn-info pull-right">
			</c:if>
		</div>
        </form:form>
        <div class="col-lg-5 col-md-push-1">
            <div class="col-md-12">
                <div class="alert alert-success">
                    <strong><span class="glyphicon glyphicon-ok"></span> Success! Message sent.</strong>
                </div>
                <div class="alert alert-danger">
                    <span class="glyphicon glyphicon-remove"></span><strong> Error! Please check all page inputs.</strong>
                </div>
            </div>
        </div>
    </div>
<!-- Registration form - END -->

 <%@ include file="../templates/footer.jsp" %>   