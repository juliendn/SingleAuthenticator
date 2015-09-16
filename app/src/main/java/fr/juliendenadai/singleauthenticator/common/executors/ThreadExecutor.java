package fr.juliendenadai.singleauthenticator.common.executors;

import java.util.concurrent.Executor;

import fr.juliendenadai.singleauthenticator.common.interactors.BaseInteractor;

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the
 * {@link BaseInteractor} out of the UI thread.
 */
public interface ThreadExecutor extends Executor {
}

