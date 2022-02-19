package com.zimug.boot.lanuch.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Value
public class Article {

    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;

    private List<Reader> reader;
}
