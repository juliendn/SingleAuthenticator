package fr.juliendenadai.singleauthenticator.common.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.juliendenadai.singleauthenticator.common.injections.ActivityModule;

/**
 * Abstract class to manage common Activity behavior
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 22/06/2015.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected ActivityModule mModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    public ActivityModule getModule() {
        if (null == mModule) {
            mModule = new ActivityModule(this);
        }
        return mModule;
    }

    protected abstract int getLayoutId();
}
