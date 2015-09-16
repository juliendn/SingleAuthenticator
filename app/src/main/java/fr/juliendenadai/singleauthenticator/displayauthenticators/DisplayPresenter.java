package fr.juliendenadai.singleauthenticator.displayauthenticators;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Named;

import fr.juliendenadai.singleauthenticator.common.interactors.Interactor;
import fr.juliendenadai.singleauthenticator.navigations.Navigator;
import fr.juliendenadai.singleauthenticator.utils.Constants;
import fr.juliendenadai.singleauthenticator.models.Authenticator;
import fr.juliendenadai.singleauthenticator.common.injections.PerActivity;
import fr.juliendenadai.singleauthenticator.common.presenters.BasePresenter;
import fr.juliendenadai.singleauthenticator.utils.LogUtil;
import rx.Observer;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
@PerActivity
public class DisplayPresenter extends BasePresenter<DisplayView>
        implements DisplayView.Listener {

    Interactor<Authenticator> mGetAuthenticator;

    @Inject
    public DisplayPresenter(Navigator navigator,
                            @Named(Constants.COMPONENT_GET_AUTHENTICATORS) Interactor<Authenticator> getAuthenticators) {
        super(navigator);
        mGetAuthenticator = getAuthenticators;
    }

    @Override
    public void start() {
        super.start();
        mGetAuthenticator.execute(new Observer<Authenticator>() {
            @Override
            public void onCompleted() {
                LogUtil.debug("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.error(e.getMessage());
            }

            @Override
            public void onNext(Authenticator authenticator) {
                LogUtil.debug("onNext " + authenticator);
                mView.addAuthenticator(authenticator);
            }
        });
    }

    public void clickFab() {
        mNavigator.openAddActivity();
    }

    public void parseIntent(Intent intent) {
        if (null != intent) {
            final Uri uri = intent.getData();
            if (null != uri) {
                Toast.makeText(mContext, "addAuthentByUri " + uri, Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void onAddClose(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.ADD_REQUEST_CODE &&
                resultCode == Activity.RESULT_OK) {
            parseIntent(data);
        }
    }

    @Override
    public void onAuthenticatorAdded(Authenticator authenticator) {
        // TODO: add authenticator to adapter
    }
}
