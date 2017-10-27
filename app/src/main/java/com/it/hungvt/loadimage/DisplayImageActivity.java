package com.it.hungvt.loadimage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

/**
 * Created by Administrator on 10/26/2017.
 */

public class DisplayImageActivity extends AppCompatActivity implements ImageAdapter.OnImageClickListener {

    private ImageView imgPhoto;
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgPhoto = findViewById(R.id.img_photo);
        imageAdapter = new ImageAdapter(this);
    }

    @Override
    public void onImageClicked(Photo photo) {
        RequestOptions options = new RequestOptions()
                .error(R.mipmap.ic_launcher_round)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        RequestListener listener = new RequestListener<Bitmap>() {

            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                onPalette(Palette.from(resource).generate());
                imgPhoto.setImageBitmap(resource);
                return false;
            }

            private void onPalette(Palette generate) {
                ViewGroup viewGroup = (ViewGroup) imgPhoto.getParent();
                viewGroup.setBackgroundColor(generate.getDarkVibrantColor(Color.GRAY));
            }
        };

        Glide.with(this)
                .asBitmap()
                .load(photo.getUrlImage())
                .apply(options)
                .listener(listener)
                .into(imgPhoto);

    }
}
