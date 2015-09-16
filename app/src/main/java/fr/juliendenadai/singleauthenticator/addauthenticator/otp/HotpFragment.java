package fr.juliendenadai.singleauthenticator.addauthenticator.otp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.InjectView;
import fr.juliendenadai.singleauthenticator.R;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
public class HotpFragment extends AbstractOtpFragment {

    protected static final String KEY_COUNTER = "key_counter";

    @InjectView(R.id.counter)
    EditText mCounter;

    public static Fragment newInstance() {
        final Fragment fragment = new HotpFragment();
        final Bundle arguments = new Bundle();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.addauthenticator_hotp_fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int counter = getCounter();
        if (counter > -1) {
            mCounter.setText(Integer.toString(counter));
            mCounter.setEnabled(false);
        }

    }

    private int getCounter() {
        return getArguments().getInt(KEY_COUNTER, -1);
    }
}
