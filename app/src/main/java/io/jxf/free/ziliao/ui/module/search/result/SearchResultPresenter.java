package io.jxf.free.ziliao.ui.module.search.result;

import java.util.List;

import javax.inject.Inject;

import io.jxf.free.ziliao.data.model.Article;
import io.jxf.free.ziliao.data.model.ArticleListResponse;
import io.jxf.free.ziliao.data.model.BaseResponse;
import io.jxf.free.ziliao.data.source.DataManager;
import io.jxf.free.ziliao.ui.base.BasePresenter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class SearchResultPresenter extends BasePresenter<SearchResultContract.View>
        implements SearchResultContract.Presenter {
    private DataManager dataManager;
    private Disposable disposable;

    @Inject
    public SearchResultPresenter(DataManager dataManager) {
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
    public void saveSearchHistory(String keyword) {
        dataManager.saveSearchHistory(keyword);
    }

    @Override
    public void search(final int page, String keyword) {
        Observable<BaseResponse<ArticleListResponse>> observable =
                dataManager.searchArticles(page, keyword);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<BaseResponse<ArticleListResponse>, List<Article>>() {
                    @Override
                    public List<Article> apply(@NonNull BaseResponse<ArticleListResponse> response)
                            throws Exception {
                        return response.getData().getDatas();
                    }
                }).subscribeWith(new Observer<List<Article>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(@NonNull List<Article> articles) {
                getView().showSearchResult(page, articles);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
