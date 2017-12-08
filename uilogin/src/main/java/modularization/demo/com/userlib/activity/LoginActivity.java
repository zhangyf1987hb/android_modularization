package modularization.demo.com.userlib.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import modularization.demo.com.businessplatform.UserBusinessModule;
import modularization.demo.com.businessplatform.UserBusinessModuleUtil;
import modularization.demo.com.businessplatform.module.UserBean;
import modularization.demo.com.uiplatform.order.OrderUIModuleUtil;
import modularization.demo.com.userlib.R;

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
                Toast.makeText(LoginActivity.this, "login success : "+userBean.toString(), Toast.LENGTH_LONG).show();
                OrderUIModuleUtil.openOrderActiviy(LoginActivity.this);
            }

            @Override
            public void onFailure() {
                Toast.makeText(LoginActivity.this, "login failure", Toast.LENGTH_LONG).show();
            }
        });
    }
}
