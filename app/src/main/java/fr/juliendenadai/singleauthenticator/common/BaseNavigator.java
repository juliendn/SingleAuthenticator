package fr.juliendenadai.singleauthenticator.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import fr.juliendenadai.singleauthenticator.common.views.BaseActivity;

/**
 * Created by julien on 16/09/15.
 */
public abstract class BaseNavigator {

    protected abstract <A extends BaseActivity>
    void goToActivity(@NonNull Class<A> activityClass,
                      @Nullable Bundle extras);

    protected abstract <A extends BaseActivity>
    void goToActivityForResult(@NonNull Class<A> activityClass,
                               int requestCode,
                               @Nullable Bundle extras);
}
