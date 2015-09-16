package fr.juliendenadai.singleauthenticator;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
public class AuthentManager {

    private static final String TAG = "AuthentUtil";

    @Inject
    public AuthentManager(Context context) {

    }

    public void addAuthentByUri(Uri uri) {
        Log.d(TAG, "addAuthentByUri " + uri);
    }
}
