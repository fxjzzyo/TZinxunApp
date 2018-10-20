package io.jxf.free.ziliao.ui.module.search.result;

import java.util.List;

import io.jxf.free.ziliao.data.model.Article;
import io.jxf.free.ziliao.ui.base.BaseContract;

public interface SearchResultContract {
    interface View extends BaseContract.View {
        void showSearchResult(int page, List<Article> data);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void saveSearchHistory(String keyword);
        void search(int page, String keyword);
    }
}
