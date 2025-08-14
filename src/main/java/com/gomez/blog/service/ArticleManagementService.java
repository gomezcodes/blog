package com.gomez.blog.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gomez.blog.service.model.ArticleDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleManagementService {

    private final ArticleService articleService;

    public List<ArticleDto> getArticles() {
        List<ArticleDto> articles = articleService.getAll();
        articles.stream().forEach(article -> mapObjectDateToDescription(article));
        return articles; 
    }

    public ArticleDto getArticle(Long id) {
        return articleService.get(id);
    }

    public ArticleDto getFormatedArticle(Long id) {
        ArticleDto article = this.getArticle(id);
        mapObjectDateToDescription(article);
        return article;
    }

    public void save(ArticleDto article) {
        article.setId(null);
        articleService.save(article);
    }

    public void edit(ArticleDto article) {
        articleService.save(article);
    }

    public void delete(Long id) {
        articleService.delete(id);
    }

    private LocalDate mapStringToDate(String date){
        return LocalDate.parse(date);
    }

    private String mapDateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return date.format(formatter);
    }

    private void mapObjectDateToDescription(ArticleDto article) {
        LocalDate date = mapStringToDate(article.getDate());
        article.setDate(mapDateToString(date));
    }
}
