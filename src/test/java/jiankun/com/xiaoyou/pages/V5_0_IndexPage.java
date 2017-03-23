package jiankun.com.xiaoyou.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import jiankun.com.xiaoyou.base.PageAppium;

import org.openqa.selenium.WebElement;

/**
 * aap加载首页
 * 功能点：升级提示，老用户登录，新用户登录
 */
public class V5_0_IndexPage extends PageAppium{
	

	public V5_0_IndexPage(AndroidDriver<WebElement> androidDriver){
		super(androidDriver);
	}

	//首页稍后更新的文本
	private final String INDEX_FLAG_NOUPDATE_TEXT = "稍后更新";
	
	//首页更新提示信息控件
	private final String INDEX_FLAG_NOUPDATE_ELEMENT = "android.widget.TextView";
	
	//首页稍后更新的index
	private final int INDEX_FLAG_NOUPDATE_NUM = 2;
	
	//首页界面的老用户登录按钮
	private final String INDEX_OLD_BUTTON_ID = "login_btn_type_old";
	
	//首页界面的新用户登录按钮
	private final String INDEX_NEW_BUTTON_ID = "login_btn_type_first";
	
	//首页界面的Activity
	private final String INDEX_ACTIVITY_TEXT= "SplashActivity";

	//首页校友图标控件
	private final String INDEX_IMAGEVIEW_ID = "login_splash_greenlogo_show";
	
	//等待时间
	private final int INDEX_TIMEOUT = 8;
	
	/**
	 * 
	 * MethodsInfo:首页标识，是否成功进入
	 * 2017年2月17日 下午3:46:08
	 * @return
	 */
    public boolean getIndexflag(){
        /*AndroidElement element =  waitAutoByXp(LoginPage.INDEX_TEXT);
        return  element != null;*/

		waitAuto(INDEX_TIMEOUT);
        AndroidElement element = findById(INDEX_IMAGEVIEW_ID);
        return element != null;
    }
	
    /**
     * 
     * MethodsInfo:获取首页界面的activity的名字
     * 2017年2月17日 下午3:45:56
     * @return
     */
    public String getActivityText(){
        return INDEX_ACTIVITY_TEXT;
    }
	
    /**
     * 
     * MethodsInfo:是否存在更新提示
     * 2017年2月17日 下午3:45:42
     * @return
     */
	public boolean isUpdateInfo(){
//		waitAuto(INDEX_TIMEOUT);
		return isTextExist(INDEX_FLAG_NOUPDATE_TEXT);
	}

	/**
	 * 
	 * MethodsInfo:是否存在老用户登录按钮 
	 * 2017年2月17日 下午3:45:31
	 * @return
	 */
	public boolean isOldLoginButton(){
//		waitAuto(INDEX_TIMEOUT);
		return isIdElementExist(INDEX_OLD_BUTTON_ID, INDEX_TIMEOUT);
	}
	
	/**
	 * 
	 * MethodsInfo:是否存在新用户登录按钮 
	 * 2017年2月17日 下午3:45:21
	 * @return
	 */
	public boolean isNewLoginButton(){
//		waitAuto(INDEX_TIMEOUT);
		return isIdElementExist(INDEX_NEW_BUTTON_ID, INDEX_TIMEOUT, true);
	}
	
	/**
	 * MethodsInfo:判断页面是否存在该字符串
	 * 2017年2月21日 下午2:02:49
	 * @return
	 */
	public boolean isPageTextExist(){
//		waitAuto(INDEX_TIMEOUT);
		return isTextExist(INDEX_FLAG_NOUPDATE_TEXT);		
	}
	
	
	/**
	 * 
	 * MethodsInfo:获取稍后更新的控件
	 * 2017年2月17日 下午3:45:14
	 * @return
	 */
	public AndroidElement getUpdateElements(){
//		waitAuto(INDEX_TIMEOUT);
		waitAutoByClassName(INDEX_FLAG_NOUPDATE_ELEMENT,INDEX_TIMEOUT);
		return getListOneElementByClassName(INDEX_FLAG_NOUPDATE_ELEMENT, INDEX_FLAG_NOUPDATE_NUM);
	}
	
	/**
	 * 
	 * MethodsInfo:通过resource_id获取老用户控件
	 * 2017年2月17日 下午3:44:16
	 * @return
	 */
	public AndroidElement getIndexOldUserButton(){
//		waitAuto(INDEX_TIMEOUT);
		return waitAutoById(INDEX_OLD_BUTTON_ID,INDEX_TIMEOUT);
	}
	
	/**
	 * MethodsInfo:通过resource_id获取新用户控件
	 * 2017年2月20日 下午2:14:14
	 * @return
	 */
	public AndroidElement getIndexNewUserButton(){
//		waitAuto(INDEX_TIMEOUT);
		return waitAutoById(INDEX_NEW_BUTTON_ID,INDEX_TIMEOUT);		
	}
    


}
