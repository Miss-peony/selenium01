package selenium.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PhantomJsTest {
    @Test
    public void openTesst() throws InterruptedException {
        System.setProperty("phantomjs.binary.path","E:\\IdeaProjects\\selenium01\\drivers\\phantomjs.exe");
        WebDriver driver=new PhantomJSDriver();
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(6000);
        String text=driver.getTitle();
        Assert.assertEquals(text,"selenium_百度搜索");
    }

}
