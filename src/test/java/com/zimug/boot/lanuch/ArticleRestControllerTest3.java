package com.zimug.boot.lanuch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zimug.boot.lanuch.controller.ArticleController;
import com.zimug.boot.lanuch.model.Article;
import com.zimug.boot.lanuch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@AutoConfigureMockMvc
@WebMvcTest(ArticleController.class)//減少使用的 Bean 並縮小測試範圍，加快測試速度
@ExtendWith(SpringExtension.class)
public class ArticleRestControllerTest3 {

    //mock對象
    @Resource
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Test
    public void saveArticle() throws Exception {

        String article = "{\n" +
                "\"id\": 1,\n" +
                "\"author\": \"kevinstargazer\",\n" +
                "\"title\": \"手把手教你開發Spring Boot\",\n" +
                "\"content\": \"spring boot 從青銅到王者\",\n" +
                "\"createTime\": \"2022-03-20T15:33:00.000+08:00\",\n" +
                //2 4 3 servlet容器環境下的測試
                //原教學用 yyyy-MM-dd HH:mm:ss 的時間格式，但是不能作用
                "\"reader\":[{\"name\":\"kevin\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Article articleObj = objectMapper.readValue(article, Article.class);
        //打樁
        when (articleService.saveArticle(articleObj)).thenReturn("ok");

        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders
                                .request(HttpMethod.POST, "/rest/articles")
                                .contentType("application/json")
                                .header("Accept", "application/json")
                                .content(article)
                )
                .andDo(print())
                .andReturn();

        mvcResult.getResponse().setCharacterEncoding("UTF-8");
        log.info(mvcResult.getResponse().getContentAsString());
    }
}
