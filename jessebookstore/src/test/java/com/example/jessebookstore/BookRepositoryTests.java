package com.example.jessebookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.jessebookstore.domain.Book;
import com.example.jessebookstore.domain.BookRepository;
import com.example.jessebookstore.domain.Category;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTests {
	
	@Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = repository.findByTitle("Esimerkki");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Matti Meikäläinen");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Hölynpölyä", "Joni Jokamies", 2015, "111-111-11111-1-2", 50, new Category("Fiktio"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    @Test
    public void deleteNewBook() {
    	List<Book> books = repository.findByTitle("Esimerkki");
    	Book book = books.get(0);
		repository.delete(book);
		List<Book> updatedBooks = repository.findByTitle("Esimerkki");
		assertThat(updatedBooks).hasSize(0);
     }
}
