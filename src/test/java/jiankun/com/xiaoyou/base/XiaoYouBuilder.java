package jiankun.com.xiaoyou.base; 


/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年2月15日 下午3:39:45 
 * 类说明 构建器，在每个用例上都可以很方便设置app的属性
 */
public class XiaoYouBuilder {
    String deviceName = XiaoYouBaseAppium.deviceName;
    String platformVersion = XiaoYouBaseAppium.platformVersion;
    String path = System.getProperty("user.dir");
    String appPath = XiaoYouBaseAppium.appPath;
    String appPackage = XiaoYouBaseAppium.appPackage;
    String noReset = XiaoYouBaseAppium.noReset;
    String noSign = XiaoYouBaseAppium.noSign;
    String unicodeKeyboard = XiaoYouBaseAppium.unicodeKeyboard;
    String resetKeyboard = XiaoYouBaseAppium.resetKeyboard;
    String appActivity = XiaoYouBaseAppium.appActivity;
    int newCommandTimeout = XiaoYouBaseAppium.newCommandTimeout;
	String udid = XiaoYouBaseAppium.udid;
	int port = XiaoYouBaseAppium.port;
	String browserName = XiaoYouBaseAppium.browserName;

    public XiaoYouBuilder setAppPath(String appPath) {
        this.appPath = path + appPath;
        return this;
    }

    public XiaoYouBuilder setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    public XiaoYouBuilder setPlatformVersion(String platformVersion) {
//    	System.out.println("属性步骤1-- XiaoYouBuilder类获取平台版本：" + platformVersion);
        this.platformVersion = platformVersion;
        return this;
    }

    public XiaoYouBuilder setApp(String appPath) {
        this.appPath = appPath;
        return this;
    }

    public XiaoYouBuilder setAppPackage(String appPackage) {
        this.appPackage = appPackage;
        return this;
    }

    public XiaoYouBuilder setNoReset(String noReset) {
        this.noReset = noReset;
        return this;
    }

    public XiaoYouBuilder setNoSign(String noSign) {
        this.noSign = noSign;
        return this;
    }

    public XiaoYouBuilder setUnicodeKeyboard(String unicodeKeyboard) {
        this.unicodeKeyboard = unicodeKeyboard;
        return this;
    }


    public XiaoYouBuilder setResetKeyboard(String resetKeyboard) {
        this.resetKeyboard = resetKeyboard;
        return this;
    }

    public XiaoYouBuilder setAppActivity(String appActivity) {
        this.appActivity = appActivity;
        return this;
    }
    
    public XiaoYouBuilder setNewCommandTimeout(int newCommandTimeout){
    	this.newCommandTimeout = newCommandTimeout;
    	return this;
    }
    
    public XiaoYouBuilder setUdid(String udid){
//    	System.out.println("属性步骤1-- XiaoYouBuilder界面获取设备唯一号：" + udid);
    	this.udid = udid;
    	return this;
    }
    
    public XiaoYouBuilder setPort(int port){
//    	System.out.println("属性步骤1-- XiaoYouBuilder界面获取端口：" + port);
    	this.port = port;
    	return this;
    }
    
    public XiaoYouBuilder setBrowserName(String browserName){
    	this.browserName = browserName;
    	return this;
    }
    
    public XiaoYouBaseAppium build() {
        return new XiaoYouBaseAppium(this);
    }
}