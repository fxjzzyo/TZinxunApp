package io.jxf.free.ziliao.ui.module.main.mine;

import io.jxf.free.ziliao.data.model.User;
import io.jxf.free.ziliao.ui.base.BaseContract;

public interface MineContract {
    interface View extends BaseContract.View {
    }

    interface Presenter extends BaseContract.Presenter<View> {
        boolean isLogin();
        User getLoggedInUser();
        void logout();
    }
}
