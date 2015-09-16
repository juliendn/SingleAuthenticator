package fr.juliendenadai.singleauthenticator.common.injections;

import javax.inject.Singleton;

import dagger.Component;
import fr.juliendenadai.singleauthenticator.Navigator;
import fr.juliendenadai.singleauthenticator.AuthentManager;
import fr.juliendenadai.singleauthenticator.common.BaseApplication;
import fr.juliendenadai.singleauthenticator.common.LeakManager;

/**
 * A component whose lifetime is the life of the application.
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 19/06/15.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(BaseApplication application);

    BaseApplication application();
    
    LeakManager leakManager();

    AuthentManager authentManager();

    Navigator navigator();
}
