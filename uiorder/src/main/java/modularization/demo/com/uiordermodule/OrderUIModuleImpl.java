package modularization.demo.com.uiordermodule;

import android.content.Context;
import android.content.Intent;

import modularization.demo.com.uiplatform.order.OrderUIModule;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class OrderUIModuleImpl implements OrderUIModule {

    @Override
    public void showOrderActivity(Context context) {
        Intent intent = new Intent(context, OrderActivity.class);
        context.startActivity(intent);
    }
}
