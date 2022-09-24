package com.readComics.bpo.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.readComics.bpo.model.Category;
import com.readComics.bpo.repositories.categoryRepository.ICategoryRepository;
import com.readComics.bpo.service.crawlWeb.ICrawService;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	ICrawService crawService;
	
	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Category> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Category> save(Category t) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void removeById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean saveAllCategories(List<Category> categoryList) {
		
		for(Category c : categoryList) {
			categoryRepository.save(c);
		}
		
		return true;
	}

}
