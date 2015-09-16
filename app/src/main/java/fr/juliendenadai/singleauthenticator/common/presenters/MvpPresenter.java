package fr.juliendenadai.singleauthenticator.common.presenters;

import fr.juliendenadai.singleauthenticator.common.views.MvpView;

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 * <p/>
 * Created by julien De Nadai<julien.denadai@gmail.com> on 19/06/2015.
 */
public interface MvpPresenter<V extends MvpView> {

    /**
     * Method that control the lifecycle of the view. It should be called onece to give a
     * view reference to the presenter. It emulates the onCreate() method.
     */
    void attachView(V view);

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onCreate()/onViewCreated method.
     */
    void start();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();

}
