package modularization.demo.com.businessplatform;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class UserBusinessModuleUtil {

    public static void login(String userName, String pwd, UserBusinessModule.BusinessCallBack callBack){

        BusinessModelFactory.creatOrderUiModule().login(userName, pwd, callBack);

    }
}
