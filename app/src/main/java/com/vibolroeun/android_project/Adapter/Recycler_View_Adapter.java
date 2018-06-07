package com.vibolroeun.android_project.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vibolroeun.android_project.Models.list_row;
import com.vibolroeun.android_project.R;

import java.util.List;


public class Recycler_View_Adapter extends RecyclerView.Adapter<Recycler_View_Adapter.ViewHolder> {

    private Context context;
    private List<list_row> mData;

    public Recycler_View_Adapter(Context context, List<list_row> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.boots_row_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(mData.get(position).getTitle());
        holder.price.setText(mData.get(position).getPrice());
        holder.image.setImageResource(mData.get(position).getPhoto());


    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView price;
        private ImageView image;


        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.name_bigID);
            price = itemView.findViewById(R.id.price_bigID);
            image = itemView.findViewById(R.id.image_bigID);
        }
    }
}
