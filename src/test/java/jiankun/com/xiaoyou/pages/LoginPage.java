package jiankun.com.xiaoyou.pages; 

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.WebElement;

import jiankun.com.xiaoyou.base.PageAppium;

/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年2月16日 上午11:14:53 
 * 类说明 ui界面类，界面在这里处理（继承PageAppium，实现登录的界面的控件获取和存放id值）
 */

public class LoginPage extends PageAppium {

    //登录界面的登录按钮
    public final String LOGIN_BUTTON_ID = "login_btn_login";
    //第一屏的登录按钮
    public final String WELCOME_LOGIN_BUTTON_ID = "welcome_login_btn";

    //成功登录到首页标识
    public final String INDEX_TEXT = "首页";

    //是否在关于屏标识
    public final String ABOUT_TEXT = "AboutActivity";

    //关于页面的按钮id
    public final String ABOUT_BUTTON_ID = "about_go_button";


    //帐号密码控件
    public final String NAME_PASS_ELEMENT = "android.widget.EditText";
    //首页控件
    public final String INDEX_ELEMENT = "tl_index";

    //登录完成之后的activity名字
    public final String INDEX_ACTIVITY_NAME = "IndexActivity";

    //引用父类的构造函数
    public LoginPage(AndroidDriver<WebElement> driver){
        super(driver);
    }


    /**
     * 是否在欢迎界面
     */
    public boolean isWelcome(){
        return isIdElementExist(WELCOME_LOGIN_BUTTON_ID,3,true);
    }


    /**
     * 获取关于界面的activity的名字
     * @return
     */
    public String getAboutText(){
        return ABOUT_TEXT;
    }


    /**
     * 获取关于界面的按钮
     * @return
     */
    public AndroidElement getAboutButton(){
        return waitAutoById(ABOUT_BUTTON_ID);
    }


    public AndroidElement getWelcmoeLoginButton(){
        return findById(WELCOME_LOGIN_BUTTON_ID);
    }


    public AndroidElement getLoginButton(){
        return findById(LOGIN_BUTTON_ID);
    }

    /**
     * 获取账号密码框的控件
     * @return
     */
    public List<WebElement> getNamePassElement(){
        return getManyElementByClassName(NAME_PASS_ELEMENT,2);
    }


    /**
     * 首页标识，是否成功登录
     * @return
     */
    public boolean getIndexflag(){
        /*AndroidElement element =  waitAutoByXp(LoginPage.INDEX_TEXT);
        return  element != null;*/

        AndroidElement element = findById(INDEX_ELEMENT);
        return element != null;
    }


    /**
     * 获取首页的一个元素，让操作程序等待
     */
    public String getIndexElementId(){
        return INDEX_ELEMENT;
    }

    /**
     * 获取首页的一个元素，让操作程序等待
     */
    public AndroidElement getIndexElement(){
        return findById(INDEX_ELEMENT);
    }


    public String getIndexActivity(){
        return INDEX_ACTIVITY_NAME;
    }

}
 