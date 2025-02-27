<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Saisir des produits</title>
</head>
<body>
	<%@include file="navbar.jsp" %>
	<div class="container col-md-10 col-md-offset-1">
    <div class="panel panel-primary">
        <div class="panel-heading">Saisir des produits</div>
        <div class="panel-body">
            <form action="saveProduit.php" method="post"> <!-- Servlet ou Controller en Java -->
                <div class="form-group">
                    <label class="control-label">DESIGNATION</label>
                    <input type="text" name="designation" value="${produit.designation}" class="form-control" required>
                    <span></span>
                </div>
                <div class="form-group">
                    <label class="control-label">PRIX</label>
                    <input type="text" name="prix" class="form-control" value="${produit.prix}" required>
                    <span></span>
                </div>
                <div class="form-group">
                    <label class="control-label">QUANTITE</label>
                    <input type="text" name="quantite" class="form-control" value="${produit.quantite}" required>
                    <span></span>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">SAVE</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>