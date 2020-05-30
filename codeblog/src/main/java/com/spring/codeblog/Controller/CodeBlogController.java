package com.spring.codeblog.Controller;

import com.spring.codeblog.Model.PostModel;
import com.spring.codeblog.Service.CodeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CodeBlogController {

    @Autowired
    CodeBlogService codeBlogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView modelAndView = new ModelAndView("posts");
        List<PostModel> posts = codeBlogService.findAll();
        modelAndView.addObject("posts", posts);

        return modelAndView;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("postDetails");
        PostModel post = codeBlogService.findById(id);
        modelAndView.addObject("post", post);

        return modelAndView;
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.GET)
    public String getPostForm() {

        return "postForm";
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public String savePost(@Validated PostModel postModel, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("message", "Verifique se oos campos foram preenchidos!");

            return "redirect:/newPost";
        }
        postModel.setDate(LocalDate.now());
        codeBlogService.save(postModel);

        return "redirect:/posts";
    }
}
