package io.jxf.free.ziliao.ui.module.browser;

import io.jxf.free.ziliao.ui.base.BaseContract;

public interface BrowserContract {
    interface View extends BaseContract.View {
        void openShareDialog();
        void copyTextToClipboard();
        void openBrowser();
    }

    interface Presenter extends BaseContract.Presenter<View> {}
}
