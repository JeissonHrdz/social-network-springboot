package com.redsocial.users.users.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.redsocial.users.users.Model.Dto.PostDto;

@FeignClient(name = "msvc-posts", url = "localhost:8050/api/posts")
public interface PostClient {
    
    @GetMapping("/posts-user/{idUser}")
    List<PostDto> findAllPostByUser(@PathVariable Integer idUser);

}
