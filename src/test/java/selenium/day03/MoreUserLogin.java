package selenium.day03;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.day02.MailLogin;

public class MoreUserLogin {
    WebDriver driver;
    long time=System.currentTimeMillis(); //去当前时间的时间戳
    @BeforeMethod
    public void openBrower() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\selenium01\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @DataProvider(name="userList")
    public Object[][] data(){
        return new Object[][]{
                {"h15210710913","icloudHmj123"},
                {"h100288777","112333"}
        };

    }

    @Test(dataProvider = "userList")
    public void accountLogin(String email,String mima) throws InterruptedException {
        MailLogin.login(driver,email,mima);

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
}
