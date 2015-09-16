package fr.juliendenadai.singleauthenticator.addauthenticator.otp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.juliendenadai.singleauthenticator.R;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 11/09/15.
 */
public class BattlenetFragment extends Fragment {

    public static Fragment newInstance() {
        return new BattlenetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.addselector_battlenet_fragment, container, false);
    }
}
