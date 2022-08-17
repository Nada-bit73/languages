<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Languages</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<c:if test="${success != null}">
			<div class="alert alert-success" role="alert">
				<c:out value="${success}" />
			</div>
		</c:if>
	</div>
	<div class="d-flex justify-content-center m-4 container">
		<div class="align-items-center">
			<div class="row ml-5 mt-1 ">
				<div class="span6">
					<h1>Languages</h1>
					<c:if test="${lang != null}">
						<table class="table table-hover mt-4">
							<thead class="thead-dark">
								<tr>
									<th colspan="1">Name</th>
									<th colspan="1">Creator</th>
									<th colspan="1">Version</th>
									<th colspan="2">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="myLanguage" items="${lang}">
									<tr>
										<td colspan="1"><a href="languages/${myLanguage.id}/view">
												<c:out value="${myLanguage.name}" />
										</a></td>
										<td colspan="1"><c:out value="${myLanguage.creator}" /></td>
										<td colspan="1"><c:out
												value="${myLanguage.currentVersion}" /></td>
										<td colspan="1"><a href="languages/${myLanguage.id}/edit">Edit</a></td>
										<td colspan="1">
											<form action="/languages/${myLanguage.id}" method="POST">
												<input type="hidden" name="_method" value="DELETE">
												<input type="submit" value="Delete"
													class="btn btn-link mb-1">
											</form>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					<form:form Class="form align-items-center mt-4"
						modelAttribute="language" action="/languages/create" method="POST">

						<div class="row mb-3">
							<form:label class="form-label" path="name">Name:</form:label>
							<div class="col-12">
								<form:input type="text" path="name" cssClass="form-control"
									cssErrorClass="form-control is-invalid" />
								<form:errors cssClass="invalid-feedback" path="name" />
							</div>
						</div>

						<div class="row mb-3">
							<form:label class="form-label" path="creator">Creator:</form:label>
							<div class="col-12">
								<form:input type="text" path="creator" cssClass="form-control"
									cssErrorClass="form-control is-invalid" />
								<form:errors cssClass="invalid-feedback" path="creator" />
							</div>
						</div>

						<div class="row mb-3">
							<form:label class="form-label" path="currentVersion">Version:</form:label>
							<div class="col-12">
								<form:input type="text" path="currentVersion"
									cssClass="form-control" cssErrorClass="form-control is-invalid" />
								<form:errors cssClass="invalid-feedback" path="currentVersion" />
							</div>
						</div>

						<div class="row mb-3">
							<div class="col-12">
								<button class="btn btn-large btn-dark" type="submit">submit</button>
							</div>
						</div>
					</form:form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>