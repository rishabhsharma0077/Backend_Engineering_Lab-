package in.example.blog.post.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String content;

    private String author;
    private String date;
    private String image;
    private String category;
    private int likes;
    private int comments;

    @ElementCollection
    private List<String> tags;
}
