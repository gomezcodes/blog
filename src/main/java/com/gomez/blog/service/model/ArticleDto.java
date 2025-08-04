package com.gomez.blog.service.model;

import lombok.Builder;

@Builder
public record ArticleDto(
    Long id,
    String title,
    String content,
    String date
) {
    
}
