package javaweb.encoding;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.filter.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/encodingFilter")
public class EncodingFilter extends HttpFilter {

	private String encoding;
	
	@Override
	protected void init() {
		
		encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
	}
	
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

   

}
