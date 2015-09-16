package fr.juliendenadai.singleauthenticator.addauthenticator.otp;

import dagger.Component;
import fr.juliendenadai.singleauthenticator.common.injections.ActivityComponent;
import fr.juliendenadai.singleauthenticator.common.injections.ActivityModule;
import fr.juliendenadai.singleauthenticator.common.injections.ApplicationComponent;
import fr.juliendenadai.singleauthenticator.common.injections.PerActivity;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, OtpModule.class})
public interface OtpComponent extends ActivityComponent {

    void inject(AbstractOtpFragment fragment);
}
