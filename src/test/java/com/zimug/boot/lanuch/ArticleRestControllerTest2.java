package com.zimug.boot.lanuch;

import com.zimug.boot.lanuch.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ArticleRestControllerTest2 {

    //mock對象
    @Resource
    private MockMvc mockMvc;

    /*@BeforeAll
    static void setUP(){
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }*/

    @Test
    public void saveArticle() throws Exception {

        String article = "{\n" +
                "\"id\": 1,\n" +
                "\"author\": \"kevinstargazer\",\n" +
                "\"title\": \"手把手教你開發Spring Boot\",\n" +
                "\"content\": \"spring boot 從青銅到王者\",\n" +
                "\"createTime\": \"2022-03-20 15:33:00\",\n" +
                //2 4 2 servlet容器環境下的測試
                //上一個小節，時間格式不能作用，但現在時間格式又可以作用了
                //前一小節的註解可見於 ArticleRestControllerTest
                "\"reader\":[{\"name\":\"kevin\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                    .request(HttpMethod.POST, "/rest/articles")
                    .contentType("application/json")
                    .header("Accept", "application/json")
                    //2 4 2 servlet容器環境下的測試
                    //回傳的值不知為何是 application/vnd.ms-excel，加上這行之後就解決了
                    .content(article)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("kevinstargazer"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
        .andDo(print())
        .andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }
}
