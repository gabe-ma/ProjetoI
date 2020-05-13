package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarteiraDAO;
import dao.ContaBancariaDAO;
import model.Carteira;
import model.ContaBancaria;
import model.Usuarios;

/**
 * Servlet implementation class RetirarDinheiroController
 */
@WebServlet("/RetirarDinheiro.do")
public class RetirarDinheiroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetirarDinheiroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuarios usuario = (Usuarios) request.getSession().getAttribute("usuario");
		CarteiraDAO dao = new CarteiraDAO();
		Carteira cart = new Carteira();
		
		dao.retirarDinheiro(usuario, cart);
		
		dao.verificarSaldo(usuario, cart);
		
		request.setAttribute("cart", cart);
		
		ContaBancariaDAO Cdao = new ContaBancariaDAO();
		ContaBancaria bank = Cdao.carregar(usuario.getContaBancaria());
		
		request.setAttribute("bank", bank);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/dinheiroRetirado.jsp");
		dispatcher.forward(request, response);
	}

}
