package com.readComics.bpo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.readComics.bpo.model.Category;
import com.readComics.bpo.model.ResponseObject;
import com.readComics.bpo.service.category.ICategoryService;
import com.readComics.bpo.service.crawlWeb.ICrawService;

@RestController
@RequestMapping("/api/category")
public class RestCategoryController {

	@Autowired
	ICategoryService categoryService;

	@Autowired
	ICrawService crawService;

	@GetMapping("/getAllCategory")
	public ResponseEntity<ResponseObject> findAllCategory() {

		List<Category> listCategory = new ArrayList<>();

		if (listCategory.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
					new ResponseObject("Loi khong co du lieu", "Không có loại nào trong database", "")
			);
		}

		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("OK", "Thành công", listCategory)
		);
	}

	@GetMapping("/saveCategoryFromWeb")
	public ResponseEntity<ResponseObject> saveCategoryFromWeb() {

		try {
			List<Category> listCategory = crawService.getAllCategory("https://dtruyen.com/truyen-dich/");

			categoryService.saveAllCategories(listCategory);

			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new ResponseObject("Ok", "Add categories successful", listCategory));
		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseObject("Không thành công", "Lỗi phía server không thể thêm category", ""));
		}

	}

}
