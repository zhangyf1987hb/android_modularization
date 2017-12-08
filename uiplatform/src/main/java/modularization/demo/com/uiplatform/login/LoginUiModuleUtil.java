package modularization.demo.com.uiplatform.login;

import android.content.Context;

import modularization.demo.com.uiplatform.ModulesFactory;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class LoginUiModuleUtil {

    public static void openLoginActiviy(Context context){
        ModulesFactory.creatLoginUiModule().openLoginActivity(context);
    }

}
