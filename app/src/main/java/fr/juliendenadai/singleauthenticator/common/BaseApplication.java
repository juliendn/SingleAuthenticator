package fr.juliendenadai.singleauthenticator.common;

import android.app.Application;

import fr.juliendenadai.singleauthenticator.common.injections.ApplicationComponent;
import fr.juliendenadai.singleauthenticator.common.injections.ApplicationModule;
import fr.juliendenadai.singleauthenticator.common.injections.DaggerApplicationComponent;

/**
 * Created by julien on 16/09/15.
 */
public class BaseApplication extends Application {

    private ApplicationComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    public ApplicationComponent getApplicationComponent() {
        return mAppComponent;
    }

    private void initializeInjector() {
        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
