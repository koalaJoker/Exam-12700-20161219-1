package com.yy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.entity.Film;
import com.yy.service.CustomerService;
import com.yy.service.FilmService;
import com.yy.service.impl.CustomerServiceImpl;
import com.yy.service.impl.FilmServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CustomerService customerService=new CustomerServiceImpl();
    FilmService filmService=new FilmServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");
		if("login".equals(method)){
			login(request,response);
		}else if("exit".equals(method)){
			exit(request,response);
		}
		
	}


	

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String username=request.getParameter("name");
		boolean login=customerService.findCustomerByName(username);
		//登陆成功
		if(login){
			request.getSession().setAttribute("username",username);
			//获取列表
			
			try {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//登陆失败
		else{
			request.setAttribute("tip","用户名错误，请重新登陆！");
			try {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
//退出
	private void exit(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("username");
		try {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
