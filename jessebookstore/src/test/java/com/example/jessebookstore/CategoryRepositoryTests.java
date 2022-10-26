package com.example.jessebookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.jessebookstore.domain.Category;
import com.example.jessebookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTests {
	
	@Autowired
    private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = repository.findByName("Toiminta");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getCategoryid()).isEqualTo(1);
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Fiktio");
    	repository.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    }
    
    @Test
    public void deleteCategory() {
    	List<Category> categories = repository.findByName("Toiminta");
    	Category category = categories.get(0);
		repository.delete(category);
		List<Category> updatedCategories = repository.findByName("Toiminta");
		assertThat(updatedCategories).hasSize(0);
     }
}