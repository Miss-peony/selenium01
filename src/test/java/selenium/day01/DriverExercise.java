package selenium.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DriverExercise {
    WebDriver driver;

    @BeforeMethod
    public void driverOpen(){
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\selenium01\\drivers\\chromedriver.exe");
         driver=new ChromeDriver();
    }



    @Test
    public void closeChrome() throws InterruptedException {

        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        driver.navigate().back();

    }

    @Test
    public void setWindow() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        Dimension dimension=new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        Thread.sleep(3000);
        driver.manage().window().maximize();
//        driver.navigate().back();

    }
    @Test
    public void getUrl() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        String actual=driver.getCurrentUrl();
        Assert.assertEquals(actual,"https://www.Google.com/","链接错误");

    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }




}
