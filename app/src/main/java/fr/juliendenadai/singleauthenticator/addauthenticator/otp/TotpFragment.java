package fr.juliendenadai.singleauthenticator.addauthenticator.otp;

import android.app.Fragment;
import android.os.Bundle;

import fr.juliendenadai.singleauthenticator.R;
import fr.juliendenadai.singleauthenticator.addauthenticator.Configuration;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
public class TotpFragment extends AbstractOtpFragment {

    public static Fragment newInstance() {
        final Fragment fragment = new TotpFragment();
        final Bundle arguments = new Bundle();
        fragment.setArguments(arguments);
        return fragment;
    }

    public static Fragment newInstance(Configuration configuration) {
        final Fragment fragment = new TotpFragment();
        final Bundle arguments = new Bundle();
        arguments.putString(KEY_NAME, configuration.getName());
        arguments.putString(KEY_ISSUER, configuration.getIssuer());
        arguments.putParcelable(KEY_DIGITS, configuration.getDigits());
        arguments.putParcelable(KEY_ALGORITHM, configuration.getAlgorithm());
        arguments.putInt(KEY_INTERVAL, configuration.getInterval());
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.addauthenticator_totp_fragment;
    }
}
