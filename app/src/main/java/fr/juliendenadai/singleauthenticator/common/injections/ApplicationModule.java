package fr.juliendenadai.singleauthenticator.common.injections;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.juliendenadai.singleauthenticator.Navigator;
import fr.juliendenadai.singleauthenticator.AuthentManager;
import fr.juliendenadai.singleauthenticator.common.BaseApplication;
import fr.juliendenadai.singleauthenticator.common.LeakManager;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
@Module
public class ApplicationModule {
    private final BaseApplication mApplication;
    private final LeakManager mLeakManager;

    public ApplicationModule(BaseApplication application) {
        mApplication = application;
        mLeakManager = new LeakManager(mApplication);
    }

    @Provides
    @Singleton
    BaseApplication provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    LeakManager provideLeakManager() {
        return mLeakManager;
    }

    @Provides
    @Singleton
    AuthentManager provideAuthentManager() {
        return new AuthentManager(mApplication);
    }

    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator();
    }
}
