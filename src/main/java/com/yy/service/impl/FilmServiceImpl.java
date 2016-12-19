package com.yy.service.impl;

import java.util.List;

import com.yy.dao.FilmDao;
import com.yy.dao.impl.FilmDaoImpl;
import com.yy.entity.Film;
import com.yy.service.FilmService;

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

}
