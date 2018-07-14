package practicaltask.riseapps.com.practicaltask.ui.base;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity implements BaseView {


    protected void initHeaderButton() {
        ActionBar actionBar = BaseActivity.this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    protected void setTitle(String title) {
        ActionBar actionBar = BaseActivity.this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}