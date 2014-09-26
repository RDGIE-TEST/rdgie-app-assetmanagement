<%@ include file="../templates/header.jsp"%>

<!-- Registration form - START -->

<h1>LIST OF Entries</h1>
<c:if test="${!empty entryList}">
	<table id="" class="display datatableDisplay" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Entry ID</th>
				<th>Employee</th>
				<th>Items</th>
				<th>Given Date</th>
				<th>Return Date</th>
				<th>Comments</th>
				<th>Action</th>

			</tr>
		</thead>


		<tfoot>
			<tr>
				<th>Entry ID</th>
				<th>Employee</th>
				<th>Items</th>
				<th>Given Date</th>
				<th>Return Date</th>
				<th>Comments</th>
				<th>Action</th>

			</tr>
		</tfoot>


		<c:forEach items="${entryList}" var="entry">
			<tr>

				<td>${entry.entryId}</td>
				<td>${entry.employee.firstname}  ${entry.employee.lastname}</td>
				<td>
				<c:forEach items="${entry.items}" var="item">
				${item.itemName}<br/>
				</c:forEach>
				</td>
				<td>${entry.givenDate}</td>
				<td>${entry.returnDate}</td>
				<td>
				${entry.comments}
				</td>
				<td><a href="<c:url value='/editEntry/${entry.entryId}' />">Edit</a></td>

			</tr>

		</c:forEach>


	</table>
</c:if>
<%@ include file="../templates/footer.jsp"%>


