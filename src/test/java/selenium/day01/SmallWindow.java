package selenium.day01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmallWindow {

    WebDriver driver;

    @BeforeMethod
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\selenium01\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", "E:\\IdeaProjects\\selenium01\\drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();
    }

                /*  控制权交给弹框，点击确认        */

    @Test
    public void alert() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.xpath(".//*[@id='alert']/input")).click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }

            /*  控制权交给弹框，点击取消，再点击确认   */
    @Test
    public void warn() throws InterruptedException {
        driver.get("file:///E:/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("asssss");
        Thread.sleep(3000);
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
    }

    /*  控制权交给frame 元素，   */

    @Test
    public void iframe() throws InterruptedException {
        driver.get("E:\\selenium_html\\index.html");
        driver.switchTo().frame("aa");
        driver.findElement(By.id("user")).sendKeys("我复制了一份文件");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("user")).sendKeys("我回来了");
        Thread.sleep(3000);
    }
    @Test
    public void selectTest() throws InterruptedException {
        driver.get("E:\\selenium_html\\index.html");
        WebElement button=driver.findElement(By.id("moreSelect"));
        Select select=new Select(button);
        select.selectByValue("huawei");
        Thread.sleep(3000);
        select.deselectByIndex(0);
        Thread.sleep(3000);
        select.selectByVisibleText("oppe");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void close() throws InterruptedException {
//        Thread.sleep(3000);
        driver.quit();

    }


}
