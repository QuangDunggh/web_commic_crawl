package com.readComics.bpo.service.crawlWeb;

import java.util.List;
import java.util.Optional;

import com.readComics.bpo.model.AuthorComic;
import com.readComics.bpo.model.Category;
import com.readComics.bpo.model.Chapter;
import com.readComics.bpo.model.Product;

public interface ICrawService {
	
	List<Product> getAllProductFormWeb(String url);
	
	Optional<Product> getProductFromWeb(String url);
	
	void getNameComic(String url);
	
	void getAuthorComic(String url);
	
	void getImgComic(String url);
	
	void getCateogryOfComic(String url);
	
	List<Category> getAllCategory(String url);
	
	Optional<Category> getCategoryFromWeb(String url);
	
	List<Chapter> getAllChapterOfProductFromWeb(String url, Product product);
	
	List<AuthorComic> getAllAuthorComicFromWeb(String url);

}
