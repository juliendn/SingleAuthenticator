package fr.juliendenadai.singleauthenticator.displayauthenticators;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import fr.juliendenadai.singleauthenticator.common.injections.PerActivity;
import fr.juliendenadai.singleauthenticator.common.interactors.Interactor;
import fr.juliendenadai.singleauthenticator.models.Authenticator;
import fr.juliendenadai.singleauthenticator.utils.Constants;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
@Module
public class DisplayModule {

    /**
     * Empty constructor
     */
    public DisplayModule() {

    }

    @Provides
    @PerActivity
    @Named(Constants.COMPONENT_GET_AUTHENTICATORS)
    Interactor<Authenticator> provideGetAuthenticators(
            GetAuthenticators getAuthenticators) {
        return getAuthenticators;
    }


}
