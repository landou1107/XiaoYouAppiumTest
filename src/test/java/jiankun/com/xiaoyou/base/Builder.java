package jiankun.com.xiaoyou.base; 
/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年2月15日 下午3:39:45 
 * 类说明 构建器，在每个用例上都可以很方便设置app的属性
 */
public class Builder {
    String deviceName = BaseAppium.deviceName;
    String platformVersion = BaseAppium.platformVersion;
    String path = System.getProperty("user.dir");
    String appPath = BaseAppium.appPath;
    String appPackage = BaseAppium.appPackage;
    String noReset = BaseAppium.noReset;
    String noSign = BaseAppium.noSign;
    String unicodeKeyboard = BaseAppium.unicodeKeyboard;
    String resetKeyboard = BaseAppium.resetKeyboard;
    String appActivity = BaseAppium.appActivity;
    int newCommandTimeout = BaseAppium.newCommandTimeout;

    public Builder setAppPath(String appPath) {
        this.appPath = path + appPath;
        return this;
    }

    public Builder setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        return this;
    }

    public Builder setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
        return this;
    }

    public Builder setApp(String appPath) {
        this.appPath = appPath;
        return this;
    }

    public Builder setAppPackage(String appPackage) {
        this.appPackage = appPackage;
        return this;
    }

    public Builder setNoReset(String noReset) {
        this.noReset = noReset;
        return this;
    }

    public Builder setNoSign(String noSign) {
        this.noSign = noSign;
        return this;
    }

    public Builder setUnicodeKeyboard(String unicodeKeyboard) {
        this.unicodeKeyboard = unicodeKeyboard;
        return this;
    }


    public Builder setResetKeyboard(String resetKeyboard) {
        this.resetKeyboard = resetKeyboard;
        return this;
    }

    public Builder setAppActivity(String appActivity) {
        this.appActivity = appActivity;
        return this;
    }
    
    public Builder setNewCommandTimeout(int newCommandTimeout){
    	this.newCommandTimeout = newCommandTimeout;
    	return this;
    }

    public BaseAppium build() {
        return new BaseAppium(this);
    }
}