package com.zimug.boot.lanuch;

import com.zimug.boot.lanuch.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
public class ArticleRestControllerTest {

    //mock對象
    private static MockMvc mockMvc;

    @BeforeAll
    static void setUP(){
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    @Test
    public void saveArticle() throws Exception {

        String article = "{\n" +
                "\"id\": 1,\n" +
                "\"author\": \"kevinstargazer\",\n" +
                "\"title\": \"手把手教你開發Spring Boot\",\n" +
                "\"content\": \"spring boot 從青銅到王者\",\n" +
                "\"createTime\": \"2022-03-20 15:33:00\",\n" +
                "\"reader\":[{\"name\":\"kevin\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                    .request(HttpMethod.POST, "/rest/articles")
                    .contentType("application/json")
                    .content(article)
        ).andDo(print())
        .andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }
}
