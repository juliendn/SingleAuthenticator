package fr.juliendenadai.singleauthenticator.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
public enum Digits implements Parcelable {

    @SerializedName("6")
    SIX(6),

    @SerializedName("8")
    EIGHT(8);

    private final int mValue;

    Digits(int value) {
        mValue = value;
    }

    Digits(Parcel parcel) {
        mValue = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mValue);
    }

    @Override
    public String toString() {
        return "Digit(" + mValue + ")";
    }
}
