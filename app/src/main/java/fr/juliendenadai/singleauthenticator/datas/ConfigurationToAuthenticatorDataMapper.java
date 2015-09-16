package fr.juliendenadai.singleauthenticator.datas;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import fr.juliendenadai.singleauthenticator.models.Configuration;
import fr.juliendenadai.singleauthenticator.models.Authenticator;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by julien on 16/09/15.
 */
@Singleton
public class ConfigurationToAuthenticatorDataMapper implements Func1<Configuration, Observable<Authenticator>> {

    @Inject
    public ConfigurationToAuthenticatorDataMapper() {

    }

    @Override
    public Observable<Authenticator> call(final Configuration configuration) {
        return Observable.create(new Observable.OnSubscribe<Authenticator>() {
            @Override
            public void call(Subscriber<? super Authenticator> subscriber) {
                final List<Authenticator> authenticators = configuration.getAuthenticators();
                for (Authenticator authenticator : authenticators) {
                    subscriber.onNext(authenticator);
                }
                subscriber.onCompleted();
            }
        });
    }
}
