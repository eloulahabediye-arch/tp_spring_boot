package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.model.Article;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    // Get all articles
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // Get article by id
    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // Save article
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }
}