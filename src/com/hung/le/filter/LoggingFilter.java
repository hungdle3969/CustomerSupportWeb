package com.hung.le.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.ThreadContext;
/*
@WebFilter(urlPatterns = "/*", dispatcherTypes = {
        DispatcherType.REQUEST, DispatcherType.ERROR, DispatcherType.FORWARD,
        DispatcherType.INCLUDE, DispatcherType.ASYNC
})
*/
public class LoggingFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		boolean clear = false;
		
		if(!ThreadContext.containsKey("id")){
			clear = true;
			ThreadContext.put("id", UUID.randomUUID().toString());
			HttpSession session = ((HttpServletRequest)request).getSession(false);
			
			if(session != null){
				ThreadContext.put("username", (String)session.getAttribute("username"));
			}
		}
		
		try{
			chain.doFilter(request, response);
		}finally{
			if(clear)
				ThreadContext.clear();
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
