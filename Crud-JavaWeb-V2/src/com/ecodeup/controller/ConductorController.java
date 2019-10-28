package com.ecodeup.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeup.dao.ConductorDAO;
import com.ecodeup.model.Conductor;

/**
 * Servlet implementation class ConductorController
 */
@WebServlet(description = "administra peticiones para la tabla conductores", urlPatterns = { "/conductor" })
public class ConductorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConductorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String opcion = request.getParameter("opcion");

		if (opcion.equals("crear")) {
			System.out.println("Usted a presionado la opcion crear");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
			requestDispatcher.forward(request, response);
		} else if (opcion.equals("listar")) {

			ConductorDAO conductorDAO = new ConductorDAO();
			List<Conductor> lista = new ArrayList<>();
			try {
				lista = conductorDAO.obtenerConductor();
				for (Conductor conductor : lista) {
					System.out.println(conductor);
				}

				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Usted a presionado la opcion listar");
		} else if (opcion.equals("editar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("Editar id: " + id);
			ConductorDAO conductorDAO= new ConductorDAO();
			Conductor c = new Conductor();
			try {
				c = conductorDAO.obtenerConductor(id);
				System.out.println(c);
				request.setAttribute("conductor", c);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if (opcion.equals("eliminar")) {
			ConductorDAO conductorDAO = new ConductorDAO();
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				conductorDAO.eliminar(id);
				System.out.println("Registro eliminado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		

		if (opcion.equals("guardar")) {
			ConductorDAO conductorDAO = new ConductorDAO();
			Conductor conductor = new Conductor();
			
			conductor.setNombre(request.getParameter("nombre"));
			conductor.setapellido(request.getParameter("apellido"));
			conductor.setdni(request.getParameter("dni"));
			conductor.setnroLicencia(request.getParameter("nroLicencia"));
			try {
				conductorDAO.guardar(conductor);
				System.out.println("Registro guardado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (opcion.equals("editar")) {
			Conductor conductor = new Conductor();
			ConductorDAO conductorDAO = new ConductorDAO();

			conductor.setId(Integer.parseInt(request.getParameter("id")));
			conductor.setapellido(request.getParameter("apellido"));
			conductor.setNombre(request.getParameter("nombre"));
			conductor.setdni(request.getParameter("dni"));
			conductor.setnroLicencia(request.getParameter("nroLicencia"));
			
			try {
				conductorDAO.editar(conductor);
				System.out.println("Registro editado satisfactoriamente...");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 

		// doGet(request, response);
	}

}
