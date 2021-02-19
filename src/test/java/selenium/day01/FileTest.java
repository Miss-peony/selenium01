package selenium.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

/**
 * Created by lenovo on 2016/10/15.文件上传和下载
 */
public class FileTest {
    WebDriver driver;
    FirefoxProfile profile=new FirefoxProfile();
    @Test
    public void download() throws Exception {
        System.setProperty("webdriver.gecko.driver","E:\\IdeaProjects\\selenium01\\drivers\\geckodriver.exe");
        //下载操作,配置响应下载参数
        profile.setPreference("browser.download.dir","E:\\se_download");
        profile.setPreference("browser.download.foldList",2);//2表示保存到指定路径，0表示默认路径
        profile.setPreference("browser.download.useDownloadDir",true);
        profile.setPreference("browser.download.manager.showWhenStarting",false);//在开始下载时是否显示下载管理器
        //对所给出文件类型不再弹框进行询问
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip,text/plain," +
                "application/vnd.ms-excel,text/csv,text/comma-separated-values,application/octet-stream," +
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd." +
                "openxmlformats-officedocument.wordprocessingml.document");
        driver=new FirefoxDriver(profile);
        driver.get("https://guanjia.qq.com/sem/gj/index.html?ADTAG=media.buy.baidu.sembrand2");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div[2]/a")).click();
        Thread.sleep(30000);
        driver.quit();

        //快捷键的操作用到Robot类
//        Robot robot=new Robot();
//        robot.keyPress(KeyEvent.VK_ALT);
//        robot.keyPress(KeyEvent.VK_S);
//        Thread.sleep(3000);
//        robot.keyRelease(KeyEvent.VK_ALT);
//        robot.keyRelease(KeyEvent.VK_S);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        Thread.sleep(3000);
//        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
        /*String pic_exist="alert(\\\"download successfully\\\")";
        String pic_not_exist = "alert(\"download unsuccessfully\")";
        if (file.exists()){
            ((JavascriptExecutor) driver).executeScript(pic_exist);
        }else {
            ((JavascriptExecutor) driver).executeScript(pic_not_exist);
        }*/

