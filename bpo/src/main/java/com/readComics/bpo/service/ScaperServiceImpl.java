package com.readComics.bpo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.catalina.connector.Response;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.readComics.bpo.model.dto.ResponseDTO;
@Service
public class ScaperServiceImpl implements IScraperService {

	private List<String> listUrl;

	private List<String> getUrl() {
		listUrl = new ArrayList();

		listUrl.add("https://ikman.lk/en/ads/sri-lanka/vehicles?sort=relevance&buy_now=0&urgent=0&query=");

		listUrl.add("https://riyasewana.com/search/");

		return listUrl;
	}

	@Override
	public Set<ResponseDTO> getVehicleByModel(String vehicleModel) {
		Set<ResponseDTO> setResponseDTOs = new HashSet<>();

		for (String url : getUrl()) {
			if (url.contains("ikman")) {
				System.out.println("url: " + url);
				extractDataFromIkman(setResponseDTOs, url + vehicleModel);

			} else {
				extractDataFromRiyasewana(setResponseDTOs, url);
			}
		}

		return setResponseDTOs;
	}

	private void extractDataFromIkman(Set<ResponseDTO> responseDTOs, String url) {
		try {
			Document document = Jsoup.connect(url).get();
			
			Element element = document.getElementsByClass("list--3NxGO").first();
			
			Elements elements = element.getElementsByTag("a");

			for (Element e : elements) {
				ResponseDTO responseDTO = new ResponseDTO();
				if (StringUtils.isNotEmpty(e.attr("href"))) {

					responseDTO.setTitle(e.attr("title"));
					responseDTO.setUrl(e.attr("https://ikman.lk" + e.attr("href")));
				}

				if (responseDTO.getUrl() != null) {
					responseDTOs.add(responseDTO);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void extractDataFromRiyasewana(Set<ResponseDTO> responseDTOS, String url) {

		try {
			// loading the HTML to a Document Object
			Document document = Jsoup.connect(url).get();
			// Selecting the element which contains the ad list
			Element element = document.getElementById("content");
			
		
			Elements elements = element.getElementsByTag("a");
			// traversing through the elements
			for (Element ads : elements) {
				ResponseDTO responseDTO = new ResponseDTO();

				if (!StringUtils.isEmpty(ads.attr("title"))) {
					// mapping data to the model class
					responseDTO.setTitle(ads.attr("title"));
					responseDTO.setUrl(ads.attr("href"));
				}
				if (responseDTO.getUrl() != null)
					responseDTOS.add(responseDTO);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public String parseDocumentToHtml(String url) {
		try {
			Document document = Jsoup.connect("https://ikman.lk/en/ads/sri-lanka/vehicles?sort=relevance&buy_now=0&urgent=0&query=").get();
			
			String html = document.html();
			
			return html;
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
			return null;
		}
		
		
		
		
		
	}

}
