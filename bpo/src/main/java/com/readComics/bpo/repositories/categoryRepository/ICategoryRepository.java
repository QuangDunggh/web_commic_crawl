package com.readComics.bpo.repositories.categoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.readComics.bpo.model.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long>{

}
