package selenium.day01;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {
    @Test
    public void chromeTest() throws MalformedURLException, InterruptedException {
//        DesiredCapabilities dc=DesiredCapabilities.chrome();
        DesiredCapabilities dc= DesiredCapabilities.internetExplorer();
        WebDriver driver =new RemoteWebDriver(new URL("http://10.20.48.155:19767/wd/hub"),dc);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();

    }

}

