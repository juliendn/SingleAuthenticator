package fr.juliendenadai.singleauthenticator.common.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * The View interface of a MVP model
 * <p/>
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 19/06/2015.
 */
public interface MvpView {

    void hideLoadingIndicator();

    void showLoadingIndicator();

    void showSnackbar(@NonNull String message,
                      @Nullable String action,
                      @Nullable android.view.View.OnClickListener listener);

    Context getContext();

}
