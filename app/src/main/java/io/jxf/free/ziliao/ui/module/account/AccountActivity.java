package io.jxf.free.ziliao.ui.module.account;

import android.os.Bundle;
import android.support.annotation.Nullable;

import io.jxf.free.ziliao.R;
import io.jxf.free.ziliao.ui.base.BaseActivity;
import io.jxf.free.ziliao.ui.module.account.signin.SignInFragment;

public class AccountActivity extends BaseActivity {
    @Override
    public int getLayout() {
        return R.layout.activity_account;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, new SignInFragment())
                .commit();
    }
}
