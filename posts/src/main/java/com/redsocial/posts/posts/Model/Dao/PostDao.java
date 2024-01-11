package com.redsocial.posts.posts.Model.Dao;

import org.springframework.data.repository.CrudRepository;

import com.redsocial.posts.posts.Model.Entity.Post;

public interface PostDao extends CrudRepository<Post, Integer> {
    
}
