package io.jxf.free.ziliao.ui.module.main.project;

import java.util.List;

import io.jxf.free.ziliao.data.model.Category;
import io.jxf.free.ziliao.ui.base.BaseContract;

public interface ProjectContract {
    interface View extends BaseContract.View {
        void createTabs(List<Category> categories);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getProjectCategories();
    }
}
