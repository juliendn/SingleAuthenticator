package fr.juliendenadai.singleauthenticator.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by julien on 16/09/15.
 */
public enum Type {
    @SerializedName("hotp")
    HOTP,
    @SerializedName("totp")
    TOTP,
    @SerializedName("battlenet")
    BATTLENET
}
