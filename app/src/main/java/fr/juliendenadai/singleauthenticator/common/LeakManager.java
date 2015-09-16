package fr.juliendenadai.singleauthenticator.common;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by julien on 16/09/15.
 */
public class LeakManager {

    private RefWatcher mRefWatcher;

    public LeakManager(BaseApplication application) {
        mRefWatcher = LeakCanary.install(application);
    }

    public void watch(Object object) {
        mRefWatcher.watch(object);
    }
}
