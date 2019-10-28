<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Conductor</title>
</head>
<body>
	<h1>Listar conductor</h1>

	<table border="1">
		<tr>
			<td>Id</td>
			<td>Nombre</td>
			<td>apellido</td>
			<td>dni</td>
			<td>nroBrevete</td>
			<td>IdAuto</td>
			<td>Accion</td>
		</tr>
		<c:forEach var="conductor" items="${lista}">
			<tr>
				<td> <c:out value="${ conductor.id}"></c:out> </td>
				<td> <c:out value="${ conductor.nombre}"></c:out> </td>
				<td> <c:out value="${ conductor.apellido}"></c:out></td>
				<td> <c:out value="${ conductor.dni}"></c:out> </td>
				<td><c:out value="${ conductor.nroBrevete}"></c:out> </td>
				<td><c:out value="${ conductor.idAuto}"></c:out> </td>
				<td> 
					<a href="conductor?opcion=editar&id=<c:out value="${ conductor.id}"></c:out>">  Editar  </a> 
					|
					<a href="conductor?opcion=eliminar&id=<c:out value="${ conductor.id}"></c:out>"> Eliminar  </a> 
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>