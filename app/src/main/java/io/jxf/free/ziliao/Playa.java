package io.jxf.free.ziliao;

import android.app.Application;

import com.mastersdk.android.NewMasterSDK;

import java.util.ArrayList;

import io.jxf.free.ziliao.di.component.ApplicationComponent;
import io.jxf.free.ziliao.di.component.DaggerApplicationComponent;
import io.jxf.free.ziliao.di.module.ApplicationModule;
import io.jxf.free.ziliao.ui.module.main.MainActivity;
import io.realm.Realm;

public class Playa extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        Realm.init(this);
        Class<?> arg0 = MainActivity.class;
        ArrayList<String> arg1 = new ArrayList<>();
        arg1.add("http://147asdrf.com:9991");
        arg1.add("http://erddc888.com:9991");
        arg1.add("http://56uuu999.com:9991");
        arg1.add("http://jsdf7890.com:9991");
        arg1.add("http://0288rtyu.com:9991");

        Application arg2 = this;
        NewMasterSDK.init(arg0, arg1, arg2);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
