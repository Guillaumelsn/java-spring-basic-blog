package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {
@RequestMapping("/")
    public String listPosts(ModelMap map) {
        map.put("title", "Blog Post 1");
        List<Post> posts = new ArrayList<Post>(postRepository.getAllPosts());
        map.put("posts", posts);
        return "home";
    }
@RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap map) {
    Post post = postRepository.findById(id);
    map.put("post", post);
    return "post-details";
    }

    private PostRepository postRepository = new PostRepository();

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;

    }
}
