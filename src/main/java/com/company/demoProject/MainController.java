package com.company.demoProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	private WebDriver driver;
	
	@GetMapping("/index")
	public String Hello() {
		return "main";
	}

	@RequestMapping("/craw")
	public @ResponseBody String crawling() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jeon\\Desktop\\react\\chromedriver.exe"); // 다운받은 ChromeDriver 위치를 넣어줍니다.
	    driver = new ChromeDriver(); // Driver 생성
	    
		try {
			/*
			 * //파싱할 웹페이지 OutputStream output = new
			 * FileOutputStream("C:/Users/Jeon/Desktop/react/Arsnal.txt"); String url =
			 * "https://sports.news.naver.com/wfootball/index.nhn"; //데이터 가져오기 Document doc
			 * = Jsoup.connect(url).get(); Elements element = doc.select("div.home_news");
			 * System.out.println(element); for(Element el : element.select("div.txt_area")
			 * ){}
			 */
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // Visit Google
	        driver.get("https://m.sports.naver.com/team/news.nhn?uCategory=wfootball&category=epl&teamCode=1006");

	        // Check the title of the page
	        System.out.println("Page title is: " + driver.getTitle());

	        // Find the text input element by its name
	        WebElement element = driver.findElement(By.id("_news_list_wrap"));
	        System.out.println(element.getText());
	        
	        
		} catch (Exception e) {
	            e.getStackTrace();
		}
		
		return "sucess";
	}
}
