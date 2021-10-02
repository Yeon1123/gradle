package com.jojoldu.book.springboot.domain.posts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void getPostWithTitleAndContent() {
        String title = "title";
        String content = "content";

        postsRepository.save(Posts.builder().title(title).content(content).author("author").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void addBaseTimeEntity() {
        String title = "title";
        String content = "content";
        LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
        postsRepository.save(Posts.builder().title(title).content(content).author("author").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        System.out.println("CreateDate? : " + posts.getCreatedDate() + " , ModifiedDate? : " + posts.getModifiDate());
        
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiDate()).isAfter(now);

    }

}
