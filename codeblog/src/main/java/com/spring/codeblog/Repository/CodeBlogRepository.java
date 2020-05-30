package com.spring.codeblog.Repository;

import com.spring.codeblog.Model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeBlogRepository extends JpaRepository<PostModel, Long> {
}
