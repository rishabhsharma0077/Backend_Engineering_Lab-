package in.example.blog.post.service;

import java.util.List;
import in.example.blog.post.entity.Post;

public interface PostService {
    List<Post> getAllPosts();
    List<Post> search(String keyword);
    void addPost(Post post);
    void deletePost(Long id);
}
