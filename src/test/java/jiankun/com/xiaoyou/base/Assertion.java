package jiankun.com.xiaoyou.base; 

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年2月15日 下午3:33:20 
 * 类说明 
 */
public class Assertion {


    public static boolean flag = true;                      //是否有错误

    public static List<Error> errors = new ArrayList<Error>();    //错误集合

    /**
     * 验证值是否相等
     * @param actual 第一个值
     * @param expected 要对比的值
     */
    public static void verifyEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
    }


    /**
     * 验证值是否相等
     * @param actual 第一个是实际值
     * @param expected 要对比的预期值
     * @param message 出错时候的提示消息
     */
    public static void verifyEquals(Object actual, Object expected, String message){
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(Error e){
            errors.add(e);
            flag = false;
        }
    }
}
 