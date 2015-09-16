package fr.juliendenadai.singleauthenticator.common.injections;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import fr.juliendenadai.singleauthenticator.datas.AuthenticatorCache;
import fr.juliendenadai.singleauthenticator.datas.AuthenticatorDataRepository;
import fr.juliendenadai.singleauthenticator.datas.AuthenticatorPrefCache;
import fr.juliendenadai.singleauthenticator.datas.AuthenticatorRepository;
import fr.juliendenadai.singleauthenticator.common.BaseApplication;
import fr.juliendenadai.singleauthenticator.common.LeakManager;
import fr.juliendenadai.singleauthenticator.common.executors.JobExecutor;
import fr.juliendenadai.singleauthenticator.common.executors.PostExecutionThread;
import fr.juliendenadai.singleauthenticator.common.executors.ThreadExecutor;
import fr.juliendenadai.singleauthenticator.common.executors.UIThread;

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
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    LeakManager provideLeakManager() {
        return mLeakManager;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    AuthenticatorCache provideUserCache(AuthenticatorPrefCache cache) {
        return cache;
    }

    @Provides
    @Singleton
    AuthenticatorRepository provideAuthentRepository(AuthenticatorDataRepository repo) {
        return repo;
    }
}
