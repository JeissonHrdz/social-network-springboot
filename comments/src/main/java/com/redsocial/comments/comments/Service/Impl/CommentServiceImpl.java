package com.redsocial.comments.comments.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.comments.comments.Model.Dao.CommentDao;
import com.redsocial.comments.comments.Model.Dto.CommentDto;
import com.redsocial.comments.comments.Model.Entity.Comment;
import com.redsocial.comments.comments.Service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment save(CommentDto commentDto) {
        Comment comment = Comment.builder()
                .idComment(commentDto.getIdComment())
                .content(commentDto.getContent())
                .dateComment(commentDto.getDateComment())
                .idPost(commentDto.getIdPost())
                .idUser(commentDto.getIdUser())
                .build();
        return commentDao.save(comment);

    }

    @Override
    public List<Comment> showAll(Integer idPost) {
        return (List) commentDao.findAllByIdPost(idPost);

    }

    @Override
    public void delete(Comment comment) {
        commentDao.delete(comment);
    }

}
