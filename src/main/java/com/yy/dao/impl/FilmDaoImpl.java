package com.yy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		    Statement statement=conn.createStatement();
		    //使外键失效
			statement.executeQuery("set foreign_key_checks=0");
		    ps.executeUpdate();
		  //让外键生效
		    statement.executeQuery("set foreign_key_checks=1");
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
	
	public List<Film> getAllFilm(Film film, int startIndex, int maxResult) {

		List<Film> list=new ArrayList<Film>();

		StringBuilder sb = new StringBuilder("select * from film,language ");
		// 按名称查询
		if (film.getTitle() != null && !"".equals(film.getTitle())) {
			sb.append(" and title like '%" +film.getTitle()+ "%'");
		}
        sb.append(" and language.language_id=film.language_id");
		sb.append(" limit " + startIndex + "," + maxResult + "");
		// 替换
		String sql = sb.toString().replaceFirst("and", "where");
		System.out.println("sql:"+sql);
		
		Connection  conn=JdbcTest.getConnection();
		ResultSet resultSet=null;
		PreparedStatement ps=null;
		
	
		try {
		    ps= conn.prepareStatement(sql);
		    resultSet =  ps.executeQuery();
		    while(resultSet.next()){
		       	Film f=new Film();
		    	f.setFilm_id(resultSet.getInt("film_id"));
		    	f.setTitle(resultSet.getString("title"));
		    	f.setDescription(resultSet.getString("description"));
		    	f.setLanguage_name(resultSet.getString("name"));
		    	list.add(f);
		    	}
		    }
		 catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			JdbcTest.close(ps, conn, resultSet);
		}
		return list;
	}

	public int getFilmCount(Film film) {
		int totalCount = 0;
		StringBuilder sb = new StringBuilder("select count(*) count from film");

		if (film.getTitle() != null && !"".equals(film.getTitle())) {
			sb.append(" and title like '%" + film.getTitle() + "%'");
		}

		String sql = sb.toString().replaceFirst("and", "where");
		Connection  conn=JdbcTest.getConnection();
		ResultSet resultSet=null;
		PreparedStatement ps=null;
		try {
		
		    ps= conn.prepareStatement(sql);
		    resultSet =  ps.executeQuery();
		    while(resultSet.next()){
		    	totalCount=resultSet.getInt("count");
		    	}
		    }
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcTest.close(ps, conn, resultSet);
		}
		return totalCount;

	}

}
