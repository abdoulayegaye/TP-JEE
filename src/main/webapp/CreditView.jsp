<%@page import="web.CreditModel"%> <!-- Directive JSP -->
<%
	CreditModel model = (CreditModel)request.getAttribute("creditModel"); //Scriptlet JSP
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Crédit Bancaire</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
	</head>
	<body>
		<div class="container mt-5 col-md-6 col-xm-12 col-sm-6 col-md-offset-3">
			<div class="card">
				<div class="card-header center">Simulation de crédit</div>
				<div class="card-body">
					<form action="calculerMensualite.do" method="post">
						<div class="form-group">
							<label class="control-label">Montant : </label>
							<input class="form-control" type="text" name="montant" value="<%= model.getMontant() %>" />
						</div>
						<div class="form-group">
							<label class="control-label">Taux : </label>
							<input class="form-control" type="text" name="taux" value="<%= model.getTaux() %>" />
						</div>
						<div class="form-group">
							<label class="control-label">Durée : </label>
							<input class="form-control" type="text" name="duree" value="<%= model.getDuree() %>" />
						</div>
						<div>
							<button class="btn btn-success" type="submit">Calculer</button>
						</div>
					</form>
					<div class="mt-3 couleur">
						Mensualité = <% out.println(model.getMensualite()); %> <!-- Expression JSP -->
					</div>
				</div>
			</div>
		</div>
			<%-- <form action="calculerMensualite.do" method="post">
				<table>
					<tr>
						<td>Montant : </td>
						<td><input  /></td>
						<td>FCFA</td>
					</tr>
					<tr>
						<td>Taux : </td>
						<td><input type="text" name="taux" value="<%= model.getTaux() %>" /></td>
						<td>%</td>
					</tr>
					<tr>
						<td>Durée : </td>
						<td><input type="text" name="duree" value="<%= model.getDuree() %>" /></td>
						<td>mois</td>
					</tr>
				</table>
				<button type="submit">Calculer</button>
			</form>
		</div>
		<p></p>
		<div>
			Mensualité = <% out.println(model.getMensualite()); %> <!-- Expression JSP -->
		</div> --%>
	</body>
</html>