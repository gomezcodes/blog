package com.gomez.blog;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
