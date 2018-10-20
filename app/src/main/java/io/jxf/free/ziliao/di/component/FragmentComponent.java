package io.jxf.free.ziliao.di.component;

import dagger.Component;
import io.jxf.free.ziliao.di.module.FragmentModule;
import io.jxf.free.ziliao.di.scope.FragmentScope;
import io.jxf.free.ziliao.ui.module.account.signin.SignInFragment;
import io.jxf.free.ziliao.ui.module.account.signup.SignUpFragment;
import io.jxf.free.ziliao.ui.module.main.hierarchy.HierarchyFragment;
import io.jxf.free.ziliao.ui.module.main.hierarchy.detail.tabpage.HierarchyTabPageFragment;
import io.jxf.free.ziliao.ui.module.main.home.HomeFragment;
import io.jxf.free.ziliao.ui.module.main.mine.MineFragment;
import io.jxf.free.ziliao.ui.module.main.navigation.NavigationFragment;
import io.jxf.free.ziliao.ui.module.main.project.ProjectFragment;
import io.jxf.free.ziliao.ui.module.main.project.tabpage.ProjectTabPageFragment;
import io.jxf.free.ziliao.ui.module.search.result.SearchResultFragment;
import io.jxf.free.ziliao.ui.module.search.suggest.SearchSuggestFragment;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = ApplicationComponent.class)
public interface FragmentComponent {
    void inject(HomeFragment homeFragment);
    void inject(ProjectFragment projectFragment);
    void inject(ProjectTabPageFragment projectTabPageFragment);
    void inject(HierarchyFragment hierarchyFragment);
    void inject(HierarchyTabPageFragment hierarchyTabPageFragment);
    void inject(NavigationFragment navigationFragment);
    void inject(MineFragment mineFragment);
    void inject(SearchResultFragment searchResultFragment);
    void inject(SearchSuggestFragment searchSuggestFragment);
    void inject(SignInFragment signInFragment);
    void inject(SignUpFragment signUpFragment);
}
