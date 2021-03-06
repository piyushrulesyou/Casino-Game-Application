<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<title>Admin HomePage</title>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 	background="https://images.fineartamerica.com/images/artworkimages/mediumlarge/2/collection-of-las-vegas-casino-chips-1-aloha-art.jpg"> -->


	<c:if test="${successMessage != null}">
		<div class="alert alert-success">
			<strong>Success!</strong> Customer with ID ${successMessage}
			Registered Successfully!!
		</div>
	</c:if>



	<jsp:include page="WEB-INF/NavigationBar.jsp"></jsp:include>



</body>
</html>