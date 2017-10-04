package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment")

public class CommentEntity implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TOPIC_ID", nullable = false)
    private TopicEntity topicEntity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userEntity;
    @Column(name = "TEXT")
    private String text;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public CommentEntity() {

    }

    public TopicEntity getTopicEntity() {
        return topicEntity;
    }

    public void setTopicEntity(TopicEntity topicEntity) {
        this.topicEntity = topicEntity;
    }

    public CommentEntity(Integer id, TopicEntity topicEntity, UserEntity userEntity, String text) {
        this.id = id;
        this.topicEntity = topicEntity;
        this.userEntity = userEntity;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
