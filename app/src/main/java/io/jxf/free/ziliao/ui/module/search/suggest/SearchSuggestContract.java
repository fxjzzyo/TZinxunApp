package io.jxf.free.ziliao.ui.module.search.suggest;

import java.util.List;

import io.jxf.free.ziliao.data.model.HotKey;
import io.jxf.free.ziliao.data.model.SearchHistory;
import io.jxf.free.ziliao.ui.base.BaseContract;

public interface SearchSuggestContract {
    interface View extends BaseContract.View {
        void showHotKey(List<HotKey> data);
        void showSearchHistory(List<SearchHistory> data);
        void updateHistoryLayout();
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void getHotKey();
        void getSearchHistory();
        void clearSearchHistory();
    }
}
