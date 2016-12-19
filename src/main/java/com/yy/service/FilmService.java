package com.yy.service;

import java.util.List;

import com.yy.entity.Film;
import com.yy.utils.PageBean;

public interface FilmService {

	   //查询
		public List<Film> findAll(); 
		//添加数据
		public void insertFilm(Film film,int language_id);
		//删除一条数据
		public void deleteFilm(int id);
		//更新一条记录
		public void updateFilm(Film film,int language_id);
		//通过id查询一条记录
		public Film findFilmById(int film_id);
		
		public void setPageBean(PageBean<Film> pageBean, Film film) ;
}
