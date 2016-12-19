package com.yy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String charEncoding =null;
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println("进入编码过滤器");
		if(!charEncoding.equals(request.getCharacterEncoding())){
			request.setCharacterEncoding(charEncoding);
			
		}
		response.setCharacterEncoding(charEncoding);
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}
	public void init(FilterConfig arg0) throws ServletException {
		charEncoding=arg0.getInitParameter("encoding");
		if(charEncoding==null){
			throw new ServletException("编码设置为空");
			
		}
		
	}

	
	}

	


