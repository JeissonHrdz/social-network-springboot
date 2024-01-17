package com.redsocial.posts.posts.Model.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.redsocial.posts.posts.Model.Entity.Post;

public interface PostDao extends CrudRepository<Post, Integer> {

    @Query("SELECT s FROM Post s WHERE s.idUser = :idUser")
    List<Post> findAllByIdUser(Integer idUser);

}
