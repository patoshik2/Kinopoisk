package com.example.kinopoisk.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kinopoisk.R;
import com.example.kinopoisk.models.ImageModel;
import com.example.kinopoisk.models.MovieModel;

import java.util.List;

public class ImageRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ImageModel> iMovies;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_list_item,parent, false);

        return new ImageVeiwHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Glide.with(holder.itemView.getContext())
                .load( iMovies.get(position).getImage())
                .into(((ImageVeiwHolder)holder).imageView);
    }

    @Override
    public int getItemCount() {
         if(iMovies != null) {
            return iMovies.size();
        }
        return 0;
    }

    public void setmMovies(List<ImageModel> iMovies) {
        this.iMovies = iMovies;
        notifyDataSetChanged();
    }

}
