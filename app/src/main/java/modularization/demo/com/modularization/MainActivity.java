package modularization.demo.com.modularization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import modularization.demo.com.uiplatform.login.LoginUiModuleUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void login(View view){
        LoginUiModuleUtil.openLoginActiviy(this);
    }
}
