package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RelatorioDAO;
import model.Relatorio;

/**
 * Servlet implementation class CadastroRelatorioController
 */
@WebServlet("/CadastroRelatorio.do")
public class CadastroRelatorioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroRelatorioController() {
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
		
		String pBairro = request.getParameter("bairro");
		int pQntLixo = Integer.parseInt(request.getParameter("qntLixo"));
		int pMaiorTipoLixo = Integer.parseInt(request.getParameter("tipo"));
		String pDescricao = request.getParameter("descricao");
		
		Relatorio relatorio = new Relatorio();
		RelatorioDAO dao = new RelatorioDAO();
		relatorio.setBairro(pBairro);
		relatorio.setQntLixo(pQntLixo);
		relatorio.setMaiorTipoLixo(pMaiorTipoLixo);
		relatorio.setDescricao(pDescricao);
		
		dao.criar(relatorio);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listarRelatorio.jsp");
		dispatcher.forward(request, response);
	}

}
