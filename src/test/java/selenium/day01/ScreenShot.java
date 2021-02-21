package selenium.day01;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShot {
    WebDriver driver;

    /*   截图   */
    @Test
    public void shotTest(){
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\selenium01\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("file:///E:/selenium_html/index.html");
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
