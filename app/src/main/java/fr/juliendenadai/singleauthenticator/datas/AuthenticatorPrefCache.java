package fr.juliendenadai.singleauthenticator.datas;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.inject.Inject;
import javax.inject.Singleton;

import fr.juliendenadai.singleauthenticator.models.Configuration;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by julien on 16/09/15.
 */
@Singleton
public class AuthenticatorPrefCache implements AuthenticatorCache {

    private static final String AUTHENTICATOR_PREFS_NAME = "authenticators";

    private static final String AUTHENTICATOR_PREFS_KEY = "authenticators_gson";

    private static final String EMPTY = "{" +
            "\"authenticators\":[]," +
            "\"last_used\":-1," +
            "}";

    private static final int PREFS_MODE = Context.MODE_PRIVATE;

    private final SharedPreferences mPrefs;

    private Gson mGson;

    @Inject
    public AuthenticatorPrefCache(Context context) {
        mPrefs = context.getSharedPreferences(AUTHENTICATOR_PREFS_NAME, PREFS_MODE);
        mGson = new Gson();
    }

    @Override
    public Observable<Configuration> getAllAuthenticators() {
        return Observable.create(new Observable.OnSubscribe<Configuration>() {
            @Override
            public void call(Subscriber<? super Configuration> subscriber) {
                try {
                    final String json = mPrefs.getString(AUTHENTICATOR_PREFS_KEY, EMPTY);
                    final Configuration configuration = mGson.fromJson(json, Configuration.class);
                    subscriber.onNext(configuration);
                    subscriber.onCompleted();
                } catch (JsonSyntaxException jse) {
                    subscriber.onError(jse);
                }
            }
        });
    }
}
