<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Carteira"%>
<%@page import="model.Usuarios"%>
<%@page import="model.ContaBancaria"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Carteira Digital</title>
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
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<a style="color: white" class="navbar-brand" href="index.html">Recicla
			Sampa</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#conteudoNavbarSuportado"
			aria-controls="conteudoNavbarSuportado" aria-expanded="false"
			aria-label="Alterna navega磯">
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
				<li class="nav-item dropdown"><a style="color: white"
					class="nav-link" href="cadastroRelatorio.html">Cadastrar relatório</a></li>
				<li class="nav-item dropdown"><a style="color: white"
					class="nav-link" href="listarRelatorio.jsp">Listar relatórios</a></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Pesquisar" aria-label="Pesquisar">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Pesquisar</button>
			</form>
		</div>
	</nav>
	<br>
	<br>
	<div class="row">
		<div style="background-color: #F0F8FF; border-radius: 15px"
			class="container">
			<%
				Carteira cart = (Carteira) request.getAttribute("cart");
			%>
			<!-- Barra superior com os menus de navegaÃƒÂ§ÃƒÂ£o -->
			<%
				ContaBancaria bank = (ContaBancaria) request.getAttribute("bank");
			%>

			<h3 class="page-header">Carteira Digital</h3>
			<div class="row">
				<h5>Parabéns seu dinheiro foi retirado com sucesso. Após 1 dia
					útil ele já estará na sua conta: <%=bank.getBanco()%></h5>
				<div class="col-md-12">
					<p>
						<strong>Seu saldo atual é de: </strong>
					</p>
					<p>
						R$<%=cart.getSaldo()%>
					</p>
				</div>
			</div>
			<div id="actions" class="row">
				<div class="col-md-12">
					<a href="Logout.do" class="btn btn-danger">Voltar</a> <br> <br>
				</div>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>