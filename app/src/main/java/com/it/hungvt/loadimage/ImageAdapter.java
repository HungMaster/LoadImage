package com.it.hungvt.loadimage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 10/26/2017.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Photo> photos;
    private LayoutInflater inflater;
    private OnImageClickListener listener;

    public ImageAdapter(OnImageClickListener listener) {
        this.listener = listener;
    }

    public ImageAdapter(Context context, ArrayList<Photo> photos) {
        this.context = context;
        this.photos = photos;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_view,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Photo photo = photos.get(position);

        Glide.with(context)
                .load(photo.getUrlImage())
                .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Photo photo = photos.get(position);
                    listener.onImageClicked(photo);
                }
            });
        }
    }


    public interface OnImageClickListener{
        public void onImageClicked(Photo photo);
    }
}
