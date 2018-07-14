package practicaltask.riseapps.com.practicaltask.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity;
import practicaltask.riseapps.com.practicaltask.ui.regionList.RegionListActivity;

public class MainActivity extends BaseActivity implements MainView {

    private static final long SPLASH_SCREEN_MIN_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(()-> {
            Intent intent = new Intent(MainActivity.this, RegionListActivity.class);
            startActivity(intent);
        },SPLASH_SCREEN_MIN_DELAY);
    }
}