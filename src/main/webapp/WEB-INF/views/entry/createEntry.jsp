<%@ include file="../templates/header.jsp"%>

<!-- Registration form - START -->

<c:if test="${!empty entry.entryId}">

<div class="row">
	<form:form action="createEntry" method="post" commandName="entry"
		role="form">
		<div class="col-lg-6">
			<div class="well well-sm">
				<strong><span class="glyphicon glyphicon-asterisk"></span>Required
					Field</strong>
			</div>

			<div class="form-group">
				<label for="InputName">Name of Employee</label>
				<div class="input-group">
					<input type="text" class="form-control"
						name="InputEmployeeName" id="InputEmployeeName"
						data-toggle="modal" data-target="#employeeModal"
						placeholder="Enter  Name" required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			
				
			<div class="form-group">
				<label for="InputEntryType">Entry Type</label>
				<div class="input-group">
					<form:select path="entryType" class="form-control"
						name="InputEntryType" id="InputEntryType" placeholder=""
						required="required">
						<c:if test="${ empty entry.entryType}">
						<form:option value="NONE" label="--- Select Entry Type ---" />
						<form:options items="${entryTypeList}" />
						</c:if>
						
						<c:if test="${! empty entry.entryType}">
						<option value="${entry.entryType}"
										${entryType == entry.entryType ? 'selected' : ''}>${entry.entryType}</option>
						<form:options items="${entryTypeList}" />
						
						</c:if>
					</form:select>

					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>

			<div class="form-group">
				<label for="InputItem">Item:</label>
				<div class="input-group">
					<input type="text" class="form-control"
						id="InputItemName" name="InputItemName" data-toggle="modal"
						data-target="#itemModal" placeholder="Enter Item"
						required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			

			
			
			<div class="form-group">
				<label for="InputDateTaken">TAKEN DATE</label>
				<div class="input-group">
					<form:input path="givenDate" type="date" class="form-control datepicker"
						id="" name="InputDateTaken"
						placeholder="Enter Taken Date" required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			
  
			<div class="form-group">
				<label for="InputDateOfReturn">RETURN DATE</label>
				<div class="input-group">
					<form:input path="returnDate" type="date" class="form-control datepicker"
						id="" name="InputDateOfReturn"
						placeholder="Enter Date Of Return" required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
				
		
			
			<div class="form-group">
				<label for="InputComments">Comments</label>
				<div class="input-group">
					<form:textarea path="comments" type="text" class="form-control"
						id="InputComments" name="InputComments"
						placeholder="Enter Comments" rows="7" required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>


			<input type="text" name="employeeListFromPage"
				id="employeeListFromPage" />
				
				<input type="text" name="itemListFromPage"
				id="itemListFromPage" />

			
				<input type="submit" name="submit" id="submit"
					value="<spring:message text="Add Entry"/>"
					class="btn btn-info pull-right">
					
					
					
					<c:if test="${!empty entry.entryId}">
					<input type="submit" name="submit" id="submit"
					value="<spring:message text="Edit Entry"/>"
					class="btn btn-info pull-right">
				 
			</c:if>
			<c:if test="${empty entry.entryId}">
				<input type="submit" name="submit" id="submit"
					value="<spring:message text="Add Entry"/>"
					class="btn btn-info pull-right">
			</c:if>
		

		</div>
	</form:form>
</div></c:if>
<!-- Registration form - END -->


<!-- Employee popup div -->

<div class="modal fade" id="employeeModal" tabindex="-1" role="dialog"
	aria-labelledby="basicModal" aria-hidden="true">
	<div class="modal-dialog-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">X</button>
				<h4 class="modal-title" id="myModalLabel">Select Employees</h4>
			</div>
			<div class="modal-body">
				<table id="" class="display datatableDisplay1" cellspacing="0"
					width="100%">
					<thead>
						<tr>
							<th>EMPLOYEE ID</th>
							<th>FIRST NAME</th>
							<th>LAST NAME</th>
							<th>DEPARTMENT</th>
							<th>EDIT</th>

						</tr>
					</thead>


					<tfoot>
						<tr>
							<th>EMPLOYEE ID</th>
							<th>FIRST NAME</th>
							<th>LAST NAME</th>
							<th>DEPARTMENT</th>
							<th>EDIT</th>

						</tr>
					</tfoot>


					<c:forEach items="${employeeList}" var="employee">
						<tr>

							<td><input type="checkbox" class="employeeValues"
								value="${employee.employeeId}" /></td>
							<td>${employee.employeeId}</td>
							<td>${employee.firstname}</td>
							<td>${employee.lastname}</td>
							<td><c:forEach var="identifier"
									items="${employee.identifiers}">
									<c:if test="${not empty employee.identifiers}">
				                        ${identifier.identifierType.name } : ${identifier.identifierValue } <br />
									</c:if>
								</c:forEach></td>
						</tr>

					</c:forEach>


				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" onclick="getValues('employeeValues','InputEmployeeName','employeeListFromPage',1);"
					class="btn btn-primary" data-dismiss="modal">Save changes</button>
			</div>
		</div>
	</div>
</div>

<!-- Item popup div -->
<div class="modal fade" id="itemModal" tabindex="-1" role="dialog"
	aria-labelledby="basicModal" aria-hidden="true">
	<div class="modal-dialog-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">X</button>
				<h4 class="modal-title" id="myModalLabel">Select Items</h4>
			</div>
			<div class="modal-body">
				<table id="" class="display datatableDisplay2" cellspacing="0"
					width="100%">
					<thead>
						<tr>
							<th>ITEM ID</th>
							<th>ITEM NAME</th>
							<th>ITEM TAG</th>
							<th>STATUS</th>
							<th>CONDITION</th>
							<th>IDENTIFICATION</th>
							<th>EDIT</th>

						</tr>
					</thead>


					<tfoot>
						<tr>
							<th>ITEM ID</th>
							<th>ITEM NAME</th>
							<th>ITEM TAG</th>
							<th>STATUS</th>
							<th>CONDITION</th>
							<th>IDENTIFICATION</th>
							<th>EDIT</th>

						</tr>
					</tfoot>


					<c:forEach items="${itemList}" var="item">
						<tr>
							<td><input type="checkbox" class="itemValues"
								value="${item.itemId}" /></td>
							<td>${item.itemId}</td>
							<td>${item.itemName}</td>
							<td>${item.itemTag}</td>
							<td>${item.status}</td>
							<td>${item.itemCondition}</td>
							<td><c:forEach items="${item.identifiers}" var="identifier">
				${identifier.identifierType.name} : ${identifier.identifierValue}
				</c:forEach></td>


						</tr>

					</c:forEach>


				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" onclick="getValues('itemValues','InputItemName','itemListFromPage',2);"
					class="btn btn-primary" data-dismiss="modal">Save changes</button>
			</div>
		</div>
	</div>
</div>

<%@ include file="../templates/footer.jsp"%>

