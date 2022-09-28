package com.readComics.bpo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "authories")
public class AuthorComic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameAuthor;
	
	public AuthorComic() {
		
	}
	
	public AuthorComic(Long id, String nameAuthor) {
		this.id = id;
		this.nameAuthor = nameAuthor;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setNameAuthor(String authorName) {
		this.nameAuthor = authorName;
	}
	
	public String getNameAuthor() {
		return this.nameAuthor;
	}

}
