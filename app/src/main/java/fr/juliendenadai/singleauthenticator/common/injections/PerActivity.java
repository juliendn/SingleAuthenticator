package fr.juliendenadai.singleauthenticator.common.injections;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
