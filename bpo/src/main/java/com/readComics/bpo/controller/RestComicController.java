package com.readComics.bpo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.readComics.bpo.model.Product;
import com.readComics.bpo.model.ResponseObject;
import com.readComics.bpo.service.crawlWeb.ICrawService;

@RestController
@RequestMapping("/api/comic/")
public class RestComicController {

	@Autowired
	private ICrawService crawlService;

	@GetMapping("/saveComicFromWeb")
	public ResponseEntity<ResponseObject> getComicFromWeb() {

		try {
			Map<String, String> comicsMap = crawlService.getInforComic("https://dtruyen.com/truyen-dich/");

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObject("Thành công", "Thêm truyện thành công", comicsMap));

		} catch (Exception e) {
			e.printStackTrace();

			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseObject("Thất bại", "Không thể thêm truyện thành công", e.getMessage()));
		}

	}

	@GetMapping("/saveDetailComicFromWeb")
	public ResponseEntity<ResponseObject> saveDetailComicFromWeb() {

		try {
			List<Product> comicList = crawlService.getDetailComic();

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObject("Thành công", "Thêm chi tiết comic thành công", comicList));
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseObject("Không thêm thành công","Sai cái gì đó", e.getMessage()));
		}
	}

}
