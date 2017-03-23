package jiankun.com.xiaoyou.cases;
 
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.http.util.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class zhiHu {
	
    public int port;
    public String udid;
    public String deviceName;
    public String platformVersion;
    private  AndroidDriver<WebElement>  driver;

////    @BeforeSuite
//    @Parameters({ "port", "udid" })
//    public void beforeSuite(int port, String udid) {
//        this.port = port;
//        this.udid = udid;
//    	System.out.println("1 port is " + port + ", udid is " + udid);
//    }
    
    @Parameters({ "port", "udid" })
    @BeforeClass
    public void setUp(int port, String udid) throws Exception {
        this.port = port;
        this.udid = udid;
//        this.platformVersion = platformVersion;
//        this.deviceName = deviceName;
    	System.out.println("2 port is " + port + ", udid is " + udid);
        
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "futureve-mobile-update-release-4.16.0(464).apk");
        
        //�����Զ�����ز���
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName",udid);
        capabilities.setCapability("platformVersion", "android");
        
        //设置UID
        if(!TextUtils.isEmpty(udid)){
        	capabilities.setCapability("udid", udid);
            System.out.println("******** udid:" + udid);
//        	capabilities.setCapability("deviceName", udid);
            System.out.println("******** prot:" + port);
        }
        
        //if no need install don't add this
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.zhihu.android");
        
        //support Chinese 
        capabilities.setCapability("unicodeKeyboard" ,"True");
        capabilities.setCapability("resetKeyboard", "True");
        
        //����app����������������
        capabilities.setCapability("noSign", "True");
        capabilities.setCapability("appActivity", ".app.ui.activity.MainActivity");//��������������adb logcat >d:/log.txt 
//        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        System.out.println("http://127.0.0.1:" + port + "/wd/hub");

        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
        System.out.println("@BeforeClass的driver: " + driver);
    }
 
    @AfterClass
    public void tearDown() throws Exception {
        System.out.println("@AfterClass 的driver: " + driver);
        driver.quit();
    }
 
    @Test
    public void Login(){
        //find login button
    	System.out.println("已经启动知乎客户端");
    	
        WebElement loginButton1 = driver.findElement(By.id("com.zhihu.android:id/login_btn"));
        loginButton1.click();
       
        //wait for 20s
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       
//        //find login userName and password editText 
//        WebElement userName = driver.findElement(By.id("com.zhihu.android:id/username"));
//        userName.sendKeys("715211791@qq.com");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        WebElement passWord = driver.findElement(By.id("com.zhihu.android:id/password"));
//        passWord.sendKeys("sjy1107");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//       
//        //find ok button byName
//        WebElement loginButton2 = driver.findElement(By.id("com.zhihu.android:id/btn_progress"));
//        loginButton2.click();
//        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
//       
//        //find keyword ��ҳ and verify it is display
////        Assert.assertTrue(driver.findElement(By.name("��ҳ")).isDisplayed());
//        boolean isLogin;
//        isLogin = driver.findElement(By.id("com.zhihu.android:id/action_search")).isDisplayed();
//        Assert.assertTrue(isLogin);
//        if(isLogin){
//            System.out.println("登录成功");
//        }else{
//            System.out.println("֪登录失败");
//        }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
