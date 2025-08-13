package com.gomez.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gomez.blog.service.model.ArticleDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleManagementService {

    private final ArticleService articleService;

    public List<ArticleDto> getArticles() {
        return articleService.getAll();
    }

    public ArticleDto getArticle(Long id) {
        return articleService.get(id);
    }

    public void save(ArticleDto article) {
        articleService.save(article);
    }

    public void delete(Long id) {
        articleService.delete(id);
    }

}
