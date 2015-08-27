package javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sun.net.httpserver.Filter.Chain;

public class SecondFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("second destory...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("3.Before secondFilter's doFilter...");//3

		// arg0.getRequestDispatcher("/test.jsp").forward(arg0, arg1);

		chain.doFilter(request, response);

		System.out.println("4.After secondFilter's chain.doFilter...");//4

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("second init...");
	}

}
