<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>gestion des produits</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container col-md-10 col-md-offset-1">
		<div class="panel panel-primary">
			<div class="panel-heading">Recherche des Produits</div>
			<div class="panel-body">
				<div class=" form-groupe">
					<label class="form-groupe">ID :</label> <label>${produit.id}</label>
				</div>
				<div class=" form-groupe">
					<label class="form-groupe">DESIGNATION :</label> <label>${produit.designation}</label>
				</div>
				<div class=" form-groupe">
					<label class="form-groupe">PRIX :</label> <label>${produit.prix}</label>
				</div>
				<div class=" form-groupe">
					<label class="form-groupe">QUANTITE :</label> <label>${produit.quantite}</label>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>