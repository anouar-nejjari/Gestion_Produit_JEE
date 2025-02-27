<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>gestion des produits</title>
</head>
<body>
	<%@include file="navbar.jsp" %>
	<div class="container col-md-10 col-md-offset-1">
		<div class="panel panel-primary">
			<div class="panel-heading">Recherche des Produits</div>
			<div class="panel-body">
				<form action="chercher.php" method="get">
					<label>Mot Cle</label> <input type="text" name="moCle"
						value="${model.moCle}">
					<button type="submit" class="btn btn-primary">cherche</button>
				</form>
				<table class="table">
					<tr>
						<th>ID</th>
						<th>DESIGNATION</th>
						<th>PRIX</th>
						<th>QUANTITE</th>
						<th>ACTION 1</th>
						<th>ACTION 2</th>
					</tr>
					<c:forEach items="${model.produits}" var="p">
						<tr>
						<td>${p.id}</td>
						<td>${p.designation}</td>
						<td>${p.prix}</td>
						<td>${p.quantite}</td>
						<td ><a class="btn btn-danger" onclick="return confirm('Etes vous Sure ?')" href="Supprimie.php?id=${p.id}">DELETE</a></td>
						<td ><a class="btn btn-primary" href="Edit.php?id=${p.id}">EDIT</a></td>
					</tr>
					</c:forEach>
				</table><br>
			</div>
		</div>
	</div>
</body>
</html>