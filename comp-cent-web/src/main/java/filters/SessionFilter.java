package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Administrador;
import entidades.Autoridad;
import entidades.Usuario;

@WebFilter(urlPatterns = {"/login.xhtml","/administrador/*", "/autoridad/*", "/home.xhtml"})
public class SessionFilter implements Filter {
	
	private ServletContext ctx;
	
	public void init(FilterConfig conf) throws ServletException {
		this.ctx = conf.getServletContext();
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();

		boolean success = false;
		
		HttpSession session = req.getSession();
		
		Usuario currentUser = (Usuario) session.getAttribute("currentUser");
		
		if (currentUser != null) {
			
			System.out.println(uri.contains("login"));
			System.out.println(uri);
			
			if(uri.contains("login")) {
				System.out.println("entre a login");
				
				if (currentUser instanceof Administrador) {
					System.out.println("Estoy en el if login Administrador");
					res.sendRedirect("/comp-cent-web/administrador/home.xhtml");
				} else {
					if (currentUser instanceof Autoridad) {
						System.out.println("Estoy en el if de login autoridad");
						res.sendRedirect("/comp-cent-web/autoridad/home.xhtml");
					}
					
				}
				
			}
			
			
			
			
			
			if (currentUser instanceof Administrador && (uri.contains("administrador"))) {
				System.out.println("Estoy en el if de Administrador");
				success = true;
				chain.doFilter(request, response);
			} else {
				if (currentUser instanceof Autoridad && (uri.contains("autoridad"))) {
					
					System.out.println("Estoy en el if de Autoridad");
					success = true;
					chain.doFilter(request, response);
				}
			}
			 
			if (!success) {
				res.sendRedirect((uri.contains("administrador") || uri.contains("autoridad")) ? "../noAutorizado.xhtml" : "noAutorizado.xhtml");
			}
		} else {
			if(!uri.contains("login")) {
			System.out.println(uri);
			res.sendRedirect((uri.contains("administrador") || uri.contains("autoridad")) ? "../login.xhtml" : "login.xhtml");
			}else {
				chain.doFilter(request, response);
			}
		}
		
	}
	
}

