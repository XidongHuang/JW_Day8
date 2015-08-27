package javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UserNameFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String username = fConfig.getInitParameter("name");
		
		if(!username.equals(request.getParameter("username"))){
			request.setAttribute("message", "Invalid User Name");
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
