package com.readComics.bpo.repositories.categoryRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.readComics.bpo.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long>{
	
	boolean existsCategoryByNameCategory(String nameCategory);
	
	Optional<Category> findByNameCategory(String nameCategory);

}
