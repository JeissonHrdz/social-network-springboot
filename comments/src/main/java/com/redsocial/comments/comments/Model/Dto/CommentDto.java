package com.redsocial.comments.comments.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommentDto {

    private Integer idComment;
    private String content; 
    private String dateComment;
    private Integer idPost;
    private Integer idUser;
    
}
