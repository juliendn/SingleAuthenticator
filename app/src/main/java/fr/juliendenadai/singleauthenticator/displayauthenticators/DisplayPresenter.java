package fr.juliendenadai.singleauthenticator.displayauthenticators;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import javax.inject.Inject;

import fr.juliendenadai.singleauthenticator.navigations.Navigator;
import fr.juliendenadai.singleauthenticator.managers.Constants;
import fr.juliendenadai.singleauthenticator.models.Authenticator;
import fr.juliendenadai.singleauthenticator.common.injections.PerActivity;
import fr.juliendenadai.singleauthenticator.common.presenters.BasePresenter;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
@PerActivity
public class DisplayPresenter extends BasePresenter<DisplayView>
        implements DisplayView.Listener {

    @Inject
    public DisplayPresenter(Navigator navigator) {
        super(navigator);
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
