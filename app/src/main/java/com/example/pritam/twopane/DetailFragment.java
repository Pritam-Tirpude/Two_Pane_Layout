package com.example.pritam.twopane;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Pritam on 2/8/2018.
 */

public class DetailFragment extends Fragment {

    public static final String KEY = "list";

    @BindView(R.id.detail_name_title_text_view)
    TextView mDetailNameTitleTextView;

    List<Model> models;
    String name;

    public DetailFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            if (getResources().getBoolean(R.bool.twoPaneMode)){
                models = getArguments().getParcelableArrayList(KEY);
            }else {
                savedInstanceState = getActivity().getIntent().getExtras();
                models = savedInstanceState.getParcelableArrayList(KEY);
            }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);

        name = models.get(0).getmNameTitle();
        mDetailNameTitleTextView.setText(name);

        return view;
    }
}
