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

		System.out.println("Dentro de ClientesBuscarServlet: " + criterio);

		ArrayList<Cliente> clientes = obtenerDatos(); //
		ArrayList<Cliente> resultados = new ArrayList<Cliente>();

		for (Cliente cliente : clientes)
			if (cliente.getNombres().equals(criterio)) {
				resultados.add(cliente);
				System.out.println("Encontrado --> " + criterio);
			}

		// Guardando datos en el scope REQUEST
		request.setAttribute("resultados", resultados);
		
		RequestDispatcher rd = request.getRequestDispatcher("clientes_buscar.jsp");
		rd.forward(request, response);
	}

	/**
	 * 
	 * @return
	 */
	private ArrayList<Cliente> obtenerDatos() {
		Cliente c1 = new Cliente(11,"David","Rodriguez","Condezo");
		Cliente c2 = new Cliente(12,"Juan","Perez","Quispe");

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(c1);
		clientes.add(c2);
		return clientes;
	}

}
