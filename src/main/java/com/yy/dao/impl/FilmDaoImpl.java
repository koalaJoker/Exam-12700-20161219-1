package com.yy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yy.dao.FilmDao;
import com.yy.entity.Film;
import com.yy.utils.JdbcTest;

public class FilmDaoImpl implements FilmDao{

	public List<Film> findAll() {
		Connection  conn=JdbcTest.getConnection();
		ResultSet resultSet=null;
		PreparedStatement ps=null;
		List<Film> list=new ArrayList<Film>();
	
		try {
		String sql="select f.film_id,f.title,f.description,l.name from film f,language l where l.language_id=f.language_id";
		    ps= conn.prepareStatement(sql);
			//向数据库发出sql执行查询，查询出结果集
		    resultSet =  ps.executeQuery();
		    while(resultSet.next()){
		       	Film film=new Film();
		    	film.setFilm_id(resultSet.getInt("film_id"));
		    	film.setTitle(resultSet.getString("title"));
		    	film.setDescription(resultSet.getString("description"));
		    	film.setLanguage_name(resultSet.getString("name"));
		    	list.add(film);
		    	}
		    }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTest.close(ps, conn, resultSet);
		}

		return list;
	}

	public void insertFilm(Film film, int language_id) {
		Connection  conn=JdbcTest.getConnection();
		ResultSet resultSet=null;
		PreparedStatement ps=null;
	
		try {
		String sql="insert into film(title,description,language_id) values(?,?,?)";
		    ps= conn.prepareStatement(sql);
		    ps.setString(1,film.getTitle());
		    ps.setString(2, film.getDescription());
		    ps.setInt(3,language_id);
		     ps.executeUpdate();
		}  
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTest.close(ps, conn, resultSet);
		}

		
	}

	public void deleteFilm(int id) {
		Connection  conn=JdbcTest.getConnection();
		ResultSet resultSet=null;
		PreparedStatement ps=null;
	
		try {
		String sql="delete from film where film_id=?";
		    ps= conn.prepareStatement(sql);		    
		    ps.setInt(1,id);
		     ps.executeUpdate();
		}  
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTest.close(ps, conn, resultSet);
		}
		
	}

	public void updateFilm(Film film,int language_id) {
		Connection  conn=JdbcTest.getConnection();
		ResultSet resultSet=null;
		PreparedStatement ps=null;
	
		try {
		String sql="update film set title=?,description=?,language_id=? where film_id=?";
		    ps= conn.prepareStatement(sql);	
		    ps.setString(1,film.getTitle());
		    ps.setString(2,film.getDescription());
		    ps.setInt(3,language_id );
		    ps.setInt(4,film.getFilm_id());
		    ps.executeUpdate();
		}  
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTest.close(ps, conn, resultSet);
		}
		
		
	}

	public Film findFilmById(int film_id) {
		Connection  conn=JdbcTest.getConnection();
		ResultSet resultSet=null;
		PreparedStatement ps=null;
	    Film film=new Film();
		try {
		String sql="select f.film_id,f.title,f.description,l.name from film f,language l where l.language_id=f.language_id and f.film_id=?";
		    ps= conn.prepareStatement(sql);
			ps.setInt(1, film_id);
		    resultSet =  ps.executeQuery();
		    while(resultSet.next()){
		    	film.setFilm_id(resultSet.getInt("film_id"));
		    	film.setTitle(resultSet.getString("title"));
		    	film.setDescription(resultSet.getString("description"));
		    	film.setLanguage_name(resultSet.getString("name"));
		    	}
		    }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTest.close(ps, conn, resultSet);
		}
  return film;
	}

}
