package com.yy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yy.entity.Film;
import com.yy.service.FilmService;
import com.yy.service.LanguageService;
import com.yy.service.impl.FilmServiceImpl;
import com.yy.service.impl.LanguageServiceImpl;
import com.yy.utils.PageBean;

/**
 * Servlet implementation class FilmServlet
 */
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LanguageService languageService=new LanguageServiceImpl();
    FilmService filmService=new FilmServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String method=request.getParameter("method");
	 if("toAddFilm".equals(method)){
		 toAddFilm(request,response);
	 }else if("addFilm".equals(method)){
		 addFilm(request,response);}
	 else if("deleteFilm".equals(method)){
		deleteFilm(request,response);
		
	}else if("toUpdateFilm".equals(method)){
		toUpdateFilm(request,response);
	}else if("updateFilm".equals(method)){
		updateFilm(request,response);
	}else if("table".equals(method)){
		table(request,response);
	}
	}

//更新
	private void updateFilm(HttpServletRequest request, HttpServletResponse response) {
		
		    int film_id=Integer.parseInt(request.getParameter("id"));
		    //System.out.println(film_id);
		    Film film=new Film();
		    film.setFilm_id(film_id);
			film.setTitle(request.getParameter("title"));
			film.setDescription(request.getParameter("description"));
			film.setLanguage_name(request.getParameter("language_name"));
			
			int id=languageService.findLanguageId(request.getParameter("language_name"));
			filmService.updateFilm(film, id);
			table(request,response);
	}

//删除
	private void deleteFilm(HttpServletRequest request, HttpServletResponse response) {
		int film_id=Integer.parseInt(request.getParameter("id"));
		
		filmService.deleteFilm(film_id);
		table(request,response);
	}
//获取将要更新的信息
	private void toUpdateFilm(HttpServletRequest request, HttpServletResponse response) {
		int film_id=Integer.parseInt(request.getParameter("id"));
		Film film=filmService.findFilmById(film_id);
		//System.out.println(film.getDescription());
		request.setAttribute("film", film);
		List<String> listName=languageService.findLanguageName();
		request.setAttribute("listName", listName);
		try {
			request.getRequestDispatcher("/updateFilm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//增加前获取所有的语言	
	private void toAddFilm(HttpServletRequest request, HttpServletResponse response) {
		//拿到所有的语言
		List<String> list=languageService.findLanguageName();
		request.setAttribute("listName",list);
		try {
			request.getRequestDispatcher("/addFilm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//增加
	private void addFilm(HttpServletRequest request, HttpServletResponse response) {
	     Film film=new Film();
		film.setTitle(request.getParameter("title"));
		film.setDescription(request.getParameter("description"));
		film.setLanguage_name(request.getParameter("language_name"));
		int id=languageService.findLanguageId(request.getParameter("language_name"));
		//System.out.println("语言"+id);
		//新增信息
		filmService.insertFilm(film, id);
		table(request,response);
	}
	//显示列表
	private void table(HttpServletRequest request, HttpServletResponse response) {
		Film film=new Film();
		film.setTitle(request.getParameter("filmName"));
		int current = 1;
		PageBean<Film> pageBean = new PageBean<Film>();
		pageBean.setMaxResult(10);
		if (request.getParameter("current") != null && !"".equals(request.getParameter("current"))) {
			current = Integer.parseInt(request.getParameter("current"));
		}
		pageBean.setCurrentPage(current);
		filmService.setPageBean(pageBean,film);
		System.out.println("yy"+pageBean.getTotalPage());
		System.out.println(pageBean.getCurrentPage());
		request.setAttribute("pageBean", pageBean);
		try {
			request.getRequestDispatcher("/table.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
