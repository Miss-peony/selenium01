package selenium.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FireFoxDriverOpen {
    @Test
    public void openFireFox() {
        System.setProperty("webdriver.gecko.driver", "E:\\IdeaProjects\\selenium01\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com/");
        driver.quit();
    }
}
