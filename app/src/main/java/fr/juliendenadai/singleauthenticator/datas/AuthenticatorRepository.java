package fr.juliendenadai.singleauthenticator.datas;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import fr.juliendenadai.singleauthenticator.models.Authenticator;
import rx.Observable;

/**
 * Created by julien on 16/09/15.
 */
@Singleton
public interface AuthenticatorRepository {

    @NonNull
    Observable<Authenticator> getAuthenticators();
}
