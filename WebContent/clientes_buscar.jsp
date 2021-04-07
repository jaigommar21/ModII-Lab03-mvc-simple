<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pe.edu.tecsup.app.entities.Cliente"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>

	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

	<div class="container">
	
	<form method="post" action="BuscarClienteServlet">
		Nombres: <input type="text" name="txtNombres"/>
		<input type="submit" value="Buscar"/>
	</form>

	<%--
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) request.getAttribute("resultados");		
		if (clientes != null) {			
			if ( clientes.size() == 0 ) {
				out.println("<ul> NO HAY RESULTADOS</ul>");				
			} else {
				out.println("<ul>");
				for (Cliente x : clientes) 
					out.println("<li>" + x.getNombreCompleto() + "</li>");
				out.println("</ul>");
			}
		} 		
	--%>
	
	</div>
</body>
</html>