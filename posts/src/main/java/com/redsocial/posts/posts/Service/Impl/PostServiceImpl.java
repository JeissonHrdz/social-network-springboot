package com.redsocial.posts.posts.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.posts.posts.Model.Dao.PostDao;
import com.redsocial.posts.posts.Model.Dto.PostDto;
import com.redsocial.posts.posts.Model.Entity.Post;
import com.redsocial.posts.posts.Service.IPostService;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private PostDao postDao;

    @Override
    public Post save(PostDto postDto) {
        Post post = Post.builder()
                .idPost(postDto.getIdPost())
                .content(postDto.getContent())
                .datePost(postDto.getDatePost())
                .idUser(postDto.getIdUser())
                .build();
        return postDao.save(post);
    }

    @Override
    public List<Post> showAll() {
        return  (List) postDao.findAll();
    }

    @Override
    public void delete(Post post) {
        postDao.delete(post);
    }

    @Override
    public Post findById(Integer id) {
        return postDao.findById(id).orElse(null);
    }

    @Override
    public List<Post> findByIdUser(Integer idUser) {
        return postDao.findAllByIdUser(idUser);
    }
 

}
