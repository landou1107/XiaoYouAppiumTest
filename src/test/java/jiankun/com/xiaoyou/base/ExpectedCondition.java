package jiankun.com.xiaoyou.base; 

import io.appium.java_client.android.AndroidDriver;

import com.google.common.base.Function;

/**
 * Title: ExpectedCondition
 * Description: 
 * Company: XiaoYou
 * @author lishuang
 * @date 2017年2月15日 下午3:46:45
 */
public interface ExpectedCondition<T> extends Function<AndroidDriver, T> {}
//public interface ExpectedCondition<T> extends Function<AndroidElement, T> {
//
//}
 