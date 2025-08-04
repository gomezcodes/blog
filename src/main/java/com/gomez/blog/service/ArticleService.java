package com.gomez.blog.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gomez.blog.persistance.Article;
import com.gomez.blog.persistance.repository.ArticleRepository;
import com.gomez.blog.service.exception.ArticleNotFoundException;
import com.gomez.blog.service.model.ArticleDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository repository;

    public List<ArticleDto> getAll() {
        List<Article> allArticles = repository.findAll();

        return allArticles.stream()
            .map(
                article -> new ArticleDto(
                    article.getId(), 
                    article.getTitle(),
                    article.getContent(), 
                    mapDate(article.getDate())))
            .collect(Collectors.toList());
    }

    private String mapDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return date.format(formatter);
    }

    public ArticleDto get(Long id) {

        Optional<Article> articleOp = repository.findById(id);
        if (!articleOp.isPresent()) {
            throw new ArticleNotFoundException();
        }

        Article articleEntity = articleOp.get();
        ArticleDto article = new ArticleDto(articleEntity.getId(), articleEntity.getTitle(), articleEntity.getContent(), mapDate(articleEntity.getDate()));

        return article;
    }

}
