<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="./resources/core/css/bootstrap.min.css" />
<script type="text/javascript" src="./resources/core/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="./resources/core/js/tether.min.js"></script>
<script type="text/javascript" src="./resources/core/js/bootstrap.min.js"></script>
<title>Solr Search</title>
</head>

<body>
	<div class="jumbotron text-center">
		<h1>${message}</h1>
	</div>

	<div class="container">
		<h2>Submit your query</h2>
		<form:form action="search" method="GET" class="form-inline">
			<div class="form-group">
				<label>Search</label> 
				<input type="text" class="form-control" placeholder="Enter the query" name="searchTerm">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<c:if test="${not empty lists}">
					<h3 class=text-center>Simple Search</h3>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>NAME</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${lists}" var="value">
							<tr data-toggle="popover" data-placement="bottom" data-trigger="hover" title="Description" data-content="${value.features}">
									<td><a href="<c:url value="/view/${value.id}"/>">${value.id}</a></td>
									<td>${value.name}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
			<div class="col-sm-6">
				<c:if test="${not empty cognitiveLists}">
					<h3 class = text-center>Cognitive Search</h3>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>NAME</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cognitiveLists}" var="value">
								<tr data-toggle="popover" data-placement="bottom" data-trigger="hover" title="Description" data-content="${value.features}">
									<td><a href="<c:url value="/view/${value.id}"/>">${value.id}</a></td>
									<td>${value.name}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</div>
<script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover();   
});
</script>
</body>
</html>