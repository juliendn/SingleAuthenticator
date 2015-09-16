package fr.juliendenadai.singleauthenticator.common;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by julien on 16/09/15.
 */
@Singleton
public class LeakManager {

    private RefWatcher mRefWatcher;

    @Inject
    public LeakManager(BaseApplication application) {
        mRefWatcher = LeakCanary.install(application);
    }

    public void watch(Object object) {
        mRefWatcher.watch(object);
    }
}
