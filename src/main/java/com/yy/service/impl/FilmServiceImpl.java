package com.yy.service.impl;

import java.util.List;

import com.yy.dao.FilmDao;
import com.yy.dao.impl.FilmDaoImpl;
import com.yy.entity.Film;
import com.yy.service.FilmService;
import com.yy.utils.PageBean;

public class FilmServiceImpl implements FilmService{

	FilmDao dao=new FilmDaoImpl();
	
	public List<Film> findAll() {
		
		return dao.findAll();
	}

	public void insertFilm(Film film, int language_id) {
		dao.insertFilm(film, language_id);
		
	}

	public void deleteFilm(int id) {
		dao.deleteFilm(id);
		
	}

	public void updateFilm(Film film, int language_id) {
		dao.updateFilm(film, language_id);
		
	}

	public Film findFilmById(int film_id) {
		return dao.findFilmById(film_id);
	}

	public void setPageBean(PageBean<Film> pageBean, Film film) {
		int totalCount = dao.getFilmCount(film);
		//System.out.println("总记录数："+ totalCount);
		// 赋值给我的PageBean
		pageBean.setCountPage(totalCount);
		//System.out.println("总页数"+pageBean.getTotalPage());
		// 当前页不能大于总页数
		if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
			pageBean.setCurrentPage((pageBean.getTotalPage()));
		}
		// 当前页不能小于1
		if (pageBean.getCurrentPage()< 1) {
			pageBean.setCurrentPage(1);
		}
		//算出开始的条数
		int startIndex = ((pageBean.getCurrentPage()-1)*pageBean.getMaxResult());
	    //System.out.println("startindex:"+startIndex);
		//得到分页的数据
		List<Film> datas = dao.getAllFilm(film, startIndex, pageBean.getMaxResult());
		
		//封装到Pagebean
		pageBean.setDatas(datas);
		
	}
}
