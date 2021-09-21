package com.jojoldu.book.springboot.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity 클래스에서는 Setter를 생성하지 않음. 구분을 위해서.
 */

@Getter
@NoArgsConstructor // 파라미터가 없는 기본 생성자 = public Posts(){}
@Entity // table과 링크될 클래스입니다!
public class Posts {
    // DB layer
    @Id // PK, generated value로 생성 규칙 설정. Identity는 autoincrement를 위한 설정임.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false) // 사용하지 않아도 컬럼과 매칭되지만 추가 옵션을 위해 사용함.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
