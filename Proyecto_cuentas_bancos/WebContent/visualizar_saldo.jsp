<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header>
		<table class="icono_portada">
			<tbody>
				<tr>
					<td><img class="icono_portada" src="imagenes/cabecera.JPG"
						align="left"></td>
					<td><img class="icono_portada2" src="imagenes/icono.JPG"
						align="rigth" /></td>
				</tr>
			</tbody>
		</table>
	</header>
	<h1>Consulta de Saldos</h1>
	<form action="svisualizarsaldo" method="post">

		<p>
			<input type="radio" name="tipoSaldo" value="c"> Saldo Cuenta
			<input type="radio" name="tipoSaldo" value="i"> saldo
			inversion <input type="radio" name="tipoSaldo" value="cl">
			saldo cliente
		</p>
		<p>
			Introduzca datos:<input type="text" name="idcuenta" size="40">
		</p>

		<p>
			<input type="submit" value="Consulta saldo">
		</p>
		<p>
			Su saldo es:<input type="text" name="nombre" value="${jspSaldo_rq}"
				size="40">

		</p>


		<input type="reset" value="Borrar">
	</form>

</body>
</html>