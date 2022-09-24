package com.readComics.bpo.service.category;

import java.util.List;

import com.readComics.bpo.model.Category;
import com.readComics.bpo.service.IGenericService;

public interface ICategoryService extends IGenericService<Category>{
	
	boolean saveAllCategories(List<Category> categoryList);

}
