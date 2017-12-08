package modularization.demo.com.userbusiness;

import modularization.demo.com.businessplatform.UserBusinessModule;
import modularization.demo.com.businessplatform.module.UserBean;
import modularization.demo.com.utillog.LogUtils;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class UserBusinessModuleImpl implements UserBusinessModule {

    @Override
    public void login(String userName, String pwd, BusinessCallBack<UserBean> callBack) {
        UserBean userBean = new UserBean();
        userBean.setId("123");
        userBean.setName("zhangyf");
        callBack.onSuccess(userBean);
        LogUtils.i(LogUtils.TAG, "登陆成功");
    }
}
