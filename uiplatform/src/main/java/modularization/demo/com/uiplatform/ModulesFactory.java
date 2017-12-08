package modularization.demo.com.uiplatform;

import modularization.demo.com.uiplatform.login.LoginUIModule;
import modularization.demo.com.uiplatform.order.OrderUIModule;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class ModulesFactory {


    public static LoginUIModule creatLoginUiModule(){
        return (LoginUIModule)loadModule("modularization.demo.com.userlib.UiLoginModuleImpl");
    }

    public static OrderUIModule creatOrderUiModule(){
        return (OrderUIModule)loadModule("modularization.demo.com.uiordermodule.OrderUIModuleImpl");
    }


    private static Object loadModule(String className){
        try {
            return Class.forName(className).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
