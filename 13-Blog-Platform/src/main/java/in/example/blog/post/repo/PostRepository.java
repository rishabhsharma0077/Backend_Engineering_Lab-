package in.example.blog.post.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import in.example.blog.post.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContainingIgnoreCase(String keyword);
}