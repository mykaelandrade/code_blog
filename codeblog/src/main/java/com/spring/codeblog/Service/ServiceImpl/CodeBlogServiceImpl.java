package com.spring.codeblog.Service.ServiceImpl;

import com.spring.codeblog.Model.PostModel;
import com.spring.codeblog.Repository.CodeBlogRepository;
import com.spring.codeblog.Service.CodeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeBlogServiceImpl implements CodeBlogService {

    @Autowired
    CodeBlogRepository codeBlogRepository;

    @Override
    public List<PostModel> findAll() {
        return codeBlogRepository.findAll();
    }

    @Override
    public PostModel findById(long id) {
        return codeBlogRepository.findById(id).get();
    }

    @Override
    public PostModel save(PostModel postModel) {
        return codeBlogRepository.save(postModel);
    }
}
