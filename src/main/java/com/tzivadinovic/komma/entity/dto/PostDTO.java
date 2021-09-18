package com.tzivadinovic.komma.entity.dto;

import com.tzivadinovic.komma.entity.Category;
import com.tzivadinovic.komma.entity.Tag;
import com.tzivadinovic.komma.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class PostDTO {
    private User user;
    private Category category;
    private String title;
    private String content;
    private String excerpt;
    private String tags;
}
