<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Docentes</title>
</head>
<body>
	<h1>Bienvenido Docente: <c:out value="${usuario}"></c:out></h1>
	<br>
	<h3>Listado de Docentes Habilitados</h3>
	
	<p>
		<a href="registroDocente.jsp">Nuevo Docente</a>
		<a href="UsuarioServlet?action=cerrar">Cerrar Sesion</a>
	</p>
	
	<table border ="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>DNI</th>
				<th>Estado</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${data}" var="item">
				<tr>
					<td><c:out value ="${item.id}"></c:out></td>
					<td><c:out value ="${item.nombre}"></c:out></td>
					<td><c:out value ="${item.apellido}"></c:out></td>
					<td><c:out value ="${item.dni}"></c:out></td>
					
					<c:choose>
						<c:when test="${item.estado eq 1}">
							<td>Habilitado</td>
						</c:when>
						<c:otherwise>
							<td>Inhabilitado</td>
						</c:otherwise>
					</c:choose>
					
					<td>
						<a href="DocenteServlet?action=detalle&id=${item.id}">Actualizar</a> 
		      			<a href="DocenteServlet?action=eliminar&id=${item.id}">Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
	
</body>
</html>