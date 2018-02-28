package com.example.pritam.twopane;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class MainFragmentAdapter extends RecyclerView.Adapter<MainFragmentAdapter.MainFragmentViewHolder>{

    private List<Model> mModelList;
    private Context mContext;

    private ListItemClickListener listItemClickListener;

    public MainFragmentAdapter(List<Model> mModelList, Context mContext) {
        this.mModelList = mModelList;
        this.mContext = mContext;
    }

    public void setListItemClickListener(List<Model> models, ListItemClickListener listener){
        mModelList = models;
        listItemClickListener = listener;
    }

    public interface ListItemClickListener {
        public void OnListItemSelected(Model models);
    }

    @Override
    public MainFragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.main_fragment_items;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        MainFragmentViewHolder viewHolder = new MainFragmentViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainFragmentViewHolder holder, int position) {
        holder.mNameTitleTextView.setText(mModelList.get(position).getmNameTitle());
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    class MainFragmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.name_title_text_view)
        TextView mNameTitleTextView;

        public MainFragmentViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            listItemClickListener.OnListItemSelected(mModelList.get(clickedPosition));
        }
    }
}
