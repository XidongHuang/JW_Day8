package javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PasswordFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		String intPassword = fConfig.getServletContext().getInitParameter("password");
		String password = request.getParameter("password");
		
		if(!intPassword.equals(password)){
			request.setAttribute("message", "Invalid Password");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		chain.doFilter(request, response);
		
	}

	private FilterConfig fConfig;
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

}
