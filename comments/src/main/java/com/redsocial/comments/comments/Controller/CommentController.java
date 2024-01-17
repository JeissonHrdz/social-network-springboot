package com.redsocial.comments.comments.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.redsocial.comments.comments.Exception.ResourceNotFoundException;
import com.redsocial.comments.comments.Model.Dto.CommentDto;
import com.redsocial.comments.comments.Model.Entity.Comment;
import com.redsocial.comments.comments.Model.Payload.MessageResponse;
import com.redsocial.comments.comments.Service.ICommentService;

@RestController
@RequestMapping("/api/posts/{idPost}/comments")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody CommentDto commentDto) {
        Comment commentSave = null;
        try {
            commentSave = commentService.save(commentDto);
            commentDto = CommentDto.builder()
                    .idComment(commentSave.getIdComment())
                    .content(commentSave.getContent())
                    .dateComment(commentSave.getDateComment())
                    .idPost(commentSave.getIdPost())
                    .idUser(commentSave.getIdUser())
                    .build();
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("")
                    .object(commentDto)
                    .build(), HttpStatus.CREATED);

        } catch (DataAccessException DTeX) {
            return new ResponseEntity<>(MessageResponse.builder()
                    .message(DTeX.getMessage())
                    .object(null)
                    .build(), HttpStatus.METHOD_NOT_ALLOWED);

        }
    }
    @GetMapping
    public ResponseEntity<?> showAll(@PathVariable Integer idPost){
             List<Comment> getComments = commentService.showAll(idPost);
        if (getComments == null || getComments.isEmpty()) {
            throw new ResourceNotFoundException("comment");
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("")
                        .object(getComments)
                        .build(),
                HttpStatus.OK);
    }
}
