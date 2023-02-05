package com.ronaldgarcia.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronaldgarcia.workshopmongo.domain.Post;
import com.ronaldgarcia.workshopmongo.domain.User;
import com.ronaldgarcia.workshopmongo.dto.UserDTO;
import com.ronaldgarcia.workshopmongo.repositories.UserRepository;
import com.ronaldgarcia.workshopmongo.services.exception.EmptyPostsException;
import com.ronaldgarcia.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(String id, User obj) {
		User user = findById(id);
		updateData(user, obj);
		return repository.save(user);
	}
	
	public void updateData(User obj1, User obj2) {
		obj1.setName(obj2.getName());
		obj1.setEmail(obj2.getEmail());
	}
	
	public List<Post> findPosts(String id){
		List<Post> posts = findById(id).getPosts();
		if(posts.isEmpty()) {
			throw new EmptyPostsException("O usuário não possui postagens");
		}
		return posts;
	}
}
