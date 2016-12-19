package com.yy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String uri = "";//跳转资源
		
		String urlPath = request.getRequestURI();
		
		urlPath = urlPath.substring(urlPath.lastIndexOf("/")+1, urlPath.length());//  login.jsp   LoginServelt
		//System.out.println("login:  "+urlPath);
		//未登录的情况下
		if("login.jsp".equals(urlPath) || "LoginServlet".equals(urlPath)|| "index.jsp".equals(urlPath)){
			//放行
			chain.doFilter(request, response);
		}else{
			
			HttpSession session = request.getSession();//得到session
			
			if(session != null){
				//判断是否登录
				Object object = session.getAttribute("username");
				if(object != null){					
					//System.out.println("已经登陆！");
					chain.doFilter(request, response);
				}else{
					uri = "/login.jsp";
					request.getRequestDispatcher(uri).forward(request, response);
				}
			}else{
				uri = "/login.jsp";
				//转发
				request.getRequestDispatcher(uri).forward(request, response);
			}
		}
		

		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
