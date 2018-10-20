package io.jxf.free.ziliao.ui.module.account.signin;

import io.jxf.free.ziliao.ui.base.BaseContract;

public interface SignInContract {
    interface View extends BaseContract.View {
        void usernameEmpty(boolean isEmpty);
        void passwordEmpty(boolean isEmpty);
        void loginSuccessful(String username);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void signIn(String username, String password);
    }
}
