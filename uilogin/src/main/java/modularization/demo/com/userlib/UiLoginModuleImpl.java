package modularization.demo.com.userlib;

import android.content.Context;
import android.content.Intent;

import modularization.demo.com.uiplatform.login.LoginUIModule;
import modularization.demo.com.userlib.activity.LoginActivity;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class UiLoginModuleImpl implements LoginUIModule {

    @Override
    public void openLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);

    }
}
