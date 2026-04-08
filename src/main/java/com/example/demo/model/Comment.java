package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String author;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    // Constructors
    public Comment() {}

    public Comment(String text, String author, Article article) {
        this.text = text;
        this.author = author;
        this.article = article;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public Article getArticle() { return article; }
    public void setArticle(Article article) { this.article = article; }
}