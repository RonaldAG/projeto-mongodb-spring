package com.ronaldgarcia.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ronaldgarcia.workshopmongo.domain.Post;
import com.ronaldgarcia.workshopmongo.domain.User;
import com.ronaldgarcia.workshopmongo.dto.AuthorDTO;
import com.ronaldgarcia.workshopmongo.dto.CommentDTO;
import com.ronaldgarcia.workshopmongo.repositories.PostRepository;
import com.ronaldgarcia.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		AuthorDTO mariaDto = new AuthorDTO(maria);
		AuthorDTO alexDto = new AuthorDTO(alex);
		
		Post post1 = new Post(null, Instant.parse("2018-03-21T00:00:00Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", mariaDto);
		Post post2 = new Post(null, Instant.parse("2018-03-23T00:00:00Z"), "Bom dia", "Acordei feliz hoje!", mariaDto);
		
	
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		CommentDTO comment1 = new CommentDTO("Boa viagem mano!", Instant.parse("2018-03-21T00:00:00Z"), alexDto);
		CommentDTO comment2 = new CommentDTO("Aproveite!", Instant.parse("2018-03-22T00:00:00Z"), new AuthorDTO(bob));
		CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", Instant.parse("2018-03-23T00:00:00Z"), alexDto);
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().add(comment3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
