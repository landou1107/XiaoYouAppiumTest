package jiankun.com.xiaoyou.base;

import io.appium.java_client.android.AndroidDriver;
import org.apache.http.util.TextUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lishuang on 2017/2/28.
 */
public class GetDriver {
    public static AndroidDriver driver;

    //获取SungXing手机Driver对象的封装方法
    public static AndroidDriver getRemotedriver(String udid,String port) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");// 这句不是必须的
        capabilities.setCapability("deviceName", "deviceName");
        capabilities.setCapability("udid",udid);
        capabilities.setCapability("platformVersion", "4.3");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.xiaoyou.alumni");
        capabilities.setCapability("appActivity", ".ui.main.splash.SplashActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:"+port+"/wd/hub"),capabilities);
        return driver;
    }
}
