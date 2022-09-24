package com.readComics.bpo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Admin
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
	
	private String title;
	
	private String url;
	
	public ResponseDTO() {
		
	}
	
	public ResponseDTO(String title, String url) {
		this.title = title;
		this.url = url;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

}
