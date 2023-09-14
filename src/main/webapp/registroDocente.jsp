<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de Docentes</title>
</head>
<body>

<h3>Registro de Docentes</h3>

<form action = "DocenteServlet" method="post">
	<table border = "1">
		<tr>
			<td>Nombre:</td>
			<td><input type="text" name="txtNombre" /></td>
		</tr>
		<tr>
			<td>Apellidos:</td>
			<td><input type="text" name="txtApellidos" /></td>
		</tr>
		<tr>
			<td>DNI:</td>
			<td><input type="text" name="txtDni" /></td>
		</tr>
		<tr>
			<td>Estado:</td>
			<td><select name="cboEstado">
				<option value="1">Habilitado</option>
				<option value="0">Deshabilitado</option>
			</select></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="hidden" value="registrar" name="action" />
				<input type="submit" value="Registrar Docente"  />
			</td>
		</tr>
		
	</table>
</form>

</body>
</html>