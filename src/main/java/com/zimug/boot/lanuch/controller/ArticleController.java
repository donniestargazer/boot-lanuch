package com.zimug.boot.lanuch.controller;

import com.zimug.boot.lanuch.AjaxResponse;
import com.zimug.boot.lanuch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
//@RestController
@Controller
@RequestMapping("/rest")
public class ArticleController {

    //查詢一篇文章，根據id
    //@RequestMapping(value = "/articles/{id}", method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    public @ResponseBody AjaxResponse getArticle(@PathVariable("id") Long id){

        Article article = Article.builder()
                .id(1L)
                .author("kevinstargazer")
                .content("spring boot 從青銅到王者")
                .createTime(new Date())
                .title("t1").build();

        log.info("article:" + article);

        return AjaxResponse.success(article);
    }

    //新增一篇文章
    //@RequestMapping(value = "/articles", method = RequestMethod.POST)
    @PostMapping(value = "/articles")
    public @ResponseBody AjaxResponse saveArticle(@RequestBody Article article){

        log.info("saveArticle:" + article);

        return AjaxResponse.success(article);
    }

    /*@PostMapping(value = "/articles")
    public AjaxResponse saveArticle(@RequestParam String author,
                                    @RequestParam String title,
                                    @RequestParam String content,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                    @RequestParam Date createTime){

        log.info("saveArticle:" + title);

        return AjaxResponse.success();
    }*/

    //修改一篇文章
    //@RequestMapping(value = "/articles", method = RequestMethod.PUT)
    @PutMapping("/articles")
    public @ResponseBody AjaxResponse updateArticle(@RequestBody Article article){

        if(article.getId() == null)
        {
            //TODO 拋出一個自定義的異常
        }
        log.info("updateArticle:" + article);

        return AjaxResponse.success();
    }

    //刪除一篇文章，根據id
    //@RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/articles/{id}")
    public @ResponseBody AjaxResponse deleteArticle(@PathVariable("id") Long id){

        log.info("deleteArticle:" + id);

        return AjaxResponse.success();
    }
}
