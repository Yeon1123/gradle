package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *DAO와 같은 역할. DB Layer 접근자. Entity Class 와 PK타입을 상속받아 기본 CRUD를 생성 
 Entity Class(Posts)와 함께 위치해야 함
 */ 

public interface PostsRepository extends JpaRepository<Posts, Long> {
    
}
