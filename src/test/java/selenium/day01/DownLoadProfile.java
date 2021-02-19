package selenium.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class DownLoadProfile {
    WebDriver driver;
   @Test
    public void firefoxProfile() throws InterruptedException {
       FirefoxProfile profile=new FirefoxProfile();
       //设置火狐的默认的下载文件夹，0:表示桌面 1表示我的下载  2表示自定义文件夹
       profile.setPreference("browser.download.folderList",2);
       //设置自定义文件夹位置
       profile.setPreference("browser.download.dir","E:\\se_download");
//       profile.setPreference("browser.download.useDownloadDir",true);
       //在开始下载时是否显示下载管理器
       profile.setPreference("browser.download.manager.showWhenStarting",false);
       profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip,text/plain," +
               "application/vnd.ms-excel,text/csv,text/comma-separated-values,application/octet-stream," +
               "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd." +
               "openxmlformats-officedocument.wordprocessingml.document");
       System.setProperty("webdriver.gecko.driver","E:\\IdeaProjects\\selenium01\\drivers\\geckodriver.exe");
       //打开一个预先配置的火狐
        driver=new FirefoxDriver(profile);
        driver.get("https://guanjia.qq.com/sem/gj/index.html?ADTAG=media.buy.baidu.sembrand2");
        driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/div[2]/a")).click();
        Thread.sleep(30000);
        driver.quit();

   }
}
