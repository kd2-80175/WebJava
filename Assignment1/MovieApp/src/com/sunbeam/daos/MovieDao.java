package com.sunbeam.daos;


import java.util.List;

import com.sunbeam.pojos.Movie;

public interface MovieDao extends AutoCloseable {
	
	public List<Movie> findAll() throws Exception;
	public Movie findById(int id) throws Exception;

}

