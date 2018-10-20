package io.jxf.free.ziliao.ui.module.main.mine;

import javax.inject.Inject;

import io.jxf.free.ziliao.data.model.User;
import io.jxf.free.ziliao.data.source.DataManager;
import io.jxf.free.ziliao.ui.base.BasePresenter;

public class MinePresenter extends BasePresenter<MineContract.View>
        implements MineContract.Presenter {
    private DataManager dataManager;

    @Inject
    public MinePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public boolean isLogin() {
        return dataManager.isLogin();
    }

    @Override
    public User getLoggedInUser() {
        return dataManager.getLoggedInUser();
    }

    @Override
    public void logout() {
        dataManager.deleteLoggedInUser();
    }
}
