package io.jxf.free.ziliao.ui.module.main.project.tabpage;

import java.util.List;

import io.jxf.free.ziliao.data.model.Article;
import io.jxf.free.ziliao.ui.base.BaseContract;

public interface ProjectTabPageContract {
    interface View extends BaseContract.View {
        void showProjectArticles(int page, List<Article> data);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getProjectArticles(int page, int cid);
    }
}
