package fr.juliendenadai.singleauthenticator.utils;

import android.util.Log;

import fr.juliendenadai.singleauthenticator.BuildConfig;

/**
 * Created by Julien De Nadai on 9/16/2015.
 */
public class LogUtil {

    public static void debug(String message) {
        if (BuildConfig.ENABLE_LOG && Log.DEBUG > BuildConfig.LOG_LEVEL) {
            Log.d(Constants.TAG, message);
        }
    }

    public static void verbose(String message) {
        if (BuildConfig.ENABLE_LOG && Log.VERBOSE > BuildConfig.LOG_LEVEL) {
            Log.v(Constants.TAG, message);
        }
    }

    public static void info(String message) {
        if (BuildConfig.ENABLE_LOG && Log.INFO > BuildConfig.LOG_LEVEL) {
            Log.i(Constants.TAG, message);
        }
    }

    public static void warning(String message) {
        if (BuildConfig.ENABLE_LOG && Log.WARN > BuildConfig.LOG_LEVEL) {
            Log.w(Constants.TAG, message);
        }
    }

    public static void error(String message) {
        if (BuildConfig.ENABLE_LOG && Log.ERROR > BuildConfig.LOG_LEVEL) {
            Log.e(Constants.TAG, message);
        }
    }

    public static void whatTheFuck(String message) {
        Log.wtf(Constants.TAG, message);
    }
}
