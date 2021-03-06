package io.jxf.free.ziliao.ui.module.main.hierarchy.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.google.gson.Gson;

import butterknife.BindView;
import io.jxf.free.ziliao.R;
import io.jxf.free.ziliao.data.model.Category;
import io.jxf.free.ziliao.ui.adapter.TabViewPagerAdapter;
import io.jxf.free.ziliao.ui.base.BaseActivity;
import io.jxf.free.ziliao.utils.TabViewPagerAdapterItem;

public class HierarchyDetailActivity extends BaseActivity<HierarchyDetailPresenter>
        implements HierarchyDetailContract.View {
    @BindView(R.id.tab_layout) TabLayout tabLayout;
    @BindView(R.id.view_pager) ViewPager viewPager;

    private Category hierarchyCategory;

    @Override
    public int getLayout() {
        return R.layout.activity_hierarchy_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String categoryJson = getIntent().getStringExtra("CATEGORY_JSON");
        hierarchyCategory = new Gson().fromJson(categoryJson, Category.class);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(hierarchyCategory.getName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        TabViewPagerAdapter tabViewPagerAdapter = new TabViewPagerAdapter(
                getSupportFragmentManager(),
                TabViewPagerAdapterItem.createHierarchyTabFragments(hierarchyCategory.getChildren())
        );
        viewPager.setAdapter(tabViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
