<%@ include file="../templates/header.jsp"%>

<!-- Registration form - START -->

	<table id="" class="display datatableDisplay" cellspacing="0" width="100%">
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

				<td>${employee.employeeId}</td>
				<td>${employee.firstname}</td>
				<td>${employee.lastname}</td>
				<td>
				<c:forEach var="identifier" items="${employee.identifiers}">
				<c:if test="${not empty employee.identifiers}">
				${identifier.identifierType.name } : ${identifier.identifierValue } <br/>
				</c:if>
				 </c:forEach>
				 </td>
				<td><a href="<c:url value='/editEmployee/${employee.employeeId}' />">Edit</a></td>

			</tr>

		</c:forEach>


	</table>

<%@ include file="../templates/footer.jsp"%>


