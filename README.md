# boot-lanuch
Spring Boot 從青銅到王者系列 本人而非字母哥實做內容  
[播放清單](https://www.youtube.com/playlist?list=PLPeEs8-8l_L8VvpXKLOscgyDOaXKaPnVf)

#2022/02/21 
至 2 4 2 servlet容器環境下的測試

###2 4 1 針對接口編寫單元測試代碼
src/test/java/com/zimug/boot/lanuch/ArticleRestControllerTest.java:35  
createTime 與原教學不同，原教學用 yyyy-MM-dd HH:mm:ss 的時間格式，但是不能作用

model/Reader.java,Article.java  
由於缺乏 Constructor (建構元)導致下列程式碼錯誤錯誤  
ArticleRestControllerTest.java:42  
MvcResult mvcResult = mockMvc.perform( 之 perform  
  
###2 4 2 servlet容器環境下的測試    
src/test/java/com/zimug/boot/lanuch/ArticleRestControllerTest.java:35  
原教學的時間格式可以作用  

src/test/java/com/zimug/boot/lanuch/ArticleRestControllerTest2.java:56  
回傳的值不知為何是 application/vnd.ms-excel，加上這行之後就解決了

#2022/02/15
至 2 2 2 HTTP 協議與 Spring 參數接收註解


