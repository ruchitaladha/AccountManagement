<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Management</title>
<style>
.firstName.ng-valid {
	background-color: lightgreen;
}

.firstName.ng-dirty.ng-invalid-required {
	background-color: red;
}

.lastName.ng-valid {
	background-color: lightgreen;
}

.lastName.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}

.accountNo.ng-valid {
	background-color: lightgreen;
}

.accountNo.ng-dirty.ng-invalid-required {
	background-color: red;
}

.institutionName.ng-valid {
	background-color: lightgreen;
}

.institutionName.ng-dirty.ng-invalid-required {
	background-color: red;
}

.type.ng-valid {
	background-color: lightgreen;
}

.type.ng-dirty.ng-invalid-required {
	background-color: red;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body ng-app="myApp" class="ng-cloak">
	<div class="generic-container"
		ng-controller="AccountController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Account Form New</span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.account.id" />

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="firstName">First
								Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.account.firstName"
									id="firstName" class="form-control input-sm"
									placeholder="Enter First Name." />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.firstName.$error.required">This
										is a required field</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="lastName">Last
								Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.account.lastName"
									id="lastName" class="form-control input-sm"
									placeholder="Enter Last Name." />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.lastName.$error.required">This is
										a required field</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="file">Email</label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.account.email" name="email"
									class="email form-control input-sm"
									placeholder="Enter your Email" required />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.email.$error.required">This is a
										required field</span> <span ng-show="myForm.email.$invalid">This
										field is invalid </span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="accountNo">Account
								Number</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.account.accountNo"
									id="accountNo" class="form-control input-sm"
									placeholder="Enter account number." />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.accountNo.$error.required">This
										is a required field</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="institutionName">Institution
								Name</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.account.institutionName"
									id="institutionName" class="form-control input-sm"
									placeholder="Enter Institution Name." />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.institutionName.$error.required">This
										is a required field</span>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="type">Type</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.account.type" id="date"
									class="form-control input-sm" placeholder="Enter type." />
								<div class="has-error" ng-show="myForm.$dirty">
									<span ng-show="myForm.type.$error.required">This is a
										required field</span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="{{!ctrl.account.id ? 'Add' : 'Update'}}"
								class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()"
								class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset
								Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Accounts</span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID.</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Account Number</th>
							<th>Institution Name</th>
							<th>Type</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="acc in ctrl.accounts">
							<td><span ng-bind="acc.id"></span></td>
							<td><span ng-bind="acc.firstName"></span></td>
							<td><span ng-bind="acc.lastName"></span></td>
							<td><span ng-bind="acc.email"></span></td>
							<td><span ng-bind="acc.accountNo"></span></td>
							<td><span ng-bind="acc.institutionName"></span></td>
							<td><span ng-bind="acc.type"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(acc.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(acc.id)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
	<script src="<c:url value='/static/js/service/account_service.js' />"></script>
	<script
		src="<c:url value='/static/js/controller/account_controller.js' />"></script>
</body>
</html>