package com.redsocial.posts.posts.Service;

import java.util.List;

import com.redsocial.posts.posts.Model.Dto.PostDto;
import com.redsocial.posts.posts.Model.Entity.Post;

public interface IPostService {

    Post save(PostDto post); 
    List<Post> showAll();    
    void delete(Post post);
    Post findById(Integer id);
    List<Post> findByIdUser(Integer idUser);
}
