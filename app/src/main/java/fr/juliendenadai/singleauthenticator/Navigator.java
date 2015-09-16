package fr.juliendenadai.singleauthenticator;

import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;
import javax.inject.Singleton;

import fr.juliendenadai.singleauthenticator.addselector.AddSelectorActivity;
import fr.juliendenadai.singleauthenticator.common.BaseNavigator;
import fr.juliendenadai.singleauthenticator.common.views.BaseActivity;

/**
 * Class used to navigate through the application.
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 04/07/15.
 */
@Singleton
public class Navigator extends BaseNavigator {

    private BaseActivity mContext;

    @Inject
    public void Navigator(BaseActivity context) {
        mContext = context;
    }

    public void openAddActivity() {
        goToActivity(AddSelectorActivity.class, null);
    }

    @Override
    public <A extends BaseActivity>
    void goToActivity(Class<A> activityClass, Bundle extras) {
        if (AddSelectorActivity.class.equals(activityClass)) {
            final Intent intent = new Intent(mContext, activityClass);
            intent.putExtras(extras);
            mContext.startActivityForResult(intent, Constants.ADD_REQUEST_CODE);
        }
    }

    @Override
    public <A extends BaseActivity>
    void goToActivityForResult(Class<A> activityClass,
                               int requestCode,
                               Bundle extras) {
        final Intent intent = new Intent(mContext, activityClass);
        intent.putExtras(extras);
        mContext.startActivityForResult(intent, requestCode);
    }

//    /**
//     * Goes to the user list screen.
//     *
//     * @param context  A Context needed to open the destination activity.
//     * @param fragment Current Fragment reference
//     */
//    public void navigateToAddProfile(@NonNull Context context, @NonNull Fragment fragment) {
//        Intent intentToLaunch = AddProfileActivity.getCallingIntent(context);
//        fragment.startActivityForResult(intentToLaunch, Constants.PROFILE_SUMMARY_REQUEST_CODE);
//    }
//
//    /**
//     * Goes to the profile summary activity
//     *
//     * @param context  A Context needed to open the destination activity.
//     * @param fragment Current Fragment reference
//     * @param profile  Profile to display
//     */
//    public void navigateToProfileSummary(@NonNull Context context,
//                                         @NonNull Fragment fragment,
//                                         ProfileEntity profile) {
//        final Intent intent = new Intent(context, ProfileSummaryActivity.class);
//        intent.putExtra(Constants.EXTRAS_PROFILE, profile);
//        fragment.startActivityForResult(intent, Constants.PROFILE_SUMMARY_REQUEST_CODE);
//    }
//
//    @UiThread
//    public void goBackToAddProfile(@NonNull Activity activity) {
//        activity.setResult(Activity.RESULT_OK);
//        activity.finish();
//    }
//
//    public void goBackToDisplayProfile(@NonNull Activity activity) {
//        activity.setResult(Activity.RESULT_OK);
//        activity.finish();
//    }
//
//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    public void navigateToDetailHero(@NonNull Context context,
//                                     Bundle bundle,
//                                     HeroEntity heroEntity) {
//        final Intent intent = new Intent(context, HeroDetailActivity.class);
//        intent.putExtra(Constants.EXTRAS_HERO, heroEntity);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            context.startActivity(intent, bundle);
//        } else {
//            context.startActivity(intent);
//        }
//    }
}
