package jiankun.com.xiaoyou.utils; 

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.filechooser.FileSystemView;

import io.appium.java_client.android.AndroidDriver;

/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年2月21日 下午2:53:35 
 * 类说明 文件的控制类,获取log，xml文件的路径
 */
public class FileCtrl {

    /**
     * 获取桌面路径
     * @return
     */
    private static String getDesktopPath(){
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com=fsv.getHomeDirectory();    //这便是读取桌面路径的方法了
        return com.getAbsolutePath();
    }


    /**
     * 获取当前项目路径
     * @return
     */
    public  static String getProjectPath(){
    	System.out.println("getProjectPath路径:" + System.getProperty("user.dir") + "XiaoYouAppiumTest/src/test/java/jiankun/com/xiaoyou/utils/");
        return System.getProperty("user.dir") + "XiaoYouAppiumTest/src/test/java/jiankun/com/xiaoyou/utils/";
    }


    public  static String getModulePath(){
//        return System.getProperty("user.dir") + "/XiaoYouAppiumTest/";
    	System.out.println("getModulePath路径:" + System.getProperty("user.dir"));
        return System.getProperty("user.dir");
    }

    public  static String getLogsPath(){
//        return getModulePath() + "/src/test/java/jiankun/com/xiaoyou/logs/";
    	System.out.println("getLogsPath路径:" + getModulePath() + "/logs/");
        return getModulePath() + "/logs/";
    }

    public  static String getPackageName(){
        return "jiankun.com.xiaoyou.cases.";
    }


    /**
     * 删除文件
     * @return
     */
    public static boolean delFile(String filePth){
        boolean flag = false;
        File file = new File(filePth);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            if(file.delete()){
                flag = true;
                System.out.println("删除文件成功:"+filePth);
            }else{
                System.out.println("删除文件失败:"+filePth);
            }
        }
        return flag;
    }

}
 