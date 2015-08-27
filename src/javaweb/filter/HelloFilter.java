package javaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destory...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("1.Before helloFilter's doFilter...");//1
		
		
		//arg0.getRequestDispatcher("/test.jsp").forward(arg0, arg1);
		
		chain.doFilter(request, response);
		
		System.out.println("2.After HelloFilter's chain.doFilter...");//2
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init...");
	}

}
