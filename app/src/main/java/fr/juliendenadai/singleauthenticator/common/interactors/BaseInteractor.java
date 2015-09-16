package fr.juliendenadai.singleauthenticator.common.interactors;

import fr.juliendenadai.singleauthenticator.common.executors.PostExecutionThread;
import fr.juliendenadai.singleauthenticator.common.executors.ThreadExecutor;
import fr.juliendenadai.singleauthenticator.common.models.Entity;
import fr.juliendenadai.singleauthenticator.common.repositories.Repository;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Base class for Interactor
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 19/06/2015.
 */
public abstract class BaseInteractor<E extends Entity> implements Interactor<E> {

    private final ThreadExecutor mThreadExecutor;

    private final PostExecutionThread mPostExecutionThread;

    private Subscription mSubscription = Subscriptions.empty();

    protected BaseInteractor(ThreadExecutor threadExecutor,
                             PostExecutionThread postExecutionThread) {
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = postExecutionThread;
    }

    /**
     * Executes the current use case.
     *
     * @param subscriber The guy who will be listen to the observable build with {@link #buildInteractorObservable(Object[])}.
     */
    public void execute(Observer<E> subscriber, Object... objects) {
        mSubscription = buildInteractorObservable(objects)
//                .subscribeOn(Schedulers.from(mThreadExecutor))
                .subscribeOn(Schedulers.io())
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribe(subscriber);
    }

    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    public void unsubscribe() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

    protected abstract Observable<E> buildInteractorObservable(Object[] objects);

}
