package fr.juliendenadai.singleauthenticator.managers;

import android.net.Uri;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

import fr.juliendenadai.singleauthenticator.datas.AuthenticatorRepository;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
@Singleton
public class AuthentManager {

    private static final String TAG = "AuthentUtil";

    private final AuthenticatorRepository mRepo;

    @Inject
    public AuthentManager(AuthenticatorRepository repository) {
        mRepo = repository;
    }

    public void addAuthentByUri(Uri uri) {
        Log.d(TAG, "addAuthentByUri " + uri);
    }
}
