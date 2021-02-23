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
import com.nowe.modelo.Movimiento;
import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SIngresarRetirar
 */
@WebServlet("/singresarretirar")
public class SIngresarRetirar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SIngresarRetirar() {
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

		Movimiento m1 = null;
		// Llamara a capa de persistencia
		AccesoCuentasBancarias ac1 = new AccesoCuentasBancarias();
		if (tipoSaldo.equals("i")) {
			int idcuenta = Integer.parseInt(request.getParameter("idcuenta"));
			double cantidad = Double.parseDouble(request.getParameter("cantidad"));
			try {

				m1 = new Movimiento(cantidad, idcuenta);

				respuesta = ac1.Ingreso(m1);
				System.out.println(respuesta);

				// enviar usando Request (se borra al hacer otra peticion)
				request.setAttribute("jspIR_rq", respuesta);
				RequestDispatcher rd = request.getRequestDispatcher("/ingresar_retirar.jsp");
				rd.forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Obtener valores
		boolean respuesta1 = false;
		String tipoSaldo1 = request.getParameter("tipoSaldo");

		Movimiento m2 = null;
		// Llamara a capa de persistencia
		AccesoCuentasBancarias ac2 = new AccesoCuentasBancarias();
		if (tipoSaldo.equals("r")) {
			int idcuenta = Integer.parseInt(request.getParameter("idcuenta"));
			double cantidad = Double.parseDouble(request.getParameter("cantidad"));
			try {

				m1 = new Movimiento(cantidad, idcuenta);

				respuesta = ac1.retiro(m1);
				System.out.println(respuesta);

				// enviar usando Request (se borra al hacer otra peticion)
				request.setAttribute("jspIR_rq", respuesta);
				RequestDispatcher rd = request.getRequestDispatcher("/ingresar_retirar.jsp");
				rd.forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
