package fr.juliendenadai.singleauthenticator.common.interactors;

import rx.Observer;

/**
 * An Interactor, also called a UseCase
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 19/06/15.
 */
public interface Interactor<E> {

    void execute(Observer<E> subscriber, Object... objects);

    void unsubscribe();

}
