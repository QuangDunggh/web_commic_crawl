package com.readComics.bpo.service;

import java.util.Set;

import org.jsoup.nodes.Document;

import com.readComics.bpo.model.dto.ResponseDTO;

public interface IScraperService {
	
	Set<ResponseDTO> getVehicleByModel(String vehicleModel);
	
	String parseDocumentToHtml(String url);

}
