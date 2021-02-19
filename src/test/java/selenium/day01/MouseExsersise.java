package selenium.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class MouseExsersise {

    WebDriver driver;
    @BeforeMethod
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\selenium01\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void rightClick() throws InterruptedException {
        driver.get("https://www.baidu.com/");
        WebElement button=driver.findElement(By.id("su"));
        Actions action=new Actions(driver);
        action.contextClick(button).perform();
        Thread.sleep(3000);
    }
    @Test
    public void doubleClick(){
        driver.get("https://www.baidu.com/");
        WebElement button=driver.findElement(By.id("su"));
        Actions actions=new Actions(driver);
        actions.doubleClick(button).perform();
    }
        /* 鼠标移动*/
    @Test
    public void moveToElement() throws InterruptedException {
         driver.get("file:///E:/selenium_html/index.html");
         driver.manage().window().maximize();
          WebElement button=driver.findElement(By.xpath(".//*[@id='action']/input"));
          Actions actions=new Actions(driver);
          actions.moveToElement(button).perform();
          Thread.sleep(6000);
          String text=driver.findElement(By.xpath("//*[text()='Hello World!']")).getText();
          Assert.assertEquals(text,"Hello World!");


    }
            /*鼠标拖拽*/
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("file:///E:/selenium_html/dragAndDrop.html");
        driver.manage().window().maximize();
        WebElement square1=driver.findElement(By.id("drag"));
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(square1,300,300).perform();
        Thread.sleep(6000);
    }

                /* */
    @Test
    public void dragAndDrop2() throws InterruptedException {
        driver.get("file:///E:/selenium_html/dragAndDrop.html");
        driver.manage().window().maximize();
        WebElement square1=driver.findElement(By.id("drag"));
        WebElement target=driver.findElement(By.xpath("/html/body/h1"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(square1)
                .moveToElement(target)
                .release()
                .perform();
        Thread.sleep(5000);
    }
    @Test
    public void moreSelect() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        driver.manage().window().maximize();
        WebElement select=driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list=driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions actions=new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .click(list.get(0))
                .click(list.get(2))
                .keyUp(Keys.SHIFT)
                .perform();
        Thread.sleep(5000);

        actions.keyDown(Keys.CONTROL)
                .click(list.get(3))
                .keyUp(Keys.CONTROL)
                .perform();

        Thread.sleep(5000);
    }

    @Test
    public void robotTest() throws AWTException, InterruptedException {
        driver.get("https://www.baidu.com/");
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    @Test
    public void upLoad() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"load\"]")).sendKeys("C:\\Users\\12925\\Desktop\\rose.jpg");
        Thread.sleep(5000);
    }
    @Test
    public void downLoad(){
        driver.get("https://guanjia.qq.com/product/soft/?ADTAG=media.buy.baidu.dingtou");
        driver.findElement(By.xpath("/html/body/div[2]/div/a")).click();




    }
    @AfterMethod
    public void closeDriver(){
        driver.quit();

}

}
