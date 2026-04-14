package in.example.blog.post.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.example.blog.post.entity.Post;
import in.example.blog.post.service.PostService;

@Controller
public class BlogController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String search) {
        List<Post> posts = (search != null && !search.isEmpty()) 
                ? postService.search(search)
                : postService.getAllPosts();

        model.addAttribute("posts", posts);
        return "index";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute Post post) {
        postService.addPost(post);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/";
    }
}
