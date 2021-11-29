package com.example.kinopoisk.adapters;

import android.app.slice.SliceItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinopoisk.R;
import com.example.kinopoisk.models.ImageModel;
import com.makeramen.roundedimageview.RoundedImageView;

public class ImageVeiwHolder extends RecyclerView.ViewHolder {
    ImageView imageView;

    public ImageVeiwHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_item);
    }

}
