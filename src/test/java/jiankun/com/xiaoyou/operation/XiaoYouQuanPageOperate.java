//package jiankun.com.xiaoyou.operation;
//
//import io.appium.java_client.android.AndroidDriver;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import com.app.log4j.Log;
//import com.appium.elements.FindElements;
//import com.appium.elements.OnClickElements;
//
//
//	/**
//	 * Title: XiaoYouQuanPageBusiness
//	 * Description:У��Ȧҵ�� 
//	 * Company: XiaoYou
//	 * @author lishuang
//	 * @date 2016��12��28�� ����1:35:07
//	 */
//	public class XiaoYouQuanPageOperate {
//		
//		public XiaoYouQuanPageOperate() {
//		}
//
//	/**
//	 * MethodsInfo:����LBSȨ��
//	 * 2016��12��28�� ����2:41:44
//	 * @param driver
//	 * @param element
//	 * @param actual
//	 * @throws Exception
//	 */
//	public void CapsOffLbs(AndroidDriver<WebElement> driver, String element, String actual)
//			throws Exception {
//		int timeOut = 60;
//		if(FindElements.isElementPresent(driver, element, timeOut)){
//			OnClickElements.OnClikcElements(driver, element, actual);
//		}else{
//			Log.logError("����LBSȨ��ʧ��");
//		}
//	}
//}
