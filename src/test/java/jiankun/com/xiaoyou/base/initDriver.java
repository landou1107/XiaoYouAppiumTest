package jiankun.com.xiaoyou.base;
 
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
 
/**
 * Title: initDriver
 * Description: 
 * Company: XiaoYou
 * @author lishuang
 * @date 2017年3月3日 上午10:56:06
 */
/**
 * Title: initDriver
 * Description: 
 * Company: XiaoYou
 * @author lishuang
 * @date 2017年3月3日 上午10:56:25
 */
@Listeners({jiankun.com.xiaoyou.base.AssertionListener.class})
public class initDriver{
	
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
    public static int newCommandTimeout = 300;
    
    //设置浏览器
    public static String browserName = "";
    
    public static AndroidDriver<WebElement>  driver;
    
    @Parameters({"deviceName","platformVersion","port", "udid" })
    @BeforeClass
    public void getInitDriver(String deviceName, String platformVersion, int port, String udid) throws Exception {
    	
    	print("【@BeforeClass】当前方法名称:" + Thread.currentThread().getStackTrace()[1].getMethodName() 
    			+ "当前执行线程号: " + Thread.currentThread().getId() 
    			+ " ,deviceName is: " + deviceName 
    			+ " ,platformVersion is: " + platformVersion 
    			+ " ,port is: " + port 
    			+ " ,udid is: " + udid); 
    	
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
//        capabilities.setCapability("deviceName", deviceName);
        
        //设置UID
        if(!TextUtils.isEmpty(udid)){
        	capabilities.setCapability("udid", udid);
        	capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("platformVersion", platformVersion);
        }               
        //启动Driver
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:" + port +"/wd/hub"), capabilities);
    }
 
//    @AfterClass
//    public void tearDown() throws Exception {
//    	print("【@AfterClass】当前方法名称:" + Thread.currentThread().getStackTrace()[1].getMethodName() + "当前执行线程号: " + Thread.currentThread().getId());
//        driver.quit();
//    }
    
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
