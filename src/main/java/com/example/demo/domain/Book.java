package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String author;
	private String title;
	private String isbn;
	@Column(name="year")
	private int releaseYear;
    private int price; 

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	public Book() {

	}

	public Book(String author, String title, String isbn, int releaseYear, Category category, int price) {
		super();
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.releaseYear = releaseYear;
		this.category = category;
        this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

    
	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", year="
				+ releaseYear;
	}

}