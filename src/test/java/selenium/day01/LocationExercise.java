package selenium.day01;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LocationExercise {
    WebDriver driver;  //相当于int a,给一个全局变量

    @BeforeMethod
    public void driver(){
        System.setProperty("webdriver.chrome.driver","E:\\IdeaProjects\\selenium01\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void byId() throws InterruptedException {
//        打开百度
        driver.get("https://www.baidu.com/");
 //       百度搜索框输入selenium
         driver.findElement(By.id("kw")).sendKeys("selenium");
 //         点击百度按钮
         driver.findElement(By.id("su")).click();

 //        等待5s
         Thread.sleep(5000);
  //       获取页面title
         String text=driver.getTitle();
  //       校验
        Assert.assertEquals(text,"selenium_百度搜索");
    }

    @Test
    public void ReturnAssert() throws InterruptedException {
        //        打开百度
        driver.get("https://www.baidu.com/");
        //       百度搜索框输入小强
        driver.findElement(By.id("kw")).sendKeys("小强");
        //         点击百度按钮
        driver.findElement(By.id("su")).click();
        Thread.sleep(3000);

        // 获取返回页面第一个文本信息，最好等待，不然页面没有加载渲染完成，会找不到元素

        String text1=driver.findElement(By.xpath(".//*[@id='1']/h3/a")).getText();
        //       校验
        Assert.assertEquals(text1,"蟑螂(蜚蠊目昆虫) - 百度百科");

    }

    /*
    打开两个窗口，对第二个窗口进行操作，必须转换handle值
     */

    @Test
    public void handle() throws InterruptedException {
        //        打开百度
        driver.get("https://www.baidu.com/");
        //点击百度页面学术按钮
        driver.findElement(By.linkText("学术")).click();
        //获取当前页面的handle值
        String handle1=driver.getWindowHandle();
        //移交页面控制权
        for (String handle2:driver.getWindowHandles()) {
            if(handle2.equals(handle1)){
                continue;
            }else{
                driver.switchTo().window(handle2);
            };
            System.out.println(handle2);
        }
        Thread.sleep(3000);
       String text=driver.findElement(By.xpath("//*[@id=\"line_one\"]/div/div[2]/div[2]/a[4]/span")).getText();
                    //校验
        Assert.assertEquals(text,"学者主页");
         //  String text= driver.getTitle();
        //  Assert.assertEquals(text2,"百度学术 - 保持学习的态度");
    }


    /*  获取某个元素的某个属性值  */

    @Test
    public void attributeValue(){
        driver.get("https://www.baidu.com/");
        WebElement ele=driver.findElement(By.id("su"));
        //获取定位到的元素的属性值
       String text3= ele.getAttribute("value");
        System.out.println(text3);
    }

    /*判断某个元素是否展示*/
    @Test
    public void isDisplayed(){
        driver.get("https://www.baidu.com/");
        WebElement ele=driver.findElement(By.id("su"));
        boolean b= ele.isDisplayed();
        Assert.assertTrue(b);
    }

    /*  判断某个元素是否被选中*/

    @Test
    public void isSelected(){
        driver.get("file:///E:/selenium_html/index.html");
        WebElement ele=driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
        ele.click();
        Boolean b=ele.isSelected();
        Assert.assertTrue(b);
    }

    /*  判断某个元素是否被激活 */

    @Test
    public void isEnabled(){
        driver.get("file:///E:/selenium_html/index.html");
       Boolean b= driver.findElement(By.xpath("//*[@id=\"button\"]/input[1]")).isEnabled();
        Assert.assertFalse(b);
    }

    //截图
    @Test
    public void shotTest(){
        driver.get("file:///E:/selenium_html/index.html");
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
