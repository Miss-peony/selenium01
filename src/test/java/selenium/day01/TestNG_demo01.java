package selenium.day01;

import org.testng.annotations.*;

public class TestNG_demo01 {
    @BeforeTest
    public  void beforeTest(){
        System.out.println("这是一个“@BeforeTest注解");
    }
    @BeforeMethod
    public  void beforeMethod(){
        System.out.println("这是一个“ @BeforeMethod注解");
    }
    @Test
    public void testCase1(){
        System.out.println("第一个测试用例");
    }

    @Test
    public void testCase2(){
        System.out.println("第二个测试用例");
    }

    @AfterMethod
    public  void afterMethod(){
        System.out.println("这是一个“@AfterMethod注解");
    }
    @AfterTest
    public  void afterTest(){
        System.out.println("这是一个“@AfterTest注解");
    }

    @DataProvider(name ="abc")
    public Object[][] data2(){
        return new Object[][]{
                {"http"},
                {"http2"},
                {"http3"}
        };
    }

    @Test(dataProvider = "abc")
    public void test1(String url){
        if(url.equals("http")){
            System.out.println("这是第一个"+url);
        }else if(url.equals("http2")){
            System.out.println("这是第二个"+url);
        }else
            System.out.println("这是第三个"+url);

    }

}
