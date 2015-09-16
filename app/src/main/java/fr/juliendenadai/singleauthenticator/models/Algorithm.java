package fr.juliendenadai.singleauthenticator.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
public enum Algorithm implements Parcelable {

    @SerializedName("md5")
    MD5(0),

    @SerializedName("sha1")
    SHA1(1),

    @SerializedName("sha256")
    SHA256(2),

    @SerializedName("sha512")
    SHA512(3);

    private final int mPosition;

    Algorithm(int code) {
        mPosition = code;
    }

    Algorithm(Parcel parcel) {
        mPosition = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mPosition);
    }

    public int getPosition() {
        return mPosition;
    }

    @Override
    public String toString() {
        return "Algo(" + mPosition + ")";
    }
}
