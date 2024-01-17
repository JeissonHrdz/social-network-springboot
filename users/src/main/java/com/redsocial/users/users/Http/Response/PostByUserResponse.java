package com.redsocial.users.users.Http.Response;

import java.util.List;

import com.redsocial.users.users.Model.Dto.PostDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PostByUserResponse {
    
    private String name;
    private String lastName;
    private List<PostDto> postDto; 
    
}
