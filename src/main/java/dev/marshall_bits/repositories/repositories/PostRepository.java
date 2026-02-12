package dev.marshall_bits.repositories.repositories;

import dev.marshall_bits.repositories.models.Post;
import dev.marshall_bits.repositories.models.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByTitle(String tittle);


    List<Post> findByCategory(PostCategory postCategory);


    @Query("SELECT p FROM Post p WHERE p.viewCount > 100")
    List<Post> findPostsWithMoreThan100Views();

    @Query("SELECT p FROM Post p order by p.createdAt desc")
    List<Post> findAllByCreatedAt();

    @Query("SELECT p FROM Post p WHERE p.title like %:keyword%")
    List<Post> findByTitleContaining(@Param("keyword") String keyword);

}
