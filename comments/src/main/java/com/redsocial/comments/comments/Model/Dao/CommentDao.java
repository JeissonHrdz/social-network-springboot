package com.redsocial.comments.comments.Model.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.redsocial.comments.comments.Model.Entity.Comment;

public interface CommentDao extends CrudRepository<Comment, Integer> {

    @Query("SELECT s FROM comment WHERE s.id_post = :idPost")
    List<Comment> findAllCommentsPost(Integer idPost);
    
}
