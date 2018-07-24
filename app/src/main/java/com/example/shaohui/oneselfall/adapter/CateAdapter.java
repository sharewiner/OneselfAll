package com.example.shaohui.oneselfall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaohui.oneselfall.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CateAdapter extends RecyclerView.Adapter<CateAdapter.ViewHolder> {
    private List<String> mlist;
    private Context context;

    public CateAdapter(Context context, List<String> list) {
        this.context = context;
        this.mlist = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_cate, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvOne.setText(mlist.get(position));

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_one)
        TextView tvOne;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
