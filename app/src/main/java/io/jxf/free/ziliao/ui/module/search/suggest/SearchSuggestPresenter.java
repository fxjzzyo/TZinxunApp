package io.jxf.free.ziliao.ui.module.search.suggest;

import java.util.List;

import javax.inject.Inject;

import io.jxf.free.ziliao.data.model.BaseResponse;
import io.jxf.free.ziliao.data.model.HotKey;
import io.jxf.free.ziliao.data.source.DataManager;
import io.jxf.free.ziliao.ui.base.BasePresenter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class SearchSuggestPresenter extends BasePresenter<SearchSuggestContract.View>
        implements SearchSuggestContract.Presenter {
    private DataManager dataManager;
    private Disposable disposable;

    @Inject
    public SearchSuggestPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void detachView() {
        super.detachView();
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override
    public void getHotKey() {
        Observable<BaseResponse<List<HotKey>>> observable = dataManager.getHotKey();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<BaseResponse<List<HotKey>>, List<HotKey>>() {
                    @Override
                    public List<HotKey> apply(@NonNull BaseResponse<List<HotKey>> response)
                            throws Exception {
                        return response.getData();
                    }
                }).subscribeWith(new Observer<List<HotKey>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(@NonNull List<HotKey> hotKeys) {
                getView().showHotKey(hotKeys);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getSearchHistory() {
        getView().showSearchHistory(dataManager.querySearchHistory());
    }

    @Override
    public void clearSearchHistory() {
        dataManager.deleteSearchHistory();
        getView().updateHistoryLayout();
    }
}
