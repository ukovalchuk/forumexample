package com.example.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "topic")

public class TopicEntity implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userEntity;
    @Column(name = "TEXT")
    private String text;

    //    @OneToMany(mappedBy = "topicEntity")
////    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="")
////    @JoinColumn (name="id",nullable = false,insertable = false,unique = false)
////    @LazyCollection(LazyCollectionOption.FALSE)
////    @JoinColumn(name = "topic_id", nullable = false)
//    private List<CommentEntity> comments;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "comment", joinColumns = @JoinColumn(name = "topic_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CommentEntity> comments;

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public TopicEntity() {
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public TopicEntity(Integer id, UserEntity userEntity, String text, List<CommentEntity> comments) {
        this.id = id;
        this.userEntity = userEntity;
        this.text = text;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

