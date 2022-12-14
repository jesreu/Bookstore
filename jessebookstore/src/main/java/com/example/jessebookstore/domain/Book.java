package com.example.jessebookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String author;
	private long releaseyear;
	private String isbn;
	private double price;
	
	@ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
	
	public Book () {}

	public Book(String title, String author, long releaseyear, String isbn, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.releaseyear = releaseyear;
		this.isbn = isbn;
		this.price = price;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public long getReleaseyear() {
		return releaseyear;
	}

	public void setReleaseyear(long releaseyear) {
		this.releaseyear = releaseyear;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
