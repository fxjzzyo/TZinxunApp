package io.jxf.free.ziliao.ui.module.main.navigation;

import java.util.List;

import io.jxf.free.ziliao.data.model.NavCategory;
import io.jxf.free.ziliao.ui.base.BaseContract;

public interface NavigationContract {
    interface View extends BaseContract.View {
        void showNavCategories(List<NavCategory> categories);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getNavCategories();
    }
}
