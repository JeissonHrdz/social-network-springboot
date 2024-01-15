package com.redsocial.comments.comments.Model.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @Column(name = "idComment")    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComment;

    @Column(name = "content")
    private String content;

    @Column(name = "dateComment")
    private String dateComment;

    @Column(name = "idPost")
    private Integer idPost;

    @Column(name = "idUser")
    private Integer idUser;
    
}
