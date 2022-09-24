package com.readComics.bpo.controller;

import java.util.Set;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.readComics.bpo.model.dto.ResponseDTO;
import com.readComics.bpo.service.IScraperService;

@RestController
@RequestMapping("/")
public class MyController {
	
	@Autowired
	IScraperService scraperService;
	
	@GetMapping("/")
	public String myHello() {
		return "hello my spring";
	}
	
	@GetMapping("api/call/{pram}")
	public ResponseEntity<?> getVehicleByModel(@PathVariable("pram") String pram) {
		Set<ResponseDTO> response = scraperService.getVehicleByModel(pram);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/showThyemleaf")
	public ModelAndView showThymleaf() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("views/thyemleafEclipse");
		return modelAndView;
	}
	
	@GetMapping("api/callHtml/showDocucment")
	public ResponseEntity<?> innerHtml() {
		String html = scraperService.parseDocumentToHtml("ok");
		
		return new ResponseEntity<> (html, HttpStatus.OK);
	}
}
