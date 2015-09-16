package fr.juliendenadai.singleauthenticator.datas;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by julien on 16/09/15.
 */
@Singleton
public class AuthenticatorDataStoreFactory {

    private final Context mContext;

    private final AuthenticatorCache mCache;

    @Inject
    public AuthenticatorDataStoreFactory(Context context, AuthenticatorCache cache) {
        mContext = context;
        mCache = cache;
    }

    public AuthenticatorDataStore create() {
        return new AuthenticatorDiskDataStore(mCache);
    }
}
