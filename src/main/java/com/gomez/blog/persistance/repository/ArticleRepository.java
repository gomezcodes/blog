package com.gomez.blog.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gomez.blog.persistance.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

}
