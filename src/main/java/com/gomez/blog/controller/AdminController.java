package com.gomez.blog.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.gomez.blog.service.ArticleManagementService;
import com.gomez.blog.service.model.ArticleDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
@RequiredArgsConstructor
public class AdminController {

    private final ArticleManagementService articleService;

    @GetMapping("/admin")
    private String getAdmin(Model model) {
        model.addAttribute("isAdmin", true);
        model.addAllAttributes(Map.of("articles",articleService.getArticles()));
        return "home";
    }

    @GetMapping("/new")
    public String newInputView(Model model) {
        model.addAttribute("article", new ArticleDto(null,null,null,null));
        return "new_article";
    }

    @PostMapping("/new")
    public String newInput(@ModelAttribute ArticleDto article) {
        articleService.save(article);
        return "redirect:/home";
    }
    
    @DeleteMapping("/article/{id}")
    public ResponseEntity<Void> deleteArticle(Model model, @PathVariable Long id) {
        articleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/edit/{id}")
    public String getMethodName(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleService.getArticle(id));
        return "edit_article";
    }

    @PostMapping("/edit/{id}")
    public String putMethodName(@PathVariable Long id) {
        return "redirect:/home";
    }
}
