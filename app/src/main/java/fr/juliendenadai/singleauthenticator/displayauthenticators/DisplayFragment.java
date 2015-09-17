package fr.juliendenadai.singleauthenticator.displayauthenticators;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import butterknife.InjectView;
import fr.juliendenadai.singleauthenticator.R;
import fr.juliendenadai.singleauthenticator.models.Authenticator;
import fr.juliendenadai.singleauthenticator.utils.Constants;
import fr.juliendenadai.singleauthenticator.common.views.BaseFragment;

/**
 * Created by Julien De Nadai<julien.denadai@gmail.com> on 12/09/15.
 */
public class DisplayFragment extends BaseFragment<DisplayPresenter>
        implements DisplayView {

    @InjectView(R.id.recyclerview)
    RecyclerView mRecycler;

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.fab)
    FloatingActionButton mFab;

    private DisplayAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.displayauthenticators_fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        menu.clear();
//        inflater.inflate(R.menu.menu_profile, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = false;
        //TODO: handle menu click
        return result;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeToolbar();
        initializeFab();
        initializeRecyclerView();
    }

    @Override
    protected void initializeDependencyInjector() {
        DaggerDisplayComponent.builder()
                .activityModule(getActivityModule())
                .applicationComponent(getApplicationComponent())
                .build()
                .inject(this);
        Log.d(Constants.TAG, "di initialized");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mPresenter.onAddClose(requestCode, resultCode, data);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Intent callingIntent = mActivity.getIntent();
        mPresenter.parseIntent(callingIntent);
    }

    private void initializeToolbar() {
        mActivity.setSupportActionBar(mToolbar);
    }

    private void initializeFab() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.clickFab();
            }
        });
    }

    private void initializeRecyclerView() {
        mRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        mAdapter = new DisplayAdapter(getContext());
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void addAuthenticator(Authenticator authenticator) {
        mAdapter.addAuthenticator(authenticator);
    }
}
