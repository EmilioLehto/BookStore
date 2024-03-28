package com.example.demo.domain;

import java.util.Locale.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String isbn;
    private String author;
    private String title;
    private int year;
    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {

    }

    public Book(String author, String title,String isbn, int year, Category category, int price) {
        super();
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.category= category;
        this.price = price;
    
    }

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    @Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", year="
				+ year + ", price=" + price; 
	}

    
}
