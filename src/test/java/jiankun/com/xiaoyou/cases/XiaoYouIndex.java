package jiankun.com.xiaoyou.cases;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

import jiankun.com.xiaoyou.base.Assertion;
import jiankun.com.xiaoyou.base.InitAppiumXiaoYou;
import jiankun.com.xiaoyou.base.XiaoYouBuilder;
import jiankun.com.xiaoyou.operation.IndexPageOperate;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 测试首页
 * Created by LITP on 2016/9/23.
 */

//implements InitAppiumXiaoYou.
public class XiaoYouIndex {

    private IndexPageOperate indexPageOperate;
//    private OldUserLoginPage oldUserLoginPage;
    
   private AndroidDriver<WebElement>  driver;

    //继承父类属性
    @Parameters({"deviceName","platformVersion","udid","port"})
    XiaoYouIndex(String deviceName, String platformVersion, String udid, int port){
    	//super关键字：我们可以通过super关键字来实现对父类成员的访问，用来引用当前对象的父类。
    	try {
			driver = InitAppiumXiaoYou.initDriver(new XiaoYouBuilder()
				    	.setAppActivity(".ui.main.splash.SplashActivity")
				    	.setDeviceName(deviceName)
				    	.setPlatformVersion(platformVersion)
				    	.setUdid(udid)
				    	.setPort(port));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	InitAppiumXiaoYou.print("属性步骤2--- Index界面开始参数化setUdid：" + udid);
//    	InitAppiumXiaoYou.print("属性步骤2--- Index界面开始参数化setPort：" + port);

//    	//设置初始化
//    	super.setOnInitOperate(this);
    }

//    @BeforeClass
    public void initOperate() {
//      public void initOperate(String udid, int port) {
        Assert.assertNotNull(driver);
        indexPageOperate = new IndexPageOperate(driver);
//        oldUserLoginPage = new OldUserLoginPage(driver);

    }
    
    
    @Test(priority = 1)
    public void IndexNoUpdate(){
    	initOperate();
        //验证首页界面更新提示
        Assertion.verifyEquals(indexPageOperate.indexNoUpdate(), true, "首页界面不存在");
    }
    
    @Test(priority = 2)
    public void verifyClickOldLoginButton(){
    	initOperate();
    	//验证点击【老用户登录】按钮成功后，再返回首页界面
    	Assertion.verifyEquals(indexPageOperate.verifyClickOldLoginButton(), true, "点击【老用户登录】按钮失败");
    }
    
    @Test(priority = 3)
    public void verifyClickNewLoginButton(){
    	initOperate();
    	//验证点击【我是新用户】按钮成功后，再返回首页界面
    	Assertion.verifyEquals(indexPageOperate.verifyClickNewLoginButton(), true, "点击【我是新用户】按钮失败");
    }

  @AfterClass
  public void afterClass(){
//  	System.out.println("【@AfterClass】当前方法名称:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "当前执行线程号: " + Thread.currentThread().getId());
      //每一个用例完毕结束这次测试
      driver.quit();
  }
}
