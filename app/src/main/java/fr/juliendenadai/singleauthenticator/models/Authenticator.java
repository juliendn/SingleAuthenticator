package fr.juliendenadai.singleauthenticator.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import fr.juliendenadai.singleauthenticator.common.models.Entity;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 13/09/15.
 */
public class Authenticator extends Entity {

    @Expose
    @SerializedName("issuer_int")
    private String mIssuerInt;

    @Expose
    @SerializedName("issuer_ext")
    private String mIssuerExt;

    @Expose
    @SerializedName("issuer_alt")
    private String mIssuerAlt;

    @Expose
    @SerializedName("label")
    private String mLabel;

    @Expose
    @SerializedName("label_alt")
    private String mLabelAlt;

    @Expose
    @SerializedName("image")
    private String mImage;

    @Expose
    @SerializedName("image_alt")
    private String mImageAlt;

    @Expose
    @SerializedName("type")
    private Type mType;

    @Expose
    @SerializedName("algo")
    private Algorithm mAlgo;

    @Expose
    @SerializedName("secret")
    private byte[] mSecret;

    @Expose
    @SerializedName("digits")
    private Digits mDigits;

    @Expose
    @SerializedName("counter")
    private long mCounter;

    @Expose
    @SerializedName("period")
    private int mPeriod;

    public String getIssuerInt() {
        return mIssuerInt;
    }

    public void setIssuerInt(String issuerInt) {
        this.mIssuerInt = issuerInt;
    }

    public String getIssuerExt() {
        return mIssuerExt;
    }

    public void setIssuerExt(String issuerExt) {
        this.mIssuerExt = issuerExt;
    }

    public String getIssuerAlt() {
        return mIssuerAlt;
    }

    public void setIssuerAlt(String issuerAlt) {
        this.mIssuerAlt = issuerAlt;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        this.mLabel = label;
    }

    public String getLabelAlt() {
        return mLabelAlt;
    }

    public void setLabelAlt(String labelAlt) {
        this.mLabelAlt = labelAlt;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        this.mImage = image;
    }

    public String getImageAlt() {
        return mImageAlt;
    }

    public void setImageAlt(String imageAlt) {
        this.mImageAlt = imageAlt;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        this.mType = type;
    }

    public Algorithm getAlgo() {
        return mAlgo;
    }

    public void setAlgo(Algorithm algo) {
        this.mAlgo = algo;
    }

    public byte[] getSecret() {
        return mSecret;
    }

    public void setSecret(byte[] secret) {
        this.mSecret = secret;
    }

    public Digits getDigits() {
        return mDigits;
    }

    public void setDigits(Digits digits) {
        this.mDigits = digits;
    }

    public long getCounter() {
        return mCounter;
    }

    public void setCounter(long counter) {
        this.mCounter = counter;
    }

    public int getPeriod() {
        return mPeriod;
    }

    public void setPeriod(int period) {
        this.mPeriod = period;
    }

}
