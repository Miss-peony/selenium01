package selenium.day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertExercise {
    @Test
    public void testCase(){
        String a="acc";
        String b="adc";

//        if(a.equals(b)){
//            System.out.println("正确");
//        }else{
//            System.out.println("错误");
//        }
        Assert.assertEquals(a,b,"");

    }
}
