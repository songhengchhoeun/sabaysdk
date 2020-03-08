package kh.com.mysabay.sdk.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import kh.com.mysabay.sdk.Apps;
import kh.com.mysabay.sdk.Globals;
import kh.com.mysabay.sdk.R;
import kh.com.mysabay.sdk.base.BaseActivity;
import kh.com.mysabay.sdk.di.component.UserComponent;
import kh.com.mysabay.sdk.ui.fragment.LoginFragment;

public class LoginActivity extends BaseActivity {

    private static final int DELAY = 1000;

    private FragmentManager mManager;
    private Handler mHandler;

    // Reference to the main graph
    public UserComponent userComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // Creation of the main graph using the application graph
        userComponent = Apps.getInstance().mComponent.mainComponent().create();
        // Make Dagger instantiate @Inject fields in MaiActivity
        userComponent.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    public void initializeObjects(Bundle args) {
        mManager = getSupportFragmentManager();
        mHandler = new Handler();
        initAddFragment(LoginFragment.newInstance(), LoginFragment.TAG);
    }

    @Override
    public void assignValues() {

    }

    @Override
    public void addListeners() {

    }

    @Override
    public void onActionAfterCreated() {

    }

    @Override
    protected View getCoordinateLayout() {
        return null;
    }

    public void initAddFragment(Fragment f, String tag) {
        initAddFragment(f, tag, false);
    }

    public void initAddFragment(Fragment f, String tag, boolean isBack) {
        Globals.initAddFragment(mManager, f, tag, isBack);
    }

}
