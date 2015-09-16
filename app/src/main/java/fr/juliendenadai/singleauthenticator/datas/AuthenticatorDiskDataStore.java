package fr.juliendenadai.singleauthenticator.datas;

import javax.inject.Inject;

import fr.juliendenadai.singleauthenticator.models.Configuration;
import rx.Observable;

/**
 * Created by julien on 16/09/15.
 */
public class AuthenticatorDiskDataStore implements AuthenticatorDataStore {

    private final AuthenticatorCache mCache;

    @Inject
    public AuthenticatorDiskDataStore(AuthenticatorCache cache) {
        mCache = cache;
    }

    @Override
    public Observable<Configuration> authenticatorEntityList() {
        return mCache.getAllAuthenticators();
    }

}
