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
	<h1>Ingresar/Retirar</h1>
	<form action="singresarretirar" method="post">
		<p>
			<input type="radio" name="tipoSaldo" value="i"> Ingresar <input
				type="radio" name="tipoSaldo" value="r"> Retirar
		</p>
		<p>
			Cuenta:<input type="text" name="idcuenta" size="20">
		</p>
		<p>
			Cantidad:<input type="text" name="cantidad" size="20">
		</p>

		<p>
			<input type="submit" value="Realizar la accion">
		</p>
		<input type="text" name="nombre" value="${jspIR_rq}" size="40">





	</form>
</body>
</html>