package com.example.jessebookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.jessebookstore.domain.Book;
import com.example.jessebookstore.domain.BookRepository;
import com.example.jessebookstore.domain.Category;
import com.example.jessebookstore.domain.CategoryRepository;
import com.example.jessebookstore.domain.User;
import com.example.jessebookstore.domain.UserRepository;



@SpringBootApplication
public class JessebookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(JessebookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JessebookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner CmdRunner(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			crepository.save(new Category("Toiminta"));
			crepository.save(new Category("Fantasia"));
			crepository.save(new Category("Sci-fi"));
			
	repository.save(new Book("Esimerkki", "Matti Meikäläinen", 2001, "111-111-11111-1-1", 30, crepository.findByName("Toiminta").get(0)));
	repository.save(new Book("Testi", "Aku Ankka", 2021, "123-123-12345-1-2", 50.5, crepository.findByName("Fantasia").get(0)));
	log.info("Lisättiin tuotteet tietokantaan");
	

	
	log.info("Etsitään kaikki tuotteet");
	for (Book book : repository.findAll()) {
		log.info(book.toString());
	}
				// Luodaan pari käyttäjää
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","user@kayttaja.test", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","admin@kayttaja.test", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
	};
	}
	

}
