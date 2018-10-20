package io.jxf.free.ziliao.ui.module.main.hierarchy.detail.tabpage;

import java.util.List;

import io.jxf.free.ziliao.data.model.Article;
import io.jxf.free.ziliao.ui.base.BaseContract;

public interface HierarchyTabPageContract {
    interface View extends BaseContract.View {
        void showHierarchyArticles(int page, List<Article> data);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getHierarchyArticles(int page, int cid);
    }
}
