package com.redsocial.comments.comments.Service;

import java.util.List;

import com.redsocial.comments.comments.Model.Dto.CommentDto;
import com.redsocial.comments.comments.Model.Entity.Comment;

public interface ICommentService {
    
    Comment save(CommentDto commentDto);
    List<Comment> showAll(Integer idPost);
    void delete(Comment comment);
}
