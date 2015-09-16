package fr.juliendenadai.singleauthenticator.common.presenters;

import android.content.Context;
import android.support.annotation.CallSuper;

import fr.juliendenadai.singleauthenticator.Navigator;
import fr.juliendenadai.singleauthenticator.common.views.MvpView;


/**
 * Abstract class to manage common Presenter behavior
 * <p/>
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 04/07/15.
 */
public abstract class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    /**
     * Navigator reference. Used to provide transition between screens
     */
    protected final Navigator mNavigator;

    /**
     * MVP View used by this presenter
     */
    protected V mView;

    protected Context mContext;

    public BasePresenter(Navigator navigator) {
        mNavigator = navigator;
    }

    @CallSuper
    @Override
    public void attachView(V view) {
        mView = view;
        mContext = view.getContext();

    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @CallSuper
    @Override
    public void destroy() {
        mView = null;
    }
}
