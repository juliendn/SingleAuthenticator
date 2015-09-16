package fr.juliendenadai.singleauthenticator.common.repositories;

import android.support.annotation.NonNull;

import fr.juliendenadai.singleauthenticator.common.models.Entity;
import rx.Observable;

/**
 * Generic interface for repository pattern
 * <p/>
 * Created by Julien De Nadai <julien.denadai@gmail.com> on 30/06/2015.
 */
public interface Repository<E extends Entity> {

    String KEY_SEPARATOR = "%";

    @NonNull
    Observable<E> get(@NonNull String key);

    @NonNull
    Observable<E> getAll();

}
