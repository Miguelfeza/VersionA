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
					<td><img class="icono_portada2"
						src="imagenes/icono.JPG" align="rigth" /></td>
				</tr>
			</tbody>
		</table>
</header>
<h1>Gestionar una inversion </h1>
<form action="sgestionsaldos" method="post">
<p>
    <input type="radio" name="tipoSaldo" value="cr"> Crear un CDT
    <input type="radio" name="tipoSaldo" value="ce"> Cerrar un CDT
     </p>
     <p>Cuenta:<input type="text" name="idcuenta" size="20"></p>
     <p>Interes:<input type="text" name="interesesMensuales" size="20"></p>
     <p>Monto:<input type="text" name="valorInversion" size="40"></p>
     <p>CDT:<input type="text" name="idinversion" size="20"></p>
     
      <p> <input type="submit" value="Realizar la accion"></p>
		<input type="text" name="nombre" value="${jspcdt_rq}" size="40">
	</form>
</body>
</html>