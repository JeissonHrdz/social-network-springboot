package com.redsocial.posts.posts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.redsocial.posts.posts.Exception.ResourceNotFoundException;
import com.redsocial.posts.posts.Model.Dto.PostDto;
import com.redsocial.posts.posts.Model.Entity.Post;
import com.redsocial.posts.posts.Model.Payload.MessageResponse;
import com.redsocial.posts.posts.Service.IPostService;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private IPostService postService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> created(@RequestBody PostDto postDto) {
        Post postSave = null;

        try {
            postSave = postService.save(postDto);
            postDto = PostDto.builder()
                    .idPost(postSave.getIdPost())
                    .content(postSave.getContent())
                    .datePost(postSave.getDatePost())
                    .idUser(postSave.getIdUser())
                    .build();
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Post Creado Correctamente")
                    .object(postDto)
                    .build(),
                    HttpStatus.CREATED);
        } catch (DataAccessException DTeX) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(DTeX.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);

        }
    }

    @GetMapping("/board")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showAllPosts() {
        List<Post> getPosts = postService.showAll();
        if (getPosts == null || getPosts.isEmpty()) {
            throw new ResourceNotFoundException("post");
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("")
                        .object(getPosts)
                        .build(),
                HttpStatus.OK);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id) {
        try {
            Post postDelete = postService.findById(id);
            postService.delete(postDelete);
            return new ResponseEntity<>(postDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException DTeX) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(DTeX.getMessage())
                    .object(null)
                    .build(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/posts-user/{idUser}")
    public  ResponseEntity<?> findByIdUser(@PathVariable Integer idUser) {
        return ResponseEntity.ok(postService.findByIdUser(idUser));
    }
    

}
