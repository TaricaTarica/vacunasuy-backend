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

@WebFilter(urlPatterns = {"/admin/*", "/autoridad/*", "/home.xhtml"})
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
			if (currentUser instanceof Administrador && (uri.contains("admin") || uri.endsWith("home.xhtml") || !uri.endsWith("html"))) {
				success = true;
				chain.doFilter(request, response);
			} else {
				if (currentUser instanceof Autoridad && (uri.contains("autoridad") || uri.endsWith("home.xhtml") || !uri.endsWith("html"))) {
					success = true;
					chain.doFilter(request, response);
				}
			}
			 
			if (!success) {
				res.sendRedirect((uri.contains("admin") || uri.contains("gerente")) ? "../noAutorizado.xhtml" : "noAutorizado.xhtml");
			}
		} else {
			res.sendRedirect((uri.contains("admin") || uri.contains("gerente")) ? "../login.xhtml" : "login.xhtml");
		}
		
	}
	
}

