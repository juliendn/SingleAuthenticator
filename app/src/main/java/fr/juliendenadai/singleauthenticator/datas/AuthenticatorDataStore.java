package fr.juliendenadai.singleauthenticator.datas;

import fr.juliendenadai.singleauthenticator.models.Configuration;
import rx.Observable;

/**
 * Created by julien on 16/09/15.
 */
public interface AuthenticatorDataStore {

    Observable<Configuration> authenticatorEntityList();

}
