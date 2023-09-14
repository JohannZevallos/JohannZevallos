package com.cibertec.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cibertec.business.DocenteService;
import com.cibertec.business.impl.DocenteServiceImpl;
import com.cibertec.model.Docente;
import static com.cibertec.constants.Constantes.REGISTRAR;
import static com.cibertec.constants.Constantes.LISTAR;

/**
 * Servlet implementation class DocenteServlet
 */
public class DocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		private DocenteService service = new DocenteServiceImpl();
		
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//para que no habra del local host
		HttpSession sesion = request.getSession();
		if(null == sesion.getAttribute("usuario")) {
			request.setAttribute("error","Debe iniciar sesión...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		String action = request.getParameter("action");
			
			switch (action) {
			case REGISTRAR:
				String nombre = request.getParameter("txtNombre");
				String apellidos = request.getParameter("txtApellidos");
				String dni = request.getParameter("txtDni");
				int estado = Integer.parseInt(request.getParameter("cboEstado"));
				
				Docente  docente = new Docente();
				docente.setNombre(nombre);
				docente.setApellido(apellidos);
				docente.setDni(dni);
				docente.setEstado(estado);
				int valor = service.registrarDocente(docente);
				if(valor == 1) {
					listadoDocentes(request, response);
				}else {
					request.setAttribute("mensajeError", "Ocurrio un error en el proceso de registro");
					request.getRequestDispatcher("listadoDocente.jsp").forward(request, response);
				}
				break;
			case LISTAR: listadoDocentes(request, response); break;
			default: listadoDocentes(request, response);				
			}
		}
	private void listadoDocentes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Docente> lista = service.listarDocentes();
		request.setAttribute("data", lista);
		request.getRequestDispatcher("listadoDocente.jsp").forward(request, response);
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
