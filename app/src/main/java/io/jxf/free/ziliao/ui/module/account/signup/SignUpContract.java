package io.jxf.free.ziliao.ui.module.account.signup;

import io.jxf.free.ziliao.ui.base.BaseContract;

public interface SignUpContract {
    interface View extends BaseContract.View {}

    interface Presenter extends BaseContract.Presenter<View> {
        void signUp(String username, String password, String repassword);
    }
}
