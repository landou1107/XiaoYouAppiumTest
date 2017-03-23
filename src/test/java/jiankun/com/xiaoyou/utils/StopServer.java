package jiankun.com.xiaoyou.utils; 

import java.util.List;

/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年2月21日 下午5:48:24 
 * 类说明 杀掉appium服务控制类
 */
public class StopServer {


    public static void main(String[] args){
        stopServers();
    }


    /**
     * 停止 服务
     */
    public static void stopServers(){
        try {
            List<String> pidList = ServerCtrl.getStartPidList(ServerCtrl.getStartPortList());

            for(String pid:pidList){
                //傻吊进程
                ServerCtrl.killServerByPid(pid);
            }

            //删除设备文件
            //FileCtrl.delFile(FileCtrl.getModulePath()+"devicesInfo.xml");

        } catch (Exception e) {
            System.out.println("停止服务时候获取运行服务对应的进程pid失败" + e.getMessage());
            e.printStackTrace();
        }
    }

}
 