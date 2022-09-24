package com.readComics.bpo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "chapteres")
public class Chapter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameChapter;
	
	private int numberChapter;
	
	@Transient
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameChapter() {
		return nameChapter;
	}

	public void setNameChapter(String nameChapter) {
		this.nameChapter = nameChapter;
	}

	public int getNumberChapter() {
		return numberChapter;
	}

	public void setNumberChapter(int numberChapter) {
		this.numberChapter = numberChapter;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
