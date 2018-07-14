package practicaltask.riseapps.com.practicaltask.ui.countryList

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_country_list.*
import practicaltask.riseapps.com.practicaltask.PracticalTaskApp
import practicaltask.riseapps.com.practicaltask.R
import practicaltask.riseapps.com.practicaltask.data.model.CountryDTO
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity
import practicaltask.riseapps.com.practicaltask.ui.countryList.adapter.CountryListAdapter
import practicaltask.riseapps.com.practicaltask.ui.utils.InternetCheck
import javax.inject.Inject

class CountryListActivity : BaseActivity(), CountryListView {

    @Inject
    lateinit var mainPresenter: CountryListPresenter

    lateinit private var adapter: CountryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        PracticalTaskApp.getInstance().applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_list)
        ButterKnife.bind(this)

        initPresenterData()

        initHeaderButton()
        setTitle(getString(R.string.country_list_header))

        country_recycler_view.setHasFixedSize(true)
        country_recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = CountryListAdapter { mainPresenter.openCountry(it) }
        country_recycler_view.adapter = adapter

        mainPresenter.setView(this)

        mainPresenter.setView(this)
    }

    private fun initPresenterData() {
        val intent = intent
        if (intent != null) {
            val regionCode = intent.getStringExtra(REGION_NAME_KEY)
            mainPresenter.init(regionCode)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.setView(null)
    }

    override fun showProgress() {
        country_list_progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        country_list_progress.visibility = View.GONE
    }

    override fun checkInternetConnection() {
        InternetCheck { internet -> mainPresenter.internetConnectionChecked(internet) }
    }

    override fun showNoInternetConnectionError() {
        no_internet_connection_warning.visibility = View.VISIBLE
        country_recycler_view.visibility = View.GONE
        Snackbar.make(content, R.string.check_internet_alert, Snackbar.LENGTH_LONG).show()
    }

    override fun showCountryList(countryDTOS: List<CountryDTO>) {
        adapter.setmDataset(countryDTOS)
    }

    override fun showDataExecutionError() {
        Snackbar.make(content, R.string.data_execution_error_alert, Snackbar.LENGTH_LONG).show()
    }

    override fun showCountryDetail(countryDTO: CountryDTO) {
        Toast.makeText(this@CountryListActivity,
                "Country: " + countryDTO.name + ", nothing to do",
                Toast.LENGTH_SHORT).show()
    }

    companion object {
        public val REGION_NAME_KEY = "regionsName"
    }
}
