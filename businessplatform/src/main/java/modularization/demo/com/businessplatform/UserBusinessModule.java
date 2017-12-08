package modularization.demo.com.businessplatform;

import modularization.demo.com.businessplatform.module.UserBean;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public interface UserBusinessModule {

    void login(String userName, String pwd, BusinessCallBack<UserBean> callBack);


    interface BusinessCallBack<T>{

        void onSuccess(T obj);

        void onFailure();


    }


}
