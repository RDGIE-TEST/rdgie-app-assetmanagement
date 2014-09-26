<%@ include file="../templates/header.jsp"%>

<!-- Registration form - START -->



<form:form action="listAllIdentifierType" commandName="identifierType">
	<table id="" class="display datatableDisplay" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Identifier Type IdentifierTypeId</th>
				<th>Identifier Type name</th>
				<th>Edit</th>
				<th>Delete</th>

			</tr>
		</thead>


		<tfoot>
			<tr>
				<th>Identifier Type IdentifierTypeId</th>
				<th>Identifier Type name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</tfoot>


		<c:forEach items="${identifierTypeList}" var="identifierType">
			<tr>

				<td>${identifierType.identifierTypeId}</td>
				<td>${identifierType.name}</td>
				<td><a
					href="<c:url value='/editIdentifierType/${identifierType.identifierTypeId}' />">Edit</a></td>
				<td><a
					href="<c:url value='/removeIdentifierType/${identifierType.identifierTypeId}' />">Delete</a></td>

			</tr>

		</c:forEach>


	</table>
</form:form>


<%@ include file="../templates/footer.jsp"%>


