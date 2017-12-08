package modularization.demo.com.userlib.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import modularization.demo.com.businessplatform.UserBusinessModule;
import modularization.demo.com.businessplatform.UserBusinessModuleUtil;
import modularization.demo.com.businessplatform.module.UserBean;
import modularization.demo.com.uiplatform.order.OrderUIModuleUtil;
import modularization.demo.com.userlib.R;
import modularization.demo.com.utiltoast.CustomToast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        UserBusinessModuleUtil.login("name", "pwd", new UserBusinessModule.BusinessCallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {
                OrderUIModuleUtil.openOrderActiviy(LoginActivity.this);
                if (Build.VERSION.SDK_INT >= 23) {
                    if(!Settings.canDrawOverlays(LoginActivity.this)) {
                        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                        startActivity(intent);
                        return;
                    } else {
                        //Android6.0以上
                        CustomToast.makeText(LoginActivity.this, "login success : "+userBean.toString(), CustomToast.LENGTH_LONG).showError();
                    }
                } else {
                    CustomToast.makeText(LoginActivity.this, "login success : "+userBean.toString(), CustomToast.LENGTH_LONG).showError();
                }
            }

            @Override
            public void onFailure() {
            }
        });
    }
}
