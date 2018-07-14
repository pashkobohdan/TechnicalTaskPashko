package practicaltask.riseapps.com.practicaltask.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import practicaltask.riseapps.com.practicaltask.R
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity
import practicaltask.riseapps.com.practicaltask.ui.base.BaseView
import practicaltask.riseapps.com.practicaltask.ui.regionList.RegionListActivity

class SplashActivity : BaseActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, RegionListActivity::class.java)
            startActivity(intent)
        }, SPLASH_SCREEN_MIN_DELAY)
    }

    companion object {

        private val SPLASH_SCREEN_MIN_DELAY: Long = 2000
    }
}