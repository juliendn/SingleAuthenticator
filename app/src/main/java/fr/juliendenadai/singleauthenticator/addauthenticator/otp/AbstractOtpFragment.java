package fr.juliendenadai.singleauthenticator.addauthenticator.otp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import butterknife.InjectView;
import fr.juliendenadai.singleauthenticator.R;
import fr.juliendenadai.singleauthenticator.utils.Constants;
import fr.juliendenadai.singleauthenticator.common.views.BaseFragment;
import fr.juliendenadai.singleauthenticator.models.Algorithm;
import fr.juliendenadai.singleauthenticator.models.Digits;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
public abstract class AbstractOtpFragment extends BaseFragment<OtpPresenter> {

    protected static final String KEY_NAME = "key_name";

    protected static final String KEY_ISSUER = "key_issuer";

    protected static final String KEY_DIGITS = "key_digits";

    protected static final String KEY_ALGORITHM = "key_algorithm";

    protected static final String KEY_INTERVAL = "key_interval";

    @InjectView(R.id.name)
    protected EditText mNameView;

    @InjectView(R.id.issuer)
    protected EditText mIssuerView;

    @InjectView(R.id.digits6)
    protected RadioButton mSixDigits;

    @InjectView(R.id.digits8)
    protected RadioButton mHeightDigits;

    @InjectView(R.id.algorithm)
    protected Spinner mAlgorithm;

    @InjectView(R.id.interval)
    protected EditText mInterval;

    @Override
    protected void initializeDependencyInjector() {
        DaggerOtpComponent.builder()
                .activityModule(getActivityModule())
                .applicationComponent(getApplicationComponent())
                .build()
                .inject(this);
        Log.d(Constants.TAG, "di initialized");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final String name = getName();
        if (!TextUtils.isEmpty(name)) {
            mNameView.setText(name);
        }

        final String issuer = getIssuer();
        if (!TextUtils.isEmpty(issuer)) {
            mIssuerView.setText(issuer);
        }

        final Digits digits = getDigits();
        if (null != digits) {
            switch (digits) {
                case SIX:
                    mSixDigits.setChecked(true);
                    break;
                case EIGHT:
                    mHeightDigits.setChecked(true);
                    break;
            }
            mSixDigits.setEnabled(false);
            mHeightDigits.setEnabled(false);
        }

        final Algorithm algorithm = getAlgorithm();
        if (null != algorithm) {
            mAlgorithm.setSelection(algorithm.getPosition());
            mAlgorithm.setEnabled(false);
        }

        final int interval = getInterval();
        if (interval > 0) {
            mInterval.setText(Integer.toString(interval));
            mInterval.setEnabled(false);
        }
    }

    @Nullable
    protected String getName() {
        return getArguments().getString(KEY_NAME, null);
    }

    @Nullable
    protected String getIssuer() {
        return getArguments().getString(KEY_ISSUER, null);
    }

    @Nullable
    protected Digits getDigits() {
        return getArguments().getParcelable(KEY_DIGITS);
    }

    @Nullable
    protected Algorithm getAlgorithm() {
        return getArguments().getParcelable(KEY_ALGORITHM);
    }

    protected int getInterval() {
        return getArguments().getInt(KEY_INTERVAL, -1);
    }
}
