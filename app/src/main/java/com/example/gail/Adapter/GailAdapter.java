package com.example.gail.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gail.Class.GailInfo;
import com.example.gail.R;

import java.util.List;

public class GailAdapter extends RecyclerView.Adapter<GailAdapter.GailViewHolder> {
    private Context mContext;
    private List<GailInfo> gailInfoList;

    public GailAdapter(Context mContext, List<GailInfo> gailInfoList) {
        this.mContext = mContext;
        this.gailInfoList = gailInfoList;
    }

    @NonNull
    @Override
    public GailAdapter.GailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.gail_list_recycler,parent,false);
        GailViewHolder viewHolder = new GailViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GailAdapter.GailViewHolder holder, int position) {
        GailInfo gailInfo = gailInfoList.get(position);

        holder.textViewThana.setText("থানা: "+gailInfo.getThana());
        holder.textViewMouja.setText("মৌজা: "+gailInfo.getMouja());
        holder.textViewRS.setText("আর এস: "+gailInfo.getRs());
        holder.textViewSA.setText("এস এ: "+gailInfo.getSa());


    }

    @Override
    public int getItemCount() {
        return gailInfoList.size();
    }

    public class GailViewHolder extends RecyclerView.ViewHolder {
        TextView textViewThana, textViewMouja, textViewRS, textViewSA;

        public GailViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewThana = itemView.findViewById(R.id.thanaId);
            textViewMouja = itemView.findViewById(R.id.moujaId);
            textViewRS = itemView.findViewById(R.id.rsId);
            textViewSA = itemView.findViewById(R.id.saId);
        }
    }
}
