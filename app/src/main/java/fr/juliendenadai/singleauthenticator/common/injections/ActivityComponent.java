package fr.juliendenadai.singleauthenticator.common.injections;

import dagger.Component;
import fr.juliendenadai.singleauthenticator.common.views.BaseActivity;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 19/06/15.
 */
@PerActivity // Subtypes of ActivityComponent should be decorated with @PerActivity.
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    BaseActivity activity();
}