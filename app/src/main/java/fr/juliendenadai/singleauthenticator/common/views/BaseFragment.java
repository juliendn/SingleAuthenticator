package fr.juliendenadai.singleauthenticator.common.views;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import fr.juliendenadai.singleauthenticator.common.BaseApplication;
import fr.juliendenadai.singleauthenticator.common.LeakManager;
import fr.juliendenadai.singleauthenticator.common.injections.ActivityModule;
import fr.juliendenadai.singleauthenticator.common.injections.ApplicationComponent;
import fr.juliendenadai.singleauthenticator.common.presenters.BasePresenter;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
public abstract class BaseFragment<P extends BasePresenter>
        extends Fragment
        implements MvpView {

    protected BaseActivity mActivity;

    @Inject
    protected P mPresenter;

    @Inject
    protected LeakManager mLeakManager;

    @Override
    public void hideLoadingIndicator() {
        // TODO: implement loader
    }

    @Override
    public void showLoadingIndicator() {
        // TODO: implement loader
    }

    @Override
    public void showSnackbar(@NonNull String message,
                             @Nullable String action,
                             @Nullable View.OnClickListener listener) {
        final Snackbar snackbar = Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT);
        if (!TextUtils.isEmpty(action) && null != listener) {
            snackbar.setAction(action, listener);
            snackbar.setDuration(Snackbar.LENGTH_LONG);
        }
        snackbar.show();
    }

    @Override
    public Context getContext() {
        return mActivity;
    }

    @Override
    public void onAttach(Activity activity) throws ClassCastException {
        super.onAttach(activity);
        mActivity = (BaseActivity) activity; // Throw ClassCastException if not type A
    }

    @Nullable
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @CallSuper
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
        initializeDependencyInjector();
        initializePresenter();
    }

    @CallSuper
    @Override
    public void onStart() {
        super.onStart();
        if (null != mPresenter) {
            mPresenter.start();
        }
    }

    @CallSuper
    @Override
    public void onResume() {
        super.onResume();
        if (null != mPresenter) {
            mPresenter.resume();
        }
    }

    @CallSuper
    @Override
    public void onPause() {
        super.onPause();
        if (null != mPresenter) {
            mPresenter.pause();
        }
    }

    @CallSuper
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.destroy();
        }
        mLeakManager.watch(this);
    }

    protected abstract int getLayoutId();

    protected abstract void initializeDependencyInjector();

    @SuppressWarnings("unchecked")
    protected final void initializePresenter() {
        mPresenter.attachView(this);
    }

    protected ActivityModule getActivityModule() {
        return mActivity.getModule();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((BaseApplication) mActivity.getApplication()).getApplicationComponent();
    }
}
