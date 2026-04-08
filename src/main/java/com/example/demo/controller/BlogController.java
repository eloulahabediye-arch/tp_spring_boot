package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.ArticleService;
import com.example.demo.service.CommentService;
import com.example.demo.model.Article;
import com.example.demo.model.Comment;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    // Get all articles
    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    // Get article by id
    @GetMapping("/articles/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    // Create article
    @GetMapping("/add-article")
    public Article addArticle(
            @RequestParam String title,
            @RequestParam String content) {

        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);

        return articleService.saveArticle(article);
    }

    // Add comment to article
    @GetMapping("/add-comment")
    public Comment addComment(
            @RequestParam Long articleId,
            @RequestParam String text,
            @RequestParam String author) {

        Article article = articleService.getArticleById(articleId);

        Comment comment = new Comment();
        comment.setText(text);
        comment.setAuthor(author);
        comment.setArticle(article);

        return commentService.saveComment(comment);
    }
}