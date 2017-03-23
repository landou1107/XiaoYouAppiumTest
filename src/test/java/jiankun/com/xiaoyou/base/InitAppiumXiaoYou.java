package jiankun.com.xiaoyou.base; 

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import jiankun.com.xiaoyou.cases.XiaoYouIndex;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年2月15日 下午3:07:13 
 * 类说明 测试用例的父类
 */
/**
 * Title: InitAppiumXiaoYou
 * Description: 
 * Company: XiaoYou
 * @author lishuang
 * @date 2017年2月28日 下午5:56:21
 */
@Listeners({jiankun.com.xiaoyou.base.AssertionListener.class})
public class InitAppiumXiaoYou {

//	//调试设备名字
//    public static String deviceName = "OnePlus";
//    //调试设备系统版本
//    public static String platformVersion = "6.0.1";
//	//apk的路径
//    public static String appPath = System.getProperty("user.dir");
//
//    //包名
    public static String appPackage = "com.xiaoyou.alumni";
    public static AndroidDriver<WebElement> driver;
//
//    //是否需要重新安装
//    public static String noReset = "True";
//
//    //是否不重新签名
//    public static String noSign = "True";
//
//    //是否使用unicode输入法，真是支持中文
//    public static String unicodeKeyboard = "True";
//
//    //是否默认输入法
//    public static String resetKeyboard = "True";
//    
//    //是否修改超时命令时间
//    public static int newCommandTimeout = 120;
//
//    //要启动的Activity
//    //public static String appActivity = appPackage + ".activity.login.WelcomeActivity";
//    public static String appActivity = "";
//    
//    //设备UID
//    public static String udid = "udid";
//    
//    //设置端口
//    public static int port = 8888;
//    
//    //设置浏览器
//    public static String browserName= "";
//
//    public   AndroidDriver<WebElement> driver = null;
//    public static  AndroidDriver<WebElement> driver ;

    //引用父类的构造方法
//    public InitAppiumXiaoYou() {
//    	//this关键字：指向自己的引用。
//        this(new XiaoYouBuilder());
//    }

//	public InitAppiumXiaoYou(XiaoYouBuilder xiaoYoubuilder) {

//        appActivity = xiaoYoubuilder.appActivity;
//        appPackage = xiaoYoubuilder.appPackage;
//        appPath = xiaoYoubuilder.appPath;
//        deviceName = xiaoYoubuilder.deviceName;
//        noReset = xiaoYoubuilder.noReset;
//        noSign = xiaoYoubuilder.noSign;
//        unicodeKeyboard = xiaoYoubuilder.unicodeKeyboard;
//        resetKeyboard = xiaoYoubuilder.resetKeyboard;
//        newCommandTimeout = xiaoYoubuilder.newCommandTimeout;
//        udid = xiaoYoubuilder.udid;
//        print("属性步骤3-- InitAppiumXiaoYou界面的udid：" + udid);
//        port = xiaoYoubuilder.port;
//        print("属性步骤3-- InitAppiumXiaoYou界面的port：" + port);
//        browserName = xiaoYoubuilder.browserName;
//    }

    /**
     * appium启动参数
     *
     * @throws MalformedURLException
     */
    @BeforeClass
//    public void beforeSuite() throws MalformedURLException {
    public static AndroidDriver<WebElement> initDriver(XiaoYouBuilder xiaoYoubuilder) throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        String platformVersion =xiaoYoubuilder.platformVersion;
        String appActivity = xiaoYoubuilder.appActivity;
        String appPackage = xiaoYoubuilder.appPackage;
        String appPath = xiaoYoubuilder.appPath;
        String deviceName = xiaoYoubuilder.deviceName;
        String noReset = xiaoYoubuilder.noReset;
        String noSign = xiaoYoubuilder.noSign;
        String unicodeKeyboard = xiaoYoubuilder.unicodeKeyboard;
        String resetKeyboard = xiaoYoubuilder.resetKeyboard;
        int newCommandTimeout = xiaoYoubuilder.newCommandTimeout;
        String udid = xiaoYoubuilder.udid;
        int port = xiaoYoubuilder.port;;
        String  browserName = xiaoYoubuilder.browserName;
        
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("app", new File(appPath).getAbsolutePath());
//        System.out.println("输出安装APK路径:"+new File(appPath).getAbsolutePath());
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
        //设置浏览器
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
        
        //打开的activity
        if(!TextUtils.isEmpty(appActivity)){
            capabilities.setCapability("appActivity", appActivity);
        }
        
        //设置UID
        if(!TextUtils.isEmpty(udid)){
        	capabilities.setCapability("udid", udid);
            print("属性步骤4-- InitAppiumXiaoYou类获取deviceName: 【" + deviceName + "】,udid: 【" + udid + "】,prot: 【" + port + "】,platformVersion: 【" + platformVersion + "】");
//        	capabilities.setCapability("deviceName", udid);
//            print("属性步骤4-- InitAppiumXiaoYou类获取prot:" + port);
//            print("属性步骤4-- InitAppiumXiaoYou类获取platformVersion:" + platformVersion);
        }
        
        //设置收到下一条命令的超时时间,超时appium会自动关闭session ,默认60秒
        /**
         * 由于apk比较大，使用无线连接Android手机需要设置超长时间
         * 使用adb connect 连接客户端 传输包时间很长导致失败 90000ms
         */
        capabilities.setCapability("newCommandTimeout",960);

        //启动Driver
//        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

//        print("http://127.0.0.1:" + port + "/wd/hub");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
//        print("@BeforeClass的driver: " + driver);
//      print("初始化driver:" + (driver != null));
      
//      //初始化操作类
//      if(OnInitOperate!=null){
//    	  
//      }
       return driver;
    }


//    @AfterTest
//    public void afterTest() {
//        //每一个用例完毕结束这次测试
//    	print("@AfterTest 的driver: " + driver);
//        driver.quit();
//    }

//    @AfterClass
//    public void afterClass(){
////        每一个用例完毕结束这次测试
//    	print("【【AfterClass】】的driver: " + driver);
//    	driver.quit();
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
 