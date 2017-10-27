package com.it.hungvt.loadimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private RecyclerView rcvPhoto;
    private ImageAdapter imageAdapter;
    private ArrayList<Photo> photos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        rcvPhoto = findViewById(R.id.rcv_photo);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        rcvPhoto.setHasFixedSize(true);
        rcvPhoto.setLayoutManager(layoutManager);
        setupPhoto();
        imageAdapter = new ImageAdapter(this,photos);
        rcvPhoto.setAdapter(imageAdapter);


    }

    public void setupPhoto(){
                photos = new ArrayList<>();
                photos.add(new Photo("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"));
                photos.add(new Photo("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"));
                photos.add(new Photo("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"));
                photos.add(new Photo("http://i.imgur.com/qpr5LR2.jpg", "Earth"));
                photos.add(new Photo("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"));
                photos.add(new Photo("http://i.imgur.com/3wQcZeY.jpg", "Satellite"));
    }


}
