package selenium.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OpenDriver {
    @Test
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\IdeaProjects\\selenium01\\drivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.baidu.com/");
        chromeDriver.quit();
    }

    @Test
    public void openFireFox() {
        System.setProperty("webdriver.gecko.driver", "E:\\IdeaProjects\\selenium01\\drivers\\geckodriver.exe");
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.baidu.com/");
    }
    @Test
    public void openIE() {
        System.setProperty("webdriver.ie.driver", "E:\\IdeaProjects\\selenium01\\drivers\\IEDriverServer.exe");
        WebDriver ieDriver = new InternetExplorerDriver();
        ieDriver.get("https://www.baidu.com/");
    }
    @Test
    public void openEdge() {
        System.setProperty("webdriver.edge.driver", "E:\\IdeaProjects\\selenium01\\drivers\\msedgedriver.exe");
        WebDriver edgeDriver = new EdgeDriver();

    }
    @Test
    public void dragAndDrop3() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "E:\\IdeaProjects\\selenium01\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///E:/selenium_html/dragAndDrop.html");
//        driver.manage().window().maximize();
        WebElement square1=driver.findElement(By.id("drag"));
        WebElement target=driver.findElement(By.xpath("/html/body/h1"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(square1,target);
        Thread.sleep(5000);
    }
}