package com.readComics.bpo.repositories.productRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.readComics.bpo.model.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{
	

}
