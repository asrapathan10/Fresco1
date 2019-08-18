package com.nirvanaapp.sourcekode.fresco;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustoViewHolder>{
    private ArrayList<Hits> hits;

    public RecyclerViewAdapter(ArrayList<Hits> hits) {
        this.hits = hits;
    }

    @Override
    public CustoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.imagelist, parent, false);
        return new CustoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustoViewHolder holder, int position) {
        Hits object=hits.get(position);
        holder.imageView.setImageURI(object.getWebformatURL());
    }

    @Override
    public int getItemCount() {
        return hits.size();
    }

    public class CustoViewHolder extends RecyclerView.ViewHolder{
        public SimpleDraweeView imageView;

        public CustoViewHolder(View itemView, SimpleDraweeView imageView) {
            super(itemView);
            this.imageView = imageView;
        }

        public CustoViewHolder(View itemView) {
            super(itemView);
            imageView=(SimpleDraweeView)itemView.findViewById(R.id.draweeViewTwo);
        }

    }
}
