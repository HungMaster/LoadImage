package com.it.hungvt.loadimage;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 10/26/2017.
 */

public class Photo implements Parcelable{
    private String urlImage;
    private String title;

    public Photo(String urlImage, String title) {
        this.urlImage = urlImage;
        this.title = title;
    }

    protected Photo(Parcel in) {
        urlImage = in.readString();
        title = in.readString();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(urlImage);
        dest.writeString(title);
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
