package com.gomez.blog;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GuestController {

    private final ArticleManagementService articleService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAllAttributes(Map.of("articles",articleService.getArticles()));
        return "home";
    }

    @GetMapping("/article/{id}")
    public String getMethodName(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleService.getArticle(id));
        return "article";
    }
    
}
