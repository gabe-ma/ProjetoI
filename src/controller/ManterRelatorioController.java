package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LocaisReciclagemDAO;
import dao.RelatorioDAO;
import model.LocaisReciclagem;
import model.Relatorio;

/**
 * Servlet implementation class ManterRelatorioController
 */
@WebServlet("/ManterRelatorio.do")
public class ManterRelatorioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterRelatorioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Relatorio relatorio = new Relatorio();
		RelatorioDAO dao = new RelatorioDAO();
		
		String pBairro = request.getParameter("tipo");

		relatorio.setBairro(pBairro);
		
		dao.carregar(pBairro);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarRelatorio.do");
		dispatcher.forward(request, response);
	}

}
