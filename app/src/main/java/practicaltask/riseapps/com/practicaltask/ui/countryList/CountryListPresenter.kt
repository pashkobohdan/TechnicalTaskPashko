package practicaltask.riseapps.com.practicaltask.ui.countryList

import practicaltask.riseapps.com.practicaltask.data.model.CountryDTO
import practicaltask.riseapps.com.practicaltask.data.retrofit.CountryApi
import practicaltask.riseapps.com.practicaltask.ui.base.BasePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CountryListPresenter @Inject internal constructor() : BasePresenter<CountryListView>() {

    @Inject
    lateinit var countryApi: CountryApi
    lateinit var regionCode: String

    fun init(regionCode: String) {
        this.regionCode = regionCode
    }

    override fun onViewAttached() {
        view?.showProgress()
        view?.checkInternetConnection()
    }

    fun internetConnectionChecked(internet: Boolean) {
        view?.hideProgress()

        if (internet) {
            view?.showProgress()
            readAllCountries()
        } else {
            view?.showNoInternetConnectionError()
        }
    }

    private fun readAllCountries() {
        countryApi.getRegions(regionCode).enqueue(object : Callback<List<CountryDTO>> {
            override fun onResponse(call: Call<List<CountryDTO>>, response: Response<List<CountryDTO>>) {
                view?.showCountryList(response.body()!!)
                view?.hideProgress()
            }

            override fun onFailure(call: Call<List<CountryDTO>>, t: Throwable) {
                view?.showDataExecutionError()
                view?.hideProgress()
            }
        })
    }

    fun openCountry(countryDTO: CountryDTO) {
        view?.showCountryDetail(countryDTO)
    }
}
