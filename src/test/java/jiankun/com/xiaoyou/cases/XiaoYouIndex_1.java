package jiankun.com.xiaoyou.cases;


import jiankun.com.xiaoyou.base.Assertion;
import jiankun.com.xiaoyou.base.initDriver;
import jiankun.com.xiaoyou.operation.IndexPageOperate;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * 测试首页
 * Created by LITP on 2016/9/23.
 */

//implements InitAppiumXiaoYou.
public class XiaoYouIndex_1 extends initDriver{

    private IndexPageOperate indexPageOperate;

    public void initOperate() {
        Assert.assertNotNull(driver);
        indexPageOperate = new IndexPageOperate(driver);
    }
    
    
    @Test(priority = 1)
    public void IndexNoUpdate(){
    	GetThreadMethodName();
    	initOperate();
        //验证首页界面更新提示
        Assertion.verifyEquals(indexPageOperate.indexNoUpdate(), true, "首页界面不存在");
    }
    
    @Test(priority = 2)
    public void verifyClickOldLoginButton(){
    	GetThreadMethodName();
    	initOperate();
    	//验证点击【老用户登录】按钮成功后，再返回首页界面 
    	Assertion.verifyEquals(indexPageOperate.verifyClickOldLoginButton(), true, "点击【老用户登录】按钮失败");
    }
    
    @Test(priority = 3)
    public void verifyClickNewLoginButton(){
    	GetThreadMethodName();
    	initOperate();
    	//验证点击【我是新用户】按钮成功后，再返回首页界面
    	Assertion.verifyEquals(indexPageOperate.verifyClickNewLoginButton(), true, "点击【我是新用户】按钮失败");
    }

    @AfterClass
    public void tearDown() throws Exception {
    	print("【@@AfterClass】当前方法名称:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "当前执行线程号: " + Thread.currentThread().getId());
        driver.quit();
    }
    

	/**
	 * MethodsInfo:打印获取的方法名称和线程号
	 * 2017年3月3日 上午11:45:52
	 */
	private void GetThreadMethodName() {
		print("【@Test】当前方法名称:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "当前执行线程号: " + Thread.currentThread().getId());
	}
}
