package fr.juliendenadai.singleauthenticator.common.executors;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * Simple ThreadExecutor implementation using Android looper
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 23/06/2015.
 */
public class SimpleExecutor implements ThreadExecutor {

    Looper mLooper;
    HandlerThread mThread;
    Handler mHandler;


    @Inject
    public SimpleExecutor() {
        mThread = new HandlerThread("executor");
        mThread.start();
        mLooper = mThread.getLooper();
        mHandler = new Handler(mLooper);
    }

    @Override
    public void execute(@NonNull Runnable command) {
        mHandler.post(command);
    }

    public Looper getLooper() {
        return mLooper;
    }
}
