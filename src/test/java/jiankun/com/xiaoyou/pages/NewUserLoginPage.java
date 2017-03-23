package jiankun.com.xiaoyou.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import jiankun.com.xiaoyou.base.PageAppium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * aap加载首页
 * 功能点：升级提示，老用户登录，新用户登录
 */
public class NewUserLoginPage extends PageAppium{

	//新用户登录界面title-id
	public final String NEW_LOGIN_TEXT_VIEW_ID = "tv_title";
	//等待时间
	public final int NEW_LOGIN_TIMEOUT = 8;

    //引用父类的构造函数
    public NewUserLoginPage(AndroidDriver<WebElement> driver) {
    	super(driver);
    }

    /**
     * 
     * MethodsInfo:通过resource-id判断控件是否存在
     * 2017年2月17日 下午4:09:02
     * @return
     */
    public boolean isIdElement(){
		return isIdElementExist(NEW_LOGIN_TEXT_VIEW_ID, NEW_LOGIN_TIMEOUT);    	
    }
    
	/**
	 * 
	 * MethodsInfo:通过resource_id获取控件
	 * 2017年2月17日 下午3:44:16
	 * @return
	 */
	public AndroidElement getIdElement(){
		return waitAutoById(NEW_LOGIN_TEXT_VIEW_ID,NEW_LOGIN_TIMEOUT);
	}
}
