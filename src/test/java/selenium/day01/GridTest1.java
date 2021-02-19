package selenium.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lenovo on 2016/10/26.
 */
public class GridTest1{
    @DataProvider(name = "browser1")
    public  Object[][] data(){
        //记得return返回的后面要加引号，必须是Object类
        return new Object[][]{
                {"http://10.20.48.155:7777","chrome"},
                {"http://10.20.48.155:43932","firefox"},
//                {"http://10.20.48.155:43932","ie"}
       };
    }
    @Test(dataProvider = "browser1")
    public void testData(String url,String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities;
        if (browser.equals("chrome")){
            desiredCapabilities=DesiredCapabilities.chrome();
        }else if(browser.equals("firefox")){
            desiredCapabilities=DesiredCapabilities.firefox();
        }else {
            desiredCapabilities=DesiredCapabilities.internetExplorer();
        }
        WebDriver driver=new RemoteWebDriver(new URL(url+"/wd/hub"),desiredCapabilities);
        driver.get("http://www.baidu.com");Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void open1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc= DesiredCapabilities.internetExplorer();
        WebDriver driver =new RemoteWebDriver(new URL("http://10.20.48.155:41073/wd/hub"),dc);
        driver.get("https://mail.163.com/");
        Thread.sleep(2000);
        driver.quit();
    }


}
