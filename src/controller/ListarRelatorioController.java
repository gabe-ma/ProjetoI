package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ListarRelatorioController
 */
@WebServlet("/ListarRelatorio.do")
public class ListarRelatorioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static List<Relatorio> relatorioLista;
	private RelatorioDAO dao;

	public static void setLocaisReciclagem(ArrayList<Relatorio> lista) {
		relatorioLista = lista;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarRelatorioController() {
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

		String pBairro = request.getParameter("tipo");
		
		RelatorioDAO dao = new RelatorioDAO();
		Relatorio relatorio = new Relatorio();
		relatorio.setBairro(pBairro);
		
		relatorioLista = dao.carregar(relatorio.getBairro());
		
		request.setAttribute("relatorioLista", relatorioLista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listarRelatorio.jsp");
		dispatcher.forward(request, response);
	}

}
