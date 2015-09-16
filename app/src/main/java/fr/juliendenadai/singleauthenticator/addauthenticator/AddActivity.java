package fr.juliendenadai.singleauthenticator.addauthenticator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import fr.juliendenadai.singleauthenticator.R;
import fr.juliendenadai.singleauthenticator.addauthenticator.otp.BattlenetFragment;
import fr.juliendenadai.singleauthenticator.addauthenticator.otp.HotpFragment;
import fr.juliendenadai.singleauthenticator.addauthenticator.otp.TotpFragment;
import fr.juliendenadai.singleauthenticator.managers.AuthentManager;
import fr.juliendenadai.singleauthenticator.common.views.BaseActivity;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 11/09/15.
 */
public class AddActivity extends BaseActivity {

    private static final int PAGE_GOOGLE = 0;

    private static final int PAGE_FACEBOOK = 1;

    private static final int PAGE_MICROSOFT = 2;

    private static final int PAGE_BATTLENET = 3;

    private static final int PAGE_HOTP = 4;

    private static final int PAGE_TOTP = 5;

    private static final int PAGE_COUNT = 6;

    @Inject
    AuthentManager mAuthentUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initToolbar();
        initPagerAndTabs();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.addauthenticator_activity;
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initPagerAndTabs() {
        final TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        final ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                final Fragment fragment;
                switch (position) {
                    case PAGE_HOTP:
                        fragment = HotpFragment.newInstance();
                        break;
                    case PAGE_GOOGLE:
                        fragment = TotpFragment.newInstance(Configuration.GOOGLE);
                        break;
                    case PAGE_MICROSOFT:
                        fragment = TotpFragment.newInstance(Configuration.MICROSOFT);
                        break;
                    case PAGE_FACEBOOK:
                        fragment = TotpFragment.newInstance(Configuration.FACEBOOK);
                        break;
                    case PAGE_TOTP:
                        fragment = TotpFragment.newInstance();
                        break;
                    case PAGE_BATTLENET:
                        fragment = BattlenetFragment.newInstance();
                        break;
                    default:
                        fragment = null;
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return PAGE_COUNT;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                final String title;
                switch (position) {
                    case PAGE_GOOGLE:
                        title = getString(R.string.google);
                        break;
                    case PAGE_FACEBOOK:
                        title = getString(R.string.facebook);
                        break;
                    case PAGE_MICROSOFT:
                        title = getString(R.string.microsoft);
                        break;
                    case PAGE_HOTP:
                        title = getString(R.string.hotp);
                        break;
                    case PAGE_TOTP:
                        title = getString(R.string.totp);
                        break;
                    case PAGE_BATTLENET:
                        title = getString(R.string.battlenet);
                        break;
                    default:
                        title = "";
                        break;
                }
                return title;
            }
        });
        tabs.setupWithViewPager(pager);
    }
}
