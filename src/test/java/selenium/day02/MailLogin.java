package selenium.day02;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MailLogin {
    WebDriver driver;
    long time=System.currentTimeMillis(); //去当前时间的时间戳

    @BeforeMethod
    public void openBrower(){
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\selenium01\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }
    /*  注册  */
    @Test
    public void zhuCe(){
        driver.get("https://mail.163.com/");
        driver.findElement(By.xpath(".//*[@class='loginWrap']/div[2]/a[1]")).click();
        String handle1= driver.getWindowHandle();
        for(String handle:driver.getWindowHandles()){
            if(handle.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handle);
        }

        driver.findElement(By.cssSelector("#username")).sendKeys("h"+time);
        driver.findElement(By.id("password")).sendKeys("H123456");
        driver.findElement(By.id("phone")).sendKeys(String.valueOf(time/100));
        driver.findElement(By.xpath("//*[@class=\"m-register-box-free\"]/div[4]/span")).click();
        driver.findElement(By.linkText("立即注册")).click();

    }

    @Test
    public void test2(){
        long time=System.currentTimeMillis();
        System.out.println(time);
    }
                 /* 封装登录 */
    public static void login(WebDriver driver,String user,String pwd){
        driver.get("https://mail.163.com/");
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/p")));
        WebElement iframe=driver.findElement(By.xpath("//div[@id='loginDiv']/iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.name("email")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();

    }




                          /* 登录 */
    @Test
    public void accountLogin() throws InterruptedException {
        MailLogin.login(driver,"h15210710913","icloud123");

        Thread.sleep(3000);
        String handle1= driver.getWindowHandle();
        for(String handle:driver.getWindowHandles()){
            if(handle.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handle);
        }
        String text=driver.findElement(By.xpath(".//div[@class='gWel-inner']/div/div[2]/span/span[1]")).getText();
        Assert.assertEquals(text,"h1521071091312");


    }
            /*  退出登录 */
    @Test
    public void exitLogin() throws InterruptedException {
        MailLogin.login(driver,"h15210710913","icloudHmj123");

        Thread.sleep(3000);
        String handle1= driver.getWindowHandle();
        for(String handle:driver.getWindowHandles()){
            if(handle.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handle);
        }

        WebElement button=driver.findElement(By.cssSelector("#_mail_icon_0_0"));
        Actions actions=new Actions(driver);
        actions.click(button).perform();
        driver.findElement(By.id("_mail_component_72_72")).click();
        Thread.sleep(3000);
    }



    @AfterMethod
    public void closeBrowser(){

        driver.quit();
    }

}

