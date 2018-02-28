package com.example.pritam.twopane;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Pritam on 2/8/2018.
 */

public class Model implements Parcelable {

    private String mNameTitle;

    public Model(String mNameTitle) {
        this.mNameTitle = mNameTitle;
    }

    protected Model(Parcel in) {
        mNameTitle = in.readString();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public String getmNameTitle() {
        return mNameTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mNameTitle);
    }
}
