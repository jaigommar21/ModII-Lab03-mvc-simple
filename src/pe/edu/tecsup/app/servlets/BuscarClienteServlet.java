package pe.edu.tecsup.app.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.tecsup.app.entities.Cliente;

/**
 * Servlet implementation class BuscarClienteServlet
 */
@WebServlet("/BuscarClienteServlet")
public class BuscarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String criterio = request.getParameter("txtNombres");
		
		//String apellido = request.getParameter("txtApellido");

		System.out.println("Dentro de ClientesBuscarServlet: " + criterio);

		
		ArrayList<Cliente> clientes = obtenerDatos(); // Datos de la BBDD
		
		
		ArrayList<Cliente> resultados = new ArrayList<Cliente>();

		
		for (Cliente cliente : clientes) { 
			
			System.out.println(cliente);
			
			if (cliente.getNombres().equals(criterio)) {
				resultados.add(cliente);
				System.out.println("Encontrado --> " + criterio);
			}
			
		}
		

		System.out.println("Reg. encontrados : " + resultados.size());
		
		// Guardando datos en el scope REQUEST
		request.setAttribute("data", resultados);
		
		//
		request.setAttribute("mensaje", "Espero este bien....!");
		
		// Redireccion al JSP
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * 
	 * @return
	 */
	private ArrayList<Cliente> obtenerDatos() {
		Cliente c1 = new Cliente(11,"David","Rodriguez","Condezo");
		Cliente c2 = new Cliente(12,"Juan","Perez","Quispe");
		Cliente c3 = new Cliente(13,"David","Gomez","Montero");

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		return clientes;
	}

}
