package com.readComics.bpo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nameProduct;

	private double rate;

	private int view;

	private String category;

	private String img;

	private String urlComic;

	@Column(columnDefinition = "varchar(max)")
	private String description;

	private int numberOfChapter;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id", nullable = false)
	private AuthorComic author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public AuthorComic getAuthor() {
		return author;
	}

	public void setAuthor(AuthorComic author) {
		this.author = author;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImg() {
		return this.img;
	}

	public void setNumberOfChapter(int numberOfChapter) {
		this.numberOfChapter = numberOfChapter;
	}

	public int getNumberOfChapter() {
		return this.numberOfChapter;
	}

	public void setUrlComic(String urlComic) {
		this.urlComic = urlComic;
	}

	public String getUrlComic() {
		return this.urlComic;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description = description;
	}

}
