<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Conductor</title>
</head>
<body>
<h1>Conductor</h1>
<form action="conductor" method="post">
<c:set var="conductor" value="${conductor}"> </c:set>
	<input type="hidden" name="opcion" value="editar">
	<input type="hidden" name="id" value="${conductor.id}">
		<table border="1">
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id" size="50" value="${conductor.id}" disabled="disabled"></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50" value="${conductor.nombre}"></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="apellido" size="50" value="${conductor.apellido}"></td>
			</tr>

			<tr>
				<td>DNI:</td>
				<td><input type="text" name="dni" size="50" value="${conductor.dni}"></td>
			</tr>
			<tr>
				<td>nroLicencia:</td>
				<td><input type="text" name="nroLicencia" size="50" value="${conductor.nroLicencia}"></td>
			</tr>
		</table>
		<input type="submit" value="Guardar">
	</form>
</body>
</html>