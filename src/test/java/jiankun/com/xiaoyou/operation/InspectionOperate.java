package jiankun.com.xiaoyou.operation;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import jiankun.com.xiaoyou.base.OperateAppium;
import jiankun.com.xiaoyou.pages.InspectionPage;

/**
 * Created by LITP on 2016/9/30.
 */

public class InspectionOperate extends OperateAppium {


    private InspectionPage page;


    public InspectionOperate(AndroidDriver<WebElement> androidDriver) {
        super(androidDriver);
        page = new InspectionPage(androidDriver);
    }



    public boolean intoInspection(){

        if (clickView(page.getInspectionElement())) {
            if(clickView(page.getSearchElement())){
                return true;
            }
        }
        return false;
    }



}
