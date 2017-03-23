package jiankun.com.xiaoyou.cases; 

import jiankun.com.xiaoyou.base.Assertion;
import jiankun.com.xiaoyou.base.InitAppium;
import jiankun.com.xiaoyou.operation.LoginOperate;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年2月16日 上午11:19:30 
 * 类说明 登录测试用例（Login.java,继承InitAppium，实现用例的初始化操作）
 */
public class Login extends InitAppium {

    private LoginOperate loginOperate;


    @BeforeClass
    public void initDriver(){
        Assert.assertNotNull(driver);
        loginOperate = new LoginOperate(driver);
    }

    /**
     * 测试帐号对 密码不对情况
     */
    @Test(priority = 0)
    public void loginErrorUser(){
        boolean flag = loginOperate.login("13192624740","iuhihj");
        Assertion.verifyEquals(flag,true,"帐号对密码错误是否登录成功");
        print("帐号密码不对情况登录:"+ flag);
    }

    /**
     * 测试帐号密码规格不对情况
     */
    @Test(priority = 1)
    public void loginErrorNum(){
        boolean flag = loginOperate.login("1319262asdfsddsasdfsdfsdfsdfsdfsdf4740","dfgd#@$1234fgdsfgdsgdffds");
        Assertion.verifyEquals(flag,true,"帐号密码格式不对是否登录成功");
        print("帐号密码格式不对情况登录:"+ flag);
    }


    /**
     * 测试帐号密码为中文情况
     */
    @Test(priority = 2)
    public void loginChinese(){
        boolean flag = loginOperate.login("帐号","密码");
        Assertion.verifyEquals(flag,true,"帐号密码为中文是否登录成功");
        print("帐号密码为中文情况登录:"+ flag);
    }



    /**
     * 测试帐号密码为空情况
     */
    @Test(priority = 3)
    public void loginEmpty(){
        boolean flag = loginOperate.login("","");
        Assertion.verifyEquals(flag,true,"帐号密码为空是否登录成功");
        print("帐号密码为空情况登录:"+ flag);
    }


    /**
     * 测试帐号密码正确情况
     */
    @Test(priority = 4)
    public void loginConfim() {
        boolean flag = loginOperate.login("13192624740","xxxxxx");
        print("帐号密码对的情况登录:"+ flag);
        Assert.assertTrue(flag,"帐号密码对的情况登录");

    }

}

 