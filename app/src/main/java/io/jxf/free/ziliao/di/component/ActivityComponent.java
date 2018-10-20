package io.jxf.free.ziliao.di.component;

import dagger.Component;
import io.jxf.free.ziliao.di.module.ActivityModule;
import io.jxf.free.ziliao.di.scope.ActivityScope;
import io.jxf.free.ziliao.ui.module.main.MainActivity;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
