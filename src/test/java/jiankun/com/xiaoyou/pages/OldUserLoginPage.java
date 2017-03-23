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
public class OldUserLoginPage extends PageAppium{

	//老用户登录编辑框id
	public final String OLD_LOGIN_EDIT_TEXT_ID = "et_input_account";
	//等待时间
	public final int OLD_LOGIN_TIMEOUT = 8;

    //引用父类的构造函数
    public OldUserLoginPage(AndroidDriver<WebElement> driver) {
    	super(driver);
    }

    /**
     * 
     * MethodsInfo:通过resource-id判断控件是否存在
     * 2017年2月17日 下午4:09:02
     * @return
     */
    public boolean isIdElement(){
//		waitAuto(OLD_LOGIN_TIMEOUT);
		return isIdElementExist(OLD_LOGIN_EDIT_TEXT_ID, OLD_LOGIN_TIMEOUT);
    	
    }
    
	/**
	 * 
	 * MethodsInfo:通过resource_id获取控件
	 * 2017年2月17日 下午3:44:16
	 * @return
	 */
	public AndroidElement getIdElement(){
//		waitAuto(OLD_LOGIN_TIMEOUT);
		return waitAutoById(OLD_LOGIN_EDIT_TEXT_ID,OLD_LOGIN_TIMEOUT);
	}
	
    
    //点击不更新
	  /**
	 * @param driver
	 * @param list2
	 * @return 
	 * @throws InterruptedException 
	 */
	public void V5_0_IndexPageNotUpdate(WebDriver driver, List<WebElement> list) throws InterruptedException {

		list = driver.findElements(By.className("android.widget.TextView"));
					  
		int size = list.size(); 
		System.out.println("TextView:"+size);

		for (int j = 0; j < size; j++) {
			System.out.println("第"
					+ j
					+ "次的TextView："
					+ driver.findElements(
							By.className("android.widget.TextView")).get(j)
							.getText());
		}

		System.out.println("点击-"
				+ driver.findElements(By.className("android.widget.TextView"))
						.get(2).getText());
		driver.findElements(By.className("android.widget.TextView")).get(2)
				.click();

		Thread.sleep(8000);
	}


}
