package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LocaisReciclagemDAO;
import model.LocaisReciclagem;

@WebServlet("/ManterLocais.do")
public class ManterLocaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManterLocaisController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LocaisReciclagem localweb = new LocaisReciclagem();
		LocaisReciclagemDAO dao = new LocaisReciclagemDAO();
		
		int id_lixo = Integer.parseInt(request.getParameter("tipo"));

		localweb.setIdLixoReciclado(id_lixo);
		
		dao.carregar(id_lixo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListagemLocais.do");
		dispatcher.forward(request, response);
	}
}
