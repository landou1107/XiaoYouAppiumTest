package jiankun.com.xiaoyou.utils; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/** 
 * @author 作者 : lishuang 
 * @version 创建时间：2017年2月21日 下午3:04:19 
 * 类说明 根据手机启动服务(启动服务，手机插好之后，run这个文件即可在module下自动生成testng文件)
 */
public class StartServers {


    public static void main(String[] args) {


        //执行的用例
        List<String> classList = new ArrayList<>();


        if(args.length > 0){
            //运行时候传递了参数进来
            classList.addAll(Arrays.asList(args));
        }else{

            //手动添加测试用例XiaoYouIndex
            classList.add(FileCtrl.getPackageName()+ "XiaoYouIndex");
        }


        try {
            if(startServers(classList)){
                System.out.println("开启服务完成");
            }else{
                System.out.println("开启服务失败，要执行的命令行为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("开启服务失败"+e.getMessage());
        }

    }




    /**
     * 启动服务
     * @return 返回时候执行命令成功
     * @param className 用例名称  XiaoYouIndex
     * @throws Exception 开启过程中的异常
     */
    public static boolean startServers(List<String> className) throws Exception{
        List<String> startCommandList = ServerCtrl.createServerCommand();
        boolean flag ;

        if(startCommandList.size() > 0){
            for(String str:startCommandList){
                //执行cmd命令
                if(CmdCtrl.getInstance().execCmdTrue(str)){
                    System.out.println("开启服务成功:" + str);
                }else{
                    System.out.println("开启服务失败:" + str);
                }
            }
            flag = true;
            //创建testbg文件，0就是全部设备
            XmlUtils.createTestNgXml(0,className);
        }else{
            flag = false;
        }
        return flag;
    }

}
 