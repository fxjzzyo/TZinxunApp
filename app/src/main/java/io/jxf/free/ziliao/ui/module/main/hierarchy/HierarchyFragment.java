package io.jxf.free.ziliao.ui.module.main.hierarchy;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;

import java.util.List;

import io.jxf.free.ziliao.R;
import io.jxf.free.ziliao.data.model.Category;
import io.jxf.free.ziliao.ui.adapter.HierarchyAdapter;
import io.jxf.free.ziliao.ui.base.BaseListFragment;

public class HierarchyFragment extends BaseListFragment<HierarchyPresenter>
        implements HierarchyContract.View {

    private HierarchyAdapter hierarchyAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentComponent.inject(this);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_hierarchy;
    }

    @Override
    public void onFragmentViewCreated() {
        super.onFragmentViewCreated();

        if (presenter == null) {
            return;
        }
        presenter.attachView(this);

        hierarchyAdapter = new HierarchyAdapter();
        recyclerView.setAdapter(hierarchyAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // reload data
                presenter.getHierarchyCategories();
            }
        });
        swipeRefreshLayout.setRefreshing(true);
        presenter.getHierarchyCategories();
    }

    @Override
    public void showHierarchyCategories(List<Category> data) {
        swipeRefreshLayout.setRefreshing(false);
        hierarchyAdapter.setData(data);
    }
}
