package com.example.jessebookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.jessebookstore.domain.User;
import com.example.jessebookstore.domain.UserRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {
	
	@Autowired
    private UserRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
        User user = repository.findByUsername("user");
        assertThat(user.getUserid()).isEqualTo(1);
    }
    
    @Test
    public void createNewUser() {
    	User user = new User("user2", "$2a$05$Fo5tF2i86Vsr6Dp6gnIsLe850LGmy85Tu8jU9MpeE.0OP4kOE6gge", "user2@hotmail.com", "user");
    	repository.save(user);
    	assertThat(user.getUserid()).isNotNull();
    }
    
    @Test
    public void deleteUser() {
    	 User user = repository.findByUsername("user");
		repository.delete(user);
		User user2 = repository.findByUsername("user");
		assertThat(user2).isNull();
     }

}
