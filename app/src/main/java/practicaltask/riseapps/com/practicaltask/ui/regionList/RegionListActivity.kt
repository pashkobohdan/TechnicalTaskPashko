package practicaltask.riseapps.com.practicaltask.ui.regionList

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_region_list.*
import practicaltask.riseapps.com.practicaltask.PracticalTaskApp
import practicaltask.riseapps.com.practicaltask.R
import practicaltask.riseapps.com.practicaltask.data.enums.Region
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity
import practicaltask.riseapps.com.practicaltask.ui.countryList.CountryListActivity
import practicaltask.riseapps.com.practicaltask.ui.countryList.CountryListActivity.Companion.REGION_NAME_KEY
import practicaltask.riseapps.com.practicaltask.ui.regionList.adapter.RegionListAdapter
import javax.inject.Inject

class RegionListActivity : BaseActivity(), RegionListView {

    lateinit var adapter: RegionListAdapter

    @Inject
    lateinit var mainPresenter: RegionListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        PracticalTaskApp.getInstance().applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_region_list)
        ButterKnife.bind(this)

        //Указано на всех формах "back", будем возвращать )
        initHeaderButton()
        setTitle(getString(R.string.region_list_header))

        region_recycler_view.setHasFixedSize(true)
        region_recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = RegionListAdapter { mainPresenter.openRegion(it) }
        region_recycler_view.adapter = adapter

        mainPresenter.setView(this)
    }

    override fun showRegionList(regions: List<Region>) {
        adapter.setmDataset(regions)
    }

    override fun openCountryListOfRegion(region: Region) {
        val intent = Intent(this@RegionListActivity, CountryListActivity::class.java)
        intent.putExtra(REGION_NAME_KEY, region.codeName)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.setView(null)
    }
}
