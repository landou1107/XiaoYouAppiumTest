package jiankun.com.xiaoyou.operation;

import io.appium.java_client.android.AndroidDriver;
import jiankun.com.xiaoyou.base.OperateAppium;
import jiankun.com.xiaoyou.pages.NewUserLoginPage;
import jiankun.com.xiaoyou.pages.OldUserLoginPage;
import jiankun.com.xiaoyou.pages.V5_0_IndexPage;

import org.openqa.selenium.WebElement;

/**
 * Title: IndexPageBusiness
 * Description: APP��ҳҵ��
 * Company: XiaoYou
 * @author lishuang
 * @date 2016��12��23�� ����4:08:46
 */

public class IndexPageOperate extends OperateAppium{
	
	private V5_0_IndexPage v5_0_IndexPage;
	private OldUserLoginPage oldUserLoginPage;
	private NewUserLoginPage newUserLoginPage;
	
	public IndexPageOperate(AndroidDriver<WebElement> androidDriver){
		super(androidDriver);
		v5_0_IndexPage = new V5_0_IndexPage(androidDriver);
		oldUserLoginPage = new OldUserLoginPage(androidDriver);
		newUserLoginPage = new NewUserLoginPage(androidDriver);
	}
	
	/**
	 * 首页界面稍后更新处理
	 * @return 是否成功进入首页到
	 */
	public boolean indexNoUpdate(){
		//是否在校友首页界面
		if(getCurrActivity().equals(v5_0_IndexPage.getActivityText())){
			System.out.println("进入【首页界面】");
		}else{
			System.out.println("进入【未进入首页界面】");
			return false;
		}
		//是否弹出更新提示
//		if(v5_0_IndexPage.isPageTextExist()){		
		if(v5_0_IndexPage.getUpdateElements().getText().equals("稍后更新")){
			System.out.println("首页界面存在【更新提示】,点击【稍后更新】");
			clickView(v5_0_IndexPage.getUpdateElements());
            return true;
		}
		else if(v5_0_IndexPage.isOldLoginButton()){
			System.out.println("首页界面未弹出更新提示，已经找到【老用户登录按钮】");
            return true;
		}
//		return v5_0_IndexPage.getIndexflag();	
		return false;
	}
	
	/**
	 * 首页界面点击老用户登录按钮
	 * MethodsInfo:
	 * 2017年2月17日 下午3:37:18
	 * @return
	 */
	public boolean verifyClickOldLoginButton(){
		if(v5_0_IndexPage.isOldLoginButton()){
			clickView(v5_0_IndexPage.getIndexOldUserButton());
			System.out.println("已经点击【老用户登录按钮】");
//			sleep(10000);
			
			System.out.println("已经获取账号编辑框文本：" + "【" + oldUserLoginPage.getIdElement().getText() + "】");

			//判断是否进入老用户登录界面
			if(oldUserLoginPage.isIdElement()){
				System.out.println("已经进入老用户登录界面");
				back();
			}
			//点击返回到首页
			System.out.println("已经从老用户登录界面，返回首页界面");
//			sleep(5000);
            return true;
		}
		return false;	
	}
	
	
	public boolean verifyClickNewLoginButton(){
		if(v5_0_IndexPage.isNewLoginButton()){
			clickView(v5_0_IndexPage.getIndexNewUserButton());
			System.out.println("已经点击【我是新用户按钮】");
			//是否进入了新用户注册界面
			if(newUserLoginPage.getIdElement().getText().equals("首次登录")){
//				if(newUserLoginPage.isIdElement()){
					System.out.println("已经进入【新用户注册】界面-" + newUserLoginPage.getIdElement().getText());
					back();
					System.out.println("已经从【新用户注册】界面，返回首页界面");
		            return true;
			}else{
				System.out.println("进入【新用户注册】界面，没找到相关信息");
			}
		}
		return false;			
	}
	
//	/**
//	 * MethodsInfo:app��ҳҵ�������Ϣ
//	 * 2016��12��26�� ����11:00:10
//	 * @param driver
//	 * @param element
//	 * @throws Exception
//	 */
//	public void FindElementsByClassName(AndroidDriver<WebElement> driver, String element)
//			throws Exception {				
//		FindElements.FindElementsByClassName(driver, element);
//	}
//	
//	/**
//	 * MethodsInfo:app��ҳҵ�������Ϣ
//	 * 2016��12��26�� ����11:00:10
//	 * @param driver
//	 * @param element
//	 * @throws Exception
//	 */
//	public void FindElementsByClassName(WebDriver driver, String element)
//			throws Exception {				
//		FindElements.FindElementsByClassName(driver, element);
//	}
//	
//	/**
//	 * MethodsInfo:app��ҳҵ�񲻸���ϵͳ
//	 * 2016��12��23�� ����4:48:54
//	 * @param driver
//	 * @param element
//	 * @param index
//	 * @param actual
//	 * @throws Exception
//	 */
//	public void noUpDateBusiness(AndroidDriver<WebElement> driver, String element, int index, String actual)
//			throws Exception {
//		
//		OnClickElements.OnClikcElements(driver, element, index, actual);
//	}
//	
//	/**
//	 * MethodsInfo:app��ҳҵ�񲻸���ϵͳ
//	 * 2016��12��23�� ����4:48:54
//	 * @param driver
//	 * @param element
//	 * @param index
//	 * @param actual
//	 * @throws Exception
//	 */
//	public void noUpDateBusiness(WebDriver driver, String element, int index, String actual)
//			throws Exception {
//		
//		OnClickElements.OnClikcElements(driver, element, index, actual);
//	}
//	
//	/**
//	 * MethodsInfo:app��ҳѡ�����û�
//	 * 2016��12��26�� ����4:47:47
//	 * @param driver
//	 * @param element
//	 * @param actual
//	 * @throws Exception
//	 */
//	public void selectOldUser(AndroidDriver<WebElement> driver, String element, String actual) throws Exception{
//		OnClickElements.OnClikcElements(driver, element, actual);
//	}
//	
//	/**
//	 * MethodsInfo:app��ҳѡ�����û�
//	 * 2016��12��26�� ����4:47:47
//	 * @param driver
//	 * @param element
//	 * @param actual
//	 * @throws Exception
//	 */
//	public void selectOldUser(WebDriver driver, String element, String actual) throws Exception{
//		OnClickElements.OnClikcElements(driver, element, actual);
//	}
}
