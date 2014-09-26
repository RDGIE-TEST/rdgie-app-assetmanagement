<%@ include file="../templates/header.jsp"%>

<!-- Registration form - START -->

<h1>LIST OF ITEMS</h1>

	<table id="" class="display datatableDisplay" cellspacing="0" width="100%">
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

				<td>${item.itemId}</td>
				<td>${item.itemName}</td>
				<td>${item.itemTag}</td>
				<td>${item.status}</td>
				<td>${item.itemCondition}</td>
				<td>
				<c:forEach items="${item.identifiers}" var="identifier">
				${identifier.identifierType.name} : ${identifier.identifierValue}
				</c:forEach>
				</td>
				<td><a href="<c:url value='/editItem/${item.itemId}' />">Edit</a></td>

			</tr>

		</c:forEach>


	</table>

<%@ include file="../templates/footer.jsp"%>


