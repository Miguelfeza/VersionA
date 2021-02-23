package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nowe.modelo.CDT;
import com.nowe.modelo.Cliente;
import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SGestionSaldos
 */
@WebServlet("/sgestionsaldos")
public class SGestionSaldos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SGestionSaldos() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener valores
		boolean respuesta = false;
		String tipoSaldo = request.getParameter("tipoSaldo");
		CDT inversion = null;

		// Llamara a capa de persistencia
		AccesoCuentasBancarias ac1 = new AccesoCuentasBancarias();
		if (tipoSaldo.equals("cr")) {
			int idcuenta = Integer.parseInt(request.getParameter("idcuenta"));
			double interesesMensuales = Double.parseDouble(request.getParameter("interesesMensuales"));
			double valorInversion = Double.parseDouble(request.getParameter("valorInversion"));
			try {

				inversion = new CDT(idcuenta, interesesMensuales, valorInversion);

				respuesta = ac1.crearInversion(inversion);
				System.out.println(respuesta);

				// enviar usando Request (se borra al hacer otra peticion)
				request.setAttribute("jspcdt_rq", respuesta);
				RequestDispatcher rd = request.getRequestDispatcher("/gestion_cdt.jsp");
				rd.forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		boolean respuesta1;
		String tipoSaldo1 = request.getParameter("tipoSaldo");

		// Llamara a capa de persistencia
		AccesoCuentasBancarias ac2 = new AccesoCuentasBancarias();
		if (tipoSaldo.equals("ce")) {
			int idinversion = Integer.parseInt(request.getParameter("idinversion"));
			try {
				respuesta1 = ac2.cerrarInversion(idinversion);
				System.out.println(respuesta1);

				// enviar usando Request (se borra al hacer otra peticion)
				request.setAttribute("jspcdt_rq", respuesta1);
				RequestDispatcher rd = request.getRequestDispatcher("/gestion_cdt.jsp");
				rd.forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
