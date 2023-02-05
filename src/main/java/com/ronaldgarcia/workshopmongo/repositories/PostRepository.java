package com.ronaldgarcia.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ronaldgarcia.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
