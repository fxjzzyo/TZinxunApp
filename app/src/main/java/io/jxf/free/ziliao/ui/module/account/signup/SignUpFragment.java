package io.jxf.free.ziliao.ui.module.account.signup;

import android.content.Context;

import io.jxf.free.ziliao.R;
import io.jxf.free.ziliao.ui.base.BaseFragment;

public class SignUpFragment extends io.jxf.free.ziliao.ui.base.BaseFragment<SignUpPresenter> implements SignUpContract.View {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentComponent.inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_sign_up;
    }

    @Override
    public void onFragmentViewCreated() {
        super.onFragmentViewCreated();

        if (presenter == null) {
            return;
        }
        presenter.attachView(this);
    }
}
