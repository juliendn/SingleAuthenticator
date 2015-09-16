package fr.juliendenadai.singleauthenticator.displayauthenticators;

import javax.inject.Inject;

import fr.juliendenadai.singleauthenticator.common.executors.PostExecutionThread;
import fr.juliendenadai.singleauthenticator.common.executors.ThreadExecutor;
import fr.juliendenadai.singleauthenticator.common.injections.PerActivity;
import fr.juliendenadai.singleauthenticator.common.interactors.BaseInteractor;
import fr.juliendenadai.singleauthenticator.datas.AuthenticatorRepository;
import fr.juliendenadai.singleauthenticator.models.Authenticator;
import rx.Observable;

/**
 * Created by Julien De Nadai on 9/16/2015.
 */
@PerActivity
public class GetAuthenticators extends BaseInteractor<Authenticator> {


    private final AuthenticatorRepository mRepository;

    //    protected BaseInteractor(ThreadExecutor threadExecutor,
//                             PostExecutionThread postExecutionThread,
//                             Repository<E> repository) {
    @Inject
    public GetAuthenticators(ThreadExecutor threadExecutor,
                             PostExecutionThread postExecutionThread,
                             AuthenticatorRepository repository) {
        super(threadExecutor, postExecutionThread);
        mRepository = repository;
    }

    @Override
    protected Observable<Authenticator> buildInteractorObservable(Object[] objects) {
        return mRepository.getAuthenticators();
    }
}
