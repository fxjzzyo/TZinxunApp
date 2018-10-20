package io.jxf.free.ziliao.ui.module.main.hierarchy;

import java.util.List;

import io.jxf.free.ziliao.data.model.Category;
import io.jxf.free.ziliao.ui.base.BaseContract;

public interface HierarchyContract {
    interface View extends BaseContract.View {
        void showHierarchyCategories(List<Category> data);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getHierarchyCategories();
    }
}
