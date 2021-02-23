package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nowe.modelo.Cliente;
import com.nowe.persistencia.AccesoCuentasBancarias;

/**
 * Servlet implementation class SVisualizarSaldo
 */
@WebServlet("/svisualizarsaldo")
public class SVisualizarSaldo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SVisualizarSaldo() {
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
		// Obtener valores
		  double respuesta;
		  String tipoSaldo = request.getParameter("tipoSaldo");
		 
		  Cliente c1 = null;
		  
		  // Llamara a capa de persistencia
		  AccesoCuentasBancarias ac1 = new AccesoCuentasBancarias();
		  if (tipoSaldo.equals("c")) {
			  int idcuenta = Integer.parseInt(request.getParameter("idcuenta"));
		   try {
		    respuesta = ac1.consultaSaldo(idcuenta);
		    System.out.println(respuesta);
		    
		    // enviar usando Request (se borra al hacer otra peticion)
		    request.setAttribute("jspSaldo_rq", respuesta);
		    RequestDispatcher rd = request.getRequestDispatcher("/visualizar_saldo.jsp");
		       rd.forward(request, response);
		       
		   } catch (ClassNotFoundException | SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		  
		// Obtener valores
		  double respuesta1;
		  String tipoSaldo1 = request.getParameter("tipoSaldo");
		 
		  Cliente c2 = null;
		  
		  // Llamara a capa de persistencia
		  AccesoCuentasBancarias ac2 = new AccesoCuentasBancarias();
		  if (tipoSaldo.equals("i")) {
			  int idinversion = Integer.parseInt(request.getParameter("idcuenta"));
		   try {
		    respuesta1= ac2.consultaSaldoCDT(idinversion);
		    System.out.println(respuesta1);
		    
		    // enviar usando Request (se borra al hacer otra peticion)
		    request.setAttribute("jspSaldo_rq", respuesta1);
		    RequestDispatcher rd = request.getRequestDispatcher("/visualizar_saldo.jsp");
		       rd.forward(request, response);
		       
		   } catch (ClassNotFoundException | SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		  
		// Obtener valores
		  double respuesta2 = 0 ;
		  String tipoSaldo2 = request.getParameter("tipoSaldo");
		 
		  Cliente c3 = null;
		  
		  // Llamara a capa de persistencia
		  AccesoCuentasBancarias ac3 = new AccesoCuentasBancarias();
		  if (tipoSaldo.equals("cl")) {
		
			  String nif =request.getParameter("idcuenta");
		   try {
		    respuesta1= ac2.consultaSaldoTotal(nif);
		    System.out.println(respuesta2);
		    
		    // enviar usando Request (se borra al hacer otra peticion)
		    request.setAttribute("jspSaldo_rq", respuesta2);
		    RequestDispatcher rd = request.getRequestDispatcher("/visualizar_saldo.jsp");
		       rd.forward(request, response);
		       
		   } catch (ClassNotFoundException | SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		  
		 }
	}


