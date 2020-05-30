package com.spring.codeblog.Service;

import com.spring.codeblog.Model.PostModel;

import java.util.List;

public interface CodeBlogService {

    List<PostModel> findAll();
    PostModel findById(long id);
    PostModel save(PostModel postModel);
}
