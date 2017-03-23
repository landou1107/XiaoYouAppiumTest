package jiankun.com.xiaoyou.cases; 

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年3月3日 下午5:09:32 
 * 类说明 
 */
public class TestAnnotation {
	 @Test
	  public void testcase1() {
	      System.out.println("执行【Test1】");
	  }
	  @Test
	  public void testcase2() {
	      System.out.println("执行【Test2】");
	  }
//	  @BeforeMethod
//	  public void beforeMethod() {
//	      System.out.println("我是【beforeMethod】");
//	  }

//	  @AfterMethod
//	  public void afterMethod() {
//	      System.out.println("我是【afterMethod】");
//	  }

	  @BeforeClass
	  public void beforeClass() {
	      System.out.println("我是【BeforeClass】");
	  }

	  @AfterClass
	  public void afterClass() {
	      System.out.println("我是【AfterClass】");
	  }

	  @BeforeTest
	  public void beforeTest() {
	      System.out.println("我是【BeforeTest】");
	  }

	  @AfterTest
	  public void afterTest() {
	      System.out.println("我是【AfterTest】");
	  }

//	  @BeforeSuite
//	  public void beforeSuite() {
//	      System.out.println("我是【BeforeSuite】");
//	  }

//	  @AfterSuite
//	  public void afterSuite() {
//	      System.out.println("我是【AfterSuite】");
//	  }
}
 