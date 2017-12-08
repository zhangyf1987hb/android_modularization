package modularization.demo.com.businessplatform;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class BusinessModelFactory {

    public static UserBusinessModule creatOrderUiModule(){
        return (UserBusinessModule)loadModule("modularization.demo.com.userbusiness.UserBusinessModuleImpl");
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
