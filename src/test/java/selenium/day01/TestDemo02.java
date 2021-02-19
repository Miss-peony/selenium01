package selenium.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestDemo02 {
    @Test
    public void testCase(){
        String a="acc";
        String b="adc";

//        if(a.equals(b)){
//            System.out.println("正确");
//        }else{
//            System.out.println("错误");
//        }
       Assert.assertEquals(a,b,"");

   }
   @Test
    public void waitMethod(){
       System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\selenium01\\drivers\\chromedriver.exe");
       WebDriver driver=new ChromeDriver();
       driver.get("https://www.baidu.com/");
       driver.findElement(By.id("kw")).sendKeys("selenium");
       driver.findElement(By.id("su")).click();
       WebDriverWait wait=new WebDriverWait(driver,8);
       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='content_left']/div[1]/div[1]/h3/a")));
       String text=driver.getTitle();
       Assert.assertEquals(text,"selenium_百度搜索");
   }

    @Test
    public void downLoad() throws InterruptedException, AWTException {
        System.setProperty("webdriver.gecko.driver", "E:\\IdeaProjects\\selenium01\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://guanjia.qq.com/product/soft/?ADTAG=media.buy.baidu.dingtou");
        driver.findElement(By.xpath("/html/body/div[2]/div/a")).click();
        Thread.sleep(3000);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);

//        Actions actions=new Actions(driver);
//        actions.sendKeys(Keys.TAB). sendKeys(Keys.NULL);
//        Thread.sleep(2000);
//        actions.sendKeys(Keys.TAB). sendKeys(Keys.NULL);
//        actions.sendKeys(Keys.ENTER).sendKeys(Keys.NULL);   //未调通
    }


    }
