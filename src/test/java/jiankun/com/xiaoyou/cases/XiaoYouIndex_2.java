package jiankun.com.xiaoyou.cases;
 
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;

import jiankun.com.xiaoyou.base.Assertion;
import jiankun.com.xiaoyou.operation.IndexPageOperate;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class XiaoYouIndex_2 {
	
    private IndexPageOperate indexPageOperate;
	
	/**
	 * 从testNG获取port，udid，platformVersion
	 */
    //appium启动端口
    public int port;
    //设备UID
    public String udid;
    //调试设备系统版本
    public String platformVersion;
    
    //调试设备名字
    public String deviceName;

    /**
     * 这里设置静态变量
     */
    //app路径
    public static String appPath = System.getProperty("user.dir") + "/apps/XiaoYou_Android_V5.0.0.9_201612021_0ab7227_Debug.apk";

    //包名
    public static String appPackage = "com.xiaoyou.alumni";

    //是否需要重新安装
    public static String noReset = "True";

    //是否不重新签名
    public static String noSign = "True";

    //是否使用unicode输入法，真是支持中文
    public static String unicodeKeyboard = "True";

    //是否默认输入法
    public static String resetKeyboard = "True";

    //要启动的Activity
    public static String appActivity = appPackage + ".ui.main.splash.SplashActivity";
    
    //是否收到下一条命令的超时时间,超时appium会自动关闭session ,默认60秒
    public static int newCommandTimeout = 180;
    
    //设置浏览器
    public static String browserName = "";
    
    private AndroidDriver<WebElement>  driver;
    
    @Parameters({"platformVersion","port", "udid" })
    @BeforeClass
    public void getInitDriver(String platformVersion, int port, String udid) throws Exception {
    	
        this.platformVersion = platformVersion;
    	this.port = port;
        this.udid = udid;
        
        DesiredCapabilities capabilities = new DesiredCapabilities();    
        
        capabilities.setCapability("app", new File(appPath).getAbsolutePath());
        capabilities.setCapability("appPackage", appPackage);
        //支持中文
        capabilities.setCapability("unicodeKeyboard", unicodeKeyboard);
        //运行完毕之后，变回系统的输入法
        capabilities.setCapability("resetKeyboard", resetKeyboard);
        //不重复安装
        capabilities.setCapability("noReset", noReset);
        //不重新签名
        capabilities.setCapability("noSign", noSign);
        //设置命令超时时间
        capabilities.setCapability("newCommandTimeout", newCommandTimeout);
        //打开的activity
        capabilities.setCapability("appActivity", appActivity);
        //设置浏览器
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
        
        //设置UID
        if(!TextUtils.isEmpty(udid)){
            capabilities.setCapability("deviceName", udid);
        	capabilities.setCapability("udid", udid);
            capabilities.setCapability("platformVersion", platformVersion);
        }           
    	
    	print("【@BeforeClass】当前方法名称:" + Thread.currentThread().getStackTrace()[1].getMethodName() 
    			+ "当前执行线程号: " + Thread.currentThread().getId() 
    			+ " ,platformVersion is: " + platformVersion 
    			+ " ,port is: " + port 
    			+ " ,udid is: " + udid); 
        
        //启动Driver
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:" + port +"/wd/hub"), capabilities);
    }
    
    @Test(priority = 1)
    public void IndexNoUpdate(){
    	GetThreadMethodName();
        //验证首页界面更新提示
        Assertion.verifyEquals(indexPageOperate.indexNoUpdate(), true, "首页界面不存在");
    }
    
//    @Test(priority = 2)
//    public void verifyClickOldLoginButton(){
//    	GetThreadMethodName();
//    	//验证点击【老用户登录】按钮成功后，再返回首页界面 
//    	Assertion.verifyEquals(indexPageOperate.verifyClickOldLoginButton(), true, "点击【老用户登录】按钮失败");
//    }
//    
//    @Test(priority = 3)
//    public void verifyClickNewLoginButton(){
//    	GetThreadMethodName();
//    	//验证点击【我是新用户】按钮成功后，再返回首页界面
//    	Assertion.verifyEquals(indexPageOperate.verifyClickNewLoginButton(), true, "点击【我是新用户】按钮失败");
//    }

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
 
 
    /**
     * 打印字符
     *
     * @param str 要打印的字符
     */
    public static <T> void print(T str) {
        if (!TextUtils.isEmpty(String.valueOf(str))) {
            System.out.println(str);
        } else {
            System.out.println("输出了空字符");
        }
    }
}
