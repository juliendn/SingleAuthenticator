package fr.juliendenadai.singleauthenticator.common.injections;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import fr.juliendenadai.singleauthenticator.common.BaseApplication;
import fr.juliendenadai.singleauthenticator.common.LeakManager;
import fr.juliendenadai.singleauthenticator.common.executors.PostExecutionThread;
import fr.juliendenadai.singleauthenticator.common.executors.ThreadExecutor;
import fr.juliendenadai.singleauthenticator.datas.AuthenticatorRepository;

/**
 * A component whose lifetime is the life of the application.
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 19/06/15.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseApplication application);

    Context context();

    LeakManager leakManager();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    AuthenticatorRepository repository();
}
