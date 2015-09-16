package fr.juliendenadai.singleauthenticator.datas;

import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import fr.juliendenadai.singleauthenticator.models.Authenticator;
import rx.Observable;

/**
 * Created by julien on 16/09/15.
 */
@Singleton
public class AuthenticatorDataRepository implements AuthenticatorRepository {

    private final AuthenticatorDataStoreFactory mFactory;
    private final ConfigurationToAuthenticatorDataMapper mDataMapper;

    @Inject
    public AuthenticatorDataRepository(AuthenticatorDataStoreFactory factory,
                                       ConfigurationToAuthenticatorDataMapper dataMapper) {
        mFactory = factory;
        mDataMapper = dataMapper;
    }

    @NonNull
    @Override
    public Observable<Authenticator> getAuthenticators() {
        final AuthenticatorDataStore store = mFactory.create();
        return store.authenticatorEntityList()
                .flatMap(mDataMapper);
    }
}
