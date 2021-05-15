package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.VacunaNegocioLocal;

/**
 * Servlet implementation class AgregarVacunas
 */
@WebServlet("/AgregarVacunas")
public class AgregarVacunas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	private VacunaNegocioLocal agregoVacunas;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarVacunas() {
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
		
		agregoVacunas.agregarVacunas();
		
		
		doGet(request, response);
	}

}
