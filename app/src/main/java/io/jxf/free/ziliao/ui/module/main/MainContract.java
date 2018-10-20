package io.jxf.free.ziliao.ui.module.main;

import io.jxf.free.ziliao.ui.base.BaseContract;

public interface MainContract {
    interface View extends BaseContract.View {}

    interface Presenter extends BaseContract.Presenter<View> {}
}
