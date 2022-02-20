package com.zimug.boot.lanuch.model;

import lombok.*;

import java.util.Date;
import java.util.List;

//2 4 1 針對接口編寫單元測試代碼
//由於缺乏 Constructor (建構元)導致錯誤
//MvcResult mvcResult = mockMvc.perform( 之 perform
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;

    private List<Reader> reader;
}
