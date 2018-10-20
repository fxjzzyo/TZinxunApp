package io.jxf.free.ziliao.ui.module.main.home;

import java.util.List;

import io.jxf.free.ziliao.data.model.Article;
import io.jxf.free.ziliao.data.model.Banner;
import io.jxf.free.ziliao.ui.base.BaseContract;

public interface HomeContract {
    interface View extends BaseContract.View {
        void showArticles(int page, List<Article> data);
        void showBannerData(List<Banner> data);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getArticles(int page);
        void getBannerData();
    }
}
