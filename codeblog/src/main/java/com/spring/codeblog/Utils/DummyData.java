package com.spring.codeblog.Utils;

import com.spring.codeblog.Model.PostModel;
import com.spring.codeblog.Repository.CodeBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CodeBlogRepository codeBlogRepository;

    //@PostConstruct
    public void savePosts() {

        List<PostModel> postModelList = new ArrayList<>();
        PostModel post1 = new PostModel();
        post1.setAuthor("Mykael Andrade");
        post1.setDate(LocalDate.now());
        post1.setTitle("Docker");
        post1.setText("Alguma coisa");

        PostModel post2 = new PostModel();
        post2.setAuthor("Mykael Andrade");
        post2.setDate(LocalDate.now());
        post2.setTitle("Heroku");
        post2.setText("Alguma coisa 2");

        postModelList.add(post1);
        postModelList.add(post2);

        for(PostModel postModel: postModelList) {
            PostModel postSaved = codeBlogRepository.save(postModel);
            System.out.println(postSaved.getId());
        }
    }
}
