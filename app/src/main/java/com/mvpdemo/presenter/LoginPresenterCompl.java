package com.mvpdemo.presenter;

import com.mvpdemo.model.User;
import com.mvpdemo.view.ILoginView;

/**
 * 创建者     yangyanfei
 * 创建时间   2017/4/6 0006 21:30
 * 作用	      ${TODO}
 * <p/>
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class LoginPresenterCompl implements ILoginPresenter{
    private ILoginView loginView;
    private User       user;

    public LoginPresenterCompl(ILoginView view) {
        loginView = view;
        user=new User("张三","123456");
    }

    @Override
    public void clear() {
        loginView.onClearText();
    }

    @Override
    public void doLogin(String name, String password) {
        boolean result=false;
        int code=0;
        if(name.equals(user.getName())&&password.equals(user.getPassword())){
            result=true;
            code=1;
        }else{
            result=false;
            code=0;
        }
        loginView.onLoginResult(result,code);
    }
}
