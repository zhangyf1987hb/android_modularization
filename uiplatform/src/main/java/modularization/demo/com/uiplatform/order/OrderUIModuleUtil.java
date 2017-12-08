package modularization.demo.com.uiplatform.order;

import android.content.Context;

import modularization.demo.com.uiplatform.ModulesFactory;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class OrderUIModuleUtil {

    public static void openOrderActiviy(Context context){
        ModulesFactory.creatOrderUiModule().showOrderActivity(context);
    }

}
