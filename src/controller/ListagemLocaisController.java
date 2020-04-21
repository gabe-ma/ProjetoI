package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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

	public static void setLocaisReciclagem(ArrayList<LocaisReciclagem> lista) {
		localLista = lista;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListagemLocaisController() {
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

		for (LocaisReciclagem item : localLista) {
			PrintWriter out = response.getWriter();
			out.println("Nome: " + item.getRua());
			out.println("Número: " + item.getNumero());
			out.println("Bairro: " + item.getBairro());
			out.println("Telefone: " + item.getTelefone());
			out.println("Quantidade de lixo: " + item.getQuantLixo());
			out.close();
		}
	}
}
