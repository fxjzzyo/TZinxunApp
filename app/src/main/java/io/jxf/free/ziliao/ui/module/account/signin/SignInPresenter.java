package io.jxf.free.ziliao.ui.module.account.signin;

import javax.inject.Inject;

import io.jxf.free.ziliao.data.model.BaseResponse;
import io.jxf.free.ziliao.data.model.LoginResponse;
import io.jxf.free.ziliao.data.source.DataManager;
import io.jxf.free.ziliao.ui.base.BasePresenter;
import io.jxf.free.ziliao.utils.StringUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class SignInPresenter extends BasePresenter<SignInContract.View>
        implements SignInContract.Presenter {
    private DataManager dataManager;
    private Disposable disposable;

    @Inject
    public SignInPresenter(DataManager dataManager) {
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
    public void signIn(String username, String password) {
        boolean isUsernameEmpty = StringUtils.isEmpty(username);
        getView().usernameEmpty(isUsernameEmpty);
        if (isUsernameEmpty) {
            return;
        }
        boolean isPasswordEmpty = StringUtils.isEmpty(password);
        getView().passwordEmpty(isPasswordEmpty);
        if (isPasswordEmpty) {
            return;
        }
        Observable<BaseResponse<LoginResponse>> observable = dataManager.signin(username, password);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<BaseResponse<LoginResponse>, LoginResponse>() {
                    @Override
                    public LoginResponse apply(@NonNull BaseResponse<LoginResponse> response)
                            throws Exception {
                        return response.getData();
                    }
                }).subscribeWith(new Observer<LoginResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(@NonNull LoginResponse loginResponse) {
                dataManager.saveLoggedInUser(
                        loginResponse.getUsername(), loginResponse.getPassword(), true
                );
                getView().loginSuccessful(loginResponse.getUsername());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                getView().showError(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
