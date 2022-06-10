package com.hanghae.spring_miniProject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "POST_ID")
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String imgUrl;
    @Column
    private String category;
    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    @JsonManagedReference // 직렬화 허용 어노테이션
    @OneToMany(mappedBy = "post", orphanRemoval = true) // orpahRemanal = true 부모 삭제시 자식도 삭제
    private List<Comment> comments;
}
