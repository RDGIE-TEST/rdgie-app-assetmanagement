<%@ include file="../templates/header.jsp"%>

<!-- Registration form - START -->
<div class="row">
	<th><i>USER REGISTRATION </i></th>
	<form:form action="createUser" method="post"
		commandName="user" role="form">
		<div class="col-lg-6">
			<div class="well well-sm">
				<strong><span class="glyphicon glyphicon-asterisk"></span>Required
					Field</strong>
			</div>
			<div class="form-group">
				<label for="InputName">First Name</label>
				<div class="input-group">
					<form:input path="firstname" type="text" class="form-control"
						name="firstname" id="InputFirstName"
						placeholder="Enter First Name" required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>

			<div class="form-group">
				<label for="InputName">Last Name</label>
				<div class="input-group">
					<form:input path="lastname" type="text" class="form-control"
						name="lastname" id="lastname" placeholder="Enter Last Name"
						required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>

			<div class="form-group">
				<label for="InputEmail">Email</label>
				<div class="input-group">
					<form:input path="email" type="email" class="form-control"
						id="email" name="email" placeholder="Enter Email"
						required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>
			<div class="form-group">
				<label for="InputEmail">UserName</label>
				<div class="input-group">
					<form:input path="username" type="username" class="form-control"
						id="InputPhone" name="username" placeholder="Enter Your Username"
						required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>


			<div class="form-group">
				<label for="InputEmail">Password</label>
				<div class="input-group">
					<form:input path="password" type="password" class="form-control"
						id="InputPhone" name="password" placeholder="Enter Your Password"
						required="required" />
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-asterisk"></span></span>
				</div>
			</div>



			<input type="submit" name="submit" id="submit" value="save"
				class="btn btn-info pull-right" />




		</div>
	</form:form>

</div>
<!-- Registration form - END -->

<%@ include file="../templates/footer.jsp"%>

