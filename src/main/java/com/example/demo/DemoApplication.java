package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;

import ch.qos.logback.classic.Logger;


@SpringBootApplication
public class DemoApplication {
	private static final Logger log = (Logger) LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}




	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository drepository){
		return (args) -> {

			log.info("save a couple of books");

			drepository.save(new Category("Thriller"));
			drepository.save(new Category("Dystopia"));
			drepository.save(new Category("Poem"));

			Book novel1 = new Book( "Ernest Hemingway", "A Farewell to Arms","123-123", 1929, drepository.findByName("Thriller").get(0), 15);

			Book novel2 = new Book( "George Orwell", "Animal Farm","321-321", 1945, drepository.findByName("Dystopian").get(0), 12);

			Book novel3 = new Book("Murakami", "Norwegian wood","321-321", 2008, drepository.findByName("Thriller").get(0), 12);

			Book novel4 = new Book("edgar poe", "raven","321-321", 1930, drepository.findByName("Poem").get(0), 5);

			repository.save(novel1);
			repository.save(novel2);
			repository.save(novel3);
			repository.save(novel4);

			log.info("fetch all books");
			for(Book book : repository.findAll()){
				log.info(book.toString());
			}



		};


	}
}
