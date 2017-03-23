package jiankun.com.xiaoyou.base; 

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年2月15日 下午3:07:13 
 * 类说明 测试用例的父类
 */
@Listeners({jiankun.com.xiaoyou.base.AssertionListener.class})
public class InitAppium {
    //调试设备名字
    public static String deviceName = "minote";
    //调试设备系统版本
    public static String platformVersion = "4.4.2";
	//apk的路径
    public static String appPath = System.getProperty("user.dir");

    //包名
    public static String appPackage = "com.minstone.mdoctor";

    //是否需要重新安装
    public static String noReset = "True";

    //是否不重新签名
    public static String noSign = "True";

    //是否使用unicode输入法，真是支持中文
    public static String unicodeKeyboard = "True";

    //是否默认输入法
    public static String resetKeyboard = "True";
    
    //是否修改超时命令时间
    public static int newCommandTimeout = 120;

    //要启动的Activity
    //public static String appActivity = appPackage + ".activity.login.WelcomeActivity";
    public static String appActivity = "";

    public static  AndroidDriver<WebElement> driver = null;


    //引用父类的构造方法
    public InitAppium() {
        this(new Builder());
    }

    public InitAppium(Builder builder) {

        appActivity = builder.appActivity;
        appPackage = builder.appPackage;
        appPath = builder.appPath;
        deviceName = builder.deviceName;
        noReset = builder.noReset;
        noSign = builder.noSign;
        unicodeKeyboard = builder.unicodeKeyboard;
        resetKeyboard = builder.resetKeyboard;
        newCommandTimeout = builder.newCommandTimeout;
    }

    /**
     * appium启动参数
     *
     * @throws MalformedURLException
     */
    @BeforeSuite
    public void beforeSuite() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("app", new File(appPath).getAbsolutePath());
        System.out.println("输出安装APK路径:"+new File(appPath).getAbsolutePath());
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
        if(!TextUtils.isEmpty(appActivity)){
            capabilities.setCapability("appActivity", appActivity);
        }
        
        //设置收到下一条命令的超时时间,超时appium会自动关闭session ,默认60秒
        /**
         * 由于apk比较大，使用无线连接Android手机需要设置超长时间
         * 使用adb connect 连接客户端 传输包时间很长导致失败 90000ms
         */
        capabilities.setCapability("newCommandTimeout",120);

        //启动Driver
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @AfterClass
    public void afterClass(){
        //每一个用例完毕结束这次测试
        //driver.quit();
    }

    /**
     * 打印字符
     *
     * @param str 要打印的字符
     */
    public <T> void print(T str) {
        if (!TextUtils.isEmpty(String.valueOf(str))) {
            System.out.println(str);
        } else {
            System.out.println("输出了空字符");
        }
    }

}
 