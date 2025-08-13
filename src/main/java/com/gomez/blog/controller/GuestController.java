package com.gomez.blog.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gomez.blog.service.ArticleManagementService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GuestController {

    private final ArticleManagementService articleService;

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("isAdmin", false);
        model.addAllAttributes(Map.of("articles",articleService.getArticles()));
        return "home";
    }

    @GetMapping("/article/{id}")
    public String getArticle(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleService.getArticle(id));
        return "article";
    }
    
}
