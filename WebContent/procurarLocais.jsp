<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Procurar locais de reciclagem</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link href="assets/css/index.css" rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500">
<style>
.locationField, #controls {
	position: relative;
	width: 480px;
}

.autocomplete {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 99%;
}

.label {
	text-align: right;
	font-weight: bold;
	width: 100px;
	color: #303030;
	font-family: "Roboto";
}

.field {
	width: 99%;
}

#locationField {
	height: 20px;
	margin-bottom: 2px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<a style="color: white" class="navbar-brand" href="index.html">Recicla
			Sampa</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#conteudoNavbarSuportado"
			aria-controls="conteudoNavbarSuportado" aria-expanded="false"
			aria-label="Alterna navegação">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item dropdown"><a style="color: white"
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Para Sua Empresa </a>
					<div style="background-color: dimgray" class="dropdown-menu"
						aria-labelledby="navbarDropdown">
						<a style="color: white" class="dropdown-item" href="empresa.html">Mapa
							de Coleta</a> <a style="color: white" class="dropdown-item"
							href="procurarLocais.jsp">Materiais Recicláveis</a>
						<div class="dropdown-divider"></div>
						<a style="color: white" class="dropdown-item" href="#">Algo
							mais aqui</a>
					</div></li>
				<li class="nav-item dropdown"><a style="color: white"
					class="nav-link" href="cliente.html">Recicle Seu Lixo
						Domiciliar</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Pesquisar" aria-label="Pesquisar">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
			</form>
		</div>
	</nav>
	<br>
	<div class="row">
		<div class="container">
			<form action="<%=request.getContextPath()%>/ManterLocais.do"
				method=post>
				<div class="form-group">
					<label
						for="tipo">Escolha um tipo de lixo:</label> <select name="tipo" id="tipo">
						<option value="1">Plástico</option>
						<option value="2">Vidro</option>
						<option value="3">Alumínio</option>
						<option value="4">Papel ou Papelão</option>
						<option value="5">Metal</option>
						<option value="6">Baterias</option>
						<option value="7">Orgânico</option>
					</select>
					<button class="btn btn-outline-success my-2 my-sm-0" name="locais"
						type="submit">Pesquisar ID do Lixo</button>
				</div>
			</form>

			<table style="background-color: white;" class="table table-striped">
				<tr style="background-color: #F0F8FF;">
					<th><h3>Rua</h3></th>
					<th><h3>Nº</h3></th>
					<th><h3>Bairro</h3></th>
					<th><h3>Telefone</h3></th>
					<th><h3>Quant Lixo</h3></th>
				</tr>
				<jstl:forEach var="local" items="${localList}">
					<tr>
						<td>${local.rua}</td>
						<td>${local.numero}</td>
						<td>${local.bairro}</td>
						<td>${local.telefone}</td>
						<td>${local.quantLixo}</td>
					</tr>
				</jstl:forEach>
			</table>
		</div>
	</div>
	<%-- <%= for () %>> --%>
</body>
</html>