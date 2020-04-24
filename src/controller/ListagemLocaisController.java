package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LocaisReciclagemDAO;
import model.LocaisReciclagem;

@WebServlet("/ListagemLocais.do")
public class ListagemLocaisController extends HttpServlet {
	private static ArrayList<LocaisReciclagem> localLista;
	private LocaisReciclagemDAO dao;

	public static void setLocaisReciclagem(ArrayList<LocaisReciclagem> lista) {
		localLista = lista;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListagemLocaisController() {
		super();
		dao = new LocaisReciclagemDAO(); 
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id_lixo = Integer.parseInt(request.getParameter("tipo"));
		
		List<LocaisReciclagem> localList = dao.carregar(id_lixo);
		
		request.setAttribute("localList", localList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/procurarLocais.jsp");
		dispatcher.forward(request, response);
		
	}
}
