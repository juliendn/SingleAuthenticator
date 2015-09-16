package fr.juliendenadai.singleauthenticator.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by julien on 16/09/15.
 */
public class Configuration {

    @Expose
    @SerializedName("authenticators")
    private List<Authenticator> mAuthenticators;

    @Expose
    @SerializedName("last_used")
    private int mLastUsed;

    public List<Authenticator> getAuthenticators() {
        return mAuthenticators;
    }

    public void setAuthenticators(List<Authenticator> authenticators) {
        mAuthenticators = authenticators;
    }

    public int getLastUsed() {
        return mLastUsed;
    }

    public void setLastUsed(int lastUsed) {
        mLastUsed = lastUsed;
    }

    @Override
    public String toString() {
        return "Configuration(" + mAuthenticators + ")";
    }
}
