package com.zimug.boot.lanuch.model;

import lombok.*;

//2 4 1 針對接口編寫單元測試代碼
//由於缺乏 Constructor (建構元)導致錯誤
//MvcResult mvcResult = mockMvc.perform( 之 perform
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reader {

    private String name;

    private Integer age;
}
