package com.edazh.gank3rd.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.edazh.gank3rd.R;
import com.edazh.gank3rd.api.NetworkState;
import com.edazh.gank3rd.api.Status;
import com.edazh.gank3rd.ui.adapter.GankPagedAdapter;
import com.edazh.gank3rd.viewmodel.GankViewModel;
import com.edazh.gank3rd.vo.Gank;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/**
 * author : edazh
 * email : edazh@qq.com
 * date : 2018/9/9 0009
 * project : Gank3rd
 * description:
 */
public class GankFragment extends Fragment {
    private RecyclerView mGankListView;
    private SwipeRefreshLayout mRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gank, container, false);
    }

    public static GankFragment newInstance() {

        Bundle args = new Bundle();

        GankFragment fragment = new GankFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mGankListView = view.findViewById(R.id.gank_list_view);
        mRefreshLayout = view.findViewById(R.id.refresh_layout);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final GankFragment gankFragment = this;
        final GankPagedAdapter adapter = new GankPagedAdapter(R.layout.item_gank);
        mGankListView.setAdapter(adapter);
        mGankListView.setItemAnimator(new DefaultItemAnimator());
        mGankListView.setHasFixedSize(true);
        final GankViewModel viewModel = ViewModelProviders.of(this).get(GankViewModel.class);
        viewModel.getGankList().observe(this, new Observer<PagedList<Gank>>() {
            @Override
            public void onChanged(PagedList<Gank> ganks) {
                adapter.submitList(ganks);
            }
        });

        viewModel.getNetWorState().observe(this, new Observer<NetworkState>() {
            @Override
            public void onChanged(NetworkState networkState) {
                Toast.makeText(gankFragment.getContext(), networkState.status.toString(), Toast.LENGTH_SHORT).show();
                mRefreshLayout.setRefreshing(networkState.status == Status.LOADING);
            }
        });
        mRefreshLayout.setColorSchemeResources(R.color.primary,R.color.accent);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.refresh();
            }
        });
    }


}
