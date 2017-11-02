<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="./resources/core/css/bootstrap.min.css" />
<script type="text/javascript" src="./resources/core/js/jquery-3.2.1.js"></script>
<title>Document</title>
</head>

<body>
	<div class="jumbotron text-center">
		<h1>ID:${content.id}</h1>
	</div>

	<div class="container">
		<div class="row">
					<h2 class=text-left>Title</h2>
					<p>${content.title}</p>
		</div>
		<div class="row">
					<h2 class=text-left>Description</h2>
					<p>${content.body}</p>
		</div>
		<div class="row">
					<h2 class=text-left>Recommendations</h2>
					<p>People who viewed this have also viewed:</p>
					<c:forEach items="${content.recommendations}" var="value">
						<p>${value}</p>
					</c:forEach>
		</div>
	</div>
</body>
</html>