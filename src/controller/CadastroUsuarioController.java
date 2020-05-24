package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContaBancariaDAO;
import dao.UsuarioDAO;
import model.ContaBancaria;
import model.Usuarios;

/**
 * Servlet implementation class CadastroUsuarioController
 */
@WebServlet("/CadastroUsuario.do")
public class CadastroUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroUsuarioController() {
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
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		int pId = Integer.parseInt(request.getParameter("tipo"));
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuarios usuario = new Usuarios();
		usuario.setNome(pNome);
		usuario.setEmail(pEmail);
		usuario.setSenha(pSenha);
		usuario.setTipoUsuario(pId);
		
		
		
		String pBanco = request.getParameter("banco");
		String pConta = request.getParameter("conta");
		String pAgencia = request.getParameter("agencia");
		
		ContaBancariaDAO Cdao = new ContaBancariaDAO();
		ContaBancaria conta = new ContaBancaria();
		
		conta.setBanco(pBanco);
		conta.setConta(pConta);
		conta.setAgencia(pAgencia);
		
		Cdao.criar(conta);
		
		usuario.setContaBancaria(conta.getIdConta());
		
		dao.criar(usuario);
		
		request.getSession().setAttribute("usuario", usuario);
		
		request.setAttribute("usuario", usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sucecssoLogin.jsp");
		dispatcher.forward(request, response);
	}

}
