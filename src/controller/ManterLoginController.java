package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuarios;

/**
 * Servlet implementation class ManterLoginController
 */
@WebServlet("/LoginUsuario.do")
public class ManterLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManterLoginController() {
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
		// TODO Auto-generated method stub
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.login(pEmail, pSenha);
		Usuarios usuario = dao.carregar(pEmail);
		
		request.getSession().setAttribute("usuario", usuario);
		
		request.setAttribute("usuario", usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sucecssoLogin.jsp");
		dispatcher.forward(request, response);
	}

}
