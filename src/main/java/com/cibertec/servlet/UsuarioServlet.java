package com.cibertec.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cibertec.business.UsuarioService;
import com.cibertec.business.impl.UsuarioServiceImpl;
import com.cibertec.constants.Constantes;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch (action) {
		case Constantes.VALIDA: 
			String user = request.getParameter("txtUsuario");
			String clave = request.getParameter("txtClave");
			
			UsuarioService service = new UsuarioServiceImpl();
			boolean existe = service.validaUsuario(user, clave);
			
			if(existe) {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("usuario", user);
				request.getRequestDispatcher("DocenteServlet?action=listar").forward(request, response);
			}else{
				request.setAttribute("error", "Datos de usuario incorrecto");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			break;
		case Constantes.CERRAR: 
			HttpSession sesion = request.getSession();
			sesion.removeAttribute("usuario");
			response.sendRedirect("login.jsp");
			break;	
		default: request.getRequestDispatcher("login.jsp").forward(request, response);
		}
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
		doGet(request, response);
	}

}
