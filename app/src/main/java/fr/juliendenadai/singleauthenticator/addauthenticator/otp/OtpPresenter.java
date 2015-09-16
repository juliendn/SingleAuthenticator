package fr.juliendenadai.singleauthenticator.addauthenticator.otp;

import javax.inject.Inject;

import fr.juliendenadai.singleauthenticator.navigations.Navigator;
import fr.juliendenadai.singleauthenticator.common.injections.PerActivity;
import fr.juliendenadai.singleauthenticator.common.presenters.BasePresenter;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 13/09/15.
 */
@PerActivity
public class OtpPresenter extends BasePresenter<OtpView>{

    @Inject
    public OtpPresenter(Navigator navigator) {
        super(navigator);
    }
}
