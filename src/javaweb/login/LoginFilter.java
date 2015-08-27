package javaweb.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.filter.HttpFilter;

public class LoginFilter extends HttpFilter{
	private String sessionKey;
	private String redirectUrl;
	private String uncheckedUrls;
	
	@Override
	protected void init() {

		ServletContext servletContext = getFilterConfig().getServletContext();
		
		sessionKey = servletContext.getInitParameter("userSessionKey");
		System.out.println(sessionKey);
		redirectUrl = servletContext.getInitParameter("redirectPage");
		System.out.println(redirectUrl);
		uncheckedUrls = servletContext.getInitParameter("uncheckdUrls");
		System.out.println(uncheckedUrls);
		
		
		
		
		
	}
	
	
	//Gain sessionKey, redirectUrl, uncheckedUrls from web.xml
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		
		//1. Gain request's url
		//http://localhost:8080/JW_Day38/login/list.jsp
		String requestUrl = request.getRequestURL().toString();
		///JW_Day38/login/list.jsp
		String requsetUri = request.getRequestURI().toString();
		///login/list.jsp
		String servletPath = request.getServletPath();
		
		
//		System.out.println(requestUrl);
//		System.out.println(requsetUri);
//		System.out.println(servletPath);
		
		//2. check servletPath from 1 is it in uncheck list, if yes, chain.doFilter
		List<String> urls = Arrays.asList(uncheckedUrls.split(","));
		if(urls.contains(servletPath)){
			chain.doFilter(request, response);
			return;
			
		}
		
		//3. Gain sessionKey's values, if it does not exist, then redirect to redirectUrl
		Object user = request.getSession().getAttribute(sessionKey);
		if(user == null){
			response.sendRedirect(request.getContextPath()+redirectUrl);
			return;
		}
		
		
		//4. If it exists,
		chain.doFilter(request, response);
		
	}

}
