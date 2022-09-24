package com.readComics.bpo.service;

import java.util.List;
import java.util.Optional;

public interface IGenericService <T> {
	
	List<T> findAll();
	
	Optional<T> findById(Long id);
	
	Optional<T> save(T t);
	
	void removeById(Long id);
	

}
