package jiankun.com.xiaoyou.operation; 

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import jiankun.com.xiaoyou.base.OperateAppium;
import jiankun.com.xiaoyou.pages.LoginPage;
import jiankun.com.xiaoyou.pages.OldUserLoginPage;

/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年2月16日 上午11:25:12 
 * 类说明 登录逻辑处理
 */

public class OldUserPageOperate extends OperateAppium {

    private OldUserLoginPage oldLoginPage;

    AndroidDriver<WebElement> driver;

    public OldUserPageOperate(AndroidDriver<WebElement> driver){
        super(driver);
        oldLoginPage = new OldUserLoginPage(driver);
        this.driver = driver;
    }
    
    public boolean login(){
    	if(oldLoginPage.isIdElement()){
    		System.out.println("已找到【账号编辑框】控件");
    		return true;
    	}

		return false;
    	
    }
    

//    /**
//     * 传递帐号密码
//     * @param name 帐号
//     * @param pass 密码
//     * @return 是否成功登录到主页
//     */
//    public boolean login(String name,String pass){
//
//        sleep(1000);
//        //是否在欢迎页面
//        if(getCurrActivity().equals(oldLoginPage.getAboutText())){
//            print("关于界面");
//            for(int i=0; i<4; i++){
//                swipeToLeft(300);
//                sleep(500);
//            }
//            clickView(oldLoginPage.getAboutButton());
//            //点击欢迎页面的登录
//            clickView(oldLoginPage.getWelcmoeLoginButton());
//
//            //在欢迎界面
//        }else if(oldLoginPage.isWelcome()){
//            print("点击登录");
//            clickView(oldLoginPage.getWelcmoeLoginButton());
//        }else if(oldLoginPage.getLoginButton() == null){//自动登录了就输出成功，返回
//            print("自动登录了，返回,执行注销");
//            return true;
//
//        }
//
//        //输入内容
//        inputManyText(name,pass);
//
//        //点击登录
//        clickView(oldLoginPage.getLoginButton());
//
//        //等待到首页
//        waitAutoById(oldLoginPage.getIndexElementId());
//
//        //如果在登录完的界面没有第一屏就点击一下中间，关闭引导屏
//        if(oldLoginPage.getIndexElement() == null &&
//                getCurrActivity().equals(oldLoginPage.getIndexActivity())){
//            press();
//        }
//        //返回是否成功到主页
//        return oldLoginPage.getIndexflag();
//    }
}
 