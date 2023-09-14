<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceso Usuario</title>
</head>
<body>
	<form action="UsuarioServlet" method="post">
		${error}
		<table>
			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="txtUsuario" /></td>
			</tr>
			<tr>
				<td>Clave:</td>
				<td><input type="password" name="txtClave" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input  type="hidden" name="action" value="valida"/>
					<input  type="submit" value="Ingresar"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>