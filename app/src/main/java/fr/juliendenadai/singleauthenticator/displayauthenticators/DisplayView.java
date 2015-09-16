package fr.juliendenadai.singleauthenticator.displayauthenticators;

import fr.juliendenadai.singleauthenticator.models.Authenticator;
import fr.juliendenadai.singleauthenticator.common.views.MvpView;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
public interface DisplayView extends MvpView {

    void addAuthenticator(Authenticator authenticator);

    interface Listener {
        void onAuthenticatorAdded(Authenticator authenticator);
    }
}
