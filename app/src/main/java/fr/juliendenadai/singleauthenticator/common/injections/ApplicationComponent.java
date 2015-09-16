package fr.juliendenadai.singleauthenticator.common.injections;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import fr.juliendenadai.singleauthenticator.managers.AuthentManager;
import fr.juliendenadai.singleauthenticator.datas.AuthenticatorRepository;
import fr.juliendenadai.singleauthenticator.common.BaseApplication;
import fr.juliendenadai.singleauthenticator.common.LeakManager;
import fr.juliendenadai.singleauthenticator.common.executors.PostExecutionThread;
import fr.juliendenadai.singleauthenticator.common.executors.ThreadExecutor;

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

    AuthentManager authentManager();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    AuthenticatorRepository repository();
}
