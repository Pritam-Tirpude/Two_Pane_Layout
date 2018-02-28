package com.example.pritam.twopane;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Pritam on 2/8/2018.
 */

public class MainFragment extends Fragment implements MainFragmentAdapter.ListItemClickListener {

    public static final String KEY = "list";

    @BindView(R.id.recycler_view_fragment_main)
    RecyclerView mRecyclerViewMainFragment;

    private MainFragmentAdapter mMainFragmentAdapter;
    private List<Model> list;

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        mRecyclerViewMainFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewMainFragment.setHasFixedSize(true);
        RecyclerView.ItemDecoration dividerDecoration = new DividerItemDecoration(ContextCompat.getDrawable(
                getContext(), R.drawable.dvider_decor));
        mRecyclerViewMainFragment.addItemDecoration(dividerDecoration);

        list = itemsList();

        mMainFragmentAdapter = new MainFragmentAdapter(list, getContext());
        mMainFragmentAdapter.setListItemClickListener(list, this);
        mRecyclerViewMainFragment.setAdapter(mMainFragmentAdapter);

        return view;
    }

    private List<Model> itemsList() {
        List<Model> modelList = new ArrayList<>();
        modelList.add(new Model("Pritam"));
        modelList.add(new Model("Abhinav"));
        modelList.add(new Model("Saroj"));
        modelList.add(new Model("Sudarshan"));
        modelList.add(new Model("Shikha"));
        modelList.add(new Model("Prateek"));
        modelList.add(new Model("Abhijeet"));
        modelList.add(new Model("Poornima"));
        modelList.add(new Model("Vishal"));
        modelList.add(new Model("Vedant"));
        modelList.add(new Model("Harshit"));
        modelList.add(new Model("Amisha"));
        modelList.add(new Model("Neha"));
        modelList.add(new Model("Harsha"));
        modelList.add(new Model("Kiran"));
        modelList.add(new Model("Charu"));
        modelList.add(new Model("Lalita"));

        return modelList;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY, (ArrayList<Model>) list);
    }

    @Override
    public void OnListItemSelected(Model models) {
        Toast.makeText(getContext(), "Name : " + models.getmNameTitle(), Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        List<Model> list1 = new ArrayList<>();
        list1.add(models);
        bundle.putParcelableArrayList(KEY, (ArrayList<Model>) list1);

        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);

        if (getResources().getBoolean(R.bool.twoPaneMode)) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.two_pane_detail_container, detailFragment)
                    .commit();
        }else {

            Intent intent = new Intent(getContext(), DetailActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}
