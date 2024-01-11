package com.redsocial.posts.posts.Model.Entity;

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
@Table(name = "post")

public class Post {

    @Id
    @Column(name = "idPost")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;

    @Column(name = "content")
    private String content;

    @Column(name = "datePost")
    private String datePost;

    @Column(name = "idUser")
    private Integer idUser;
    
}
