package fr.juliendenadai.singleauthenticator.common.injections;

import dagger.Module;
import dagger.Provides;
import fr.juliendenadai.singleauthenticator.common.views.BaseActivity;

/**
 * A module to wrap the Activity state and expose it to the graph.
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
@Module
public class ActivityModule {

    private final BaseActivity mActivity;

    public ActivityModule(BaseActivity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    BaseActivity provideActivity() {
        return mActivity;
    }
}
