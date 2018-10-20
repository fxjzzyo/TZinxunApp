package io.jxf.free.ziliao.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import io.jxf.free.ziliao.data.source.DataManager;
import io.jxf.free.ziliao.data.source.local.DatabaseHelper;
import io.jxf.free.ziliao.di.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Application application();
    DataManager dataManager();
    DatabaseHelper databaseHelper();
}
