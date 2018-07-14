package practicaltask.riseapps.com.practicaltask.ui.countryList

import practicaltask.riseapps.com.practicaltask.data.model.CountryDTO
import practicaltask.riseapps.com.practicaltask.ui.base.BaseView

interface CountryListView : BaseView {

    fun showProgress()

    fun hideProgress()

    fun checkInternetConnection()

    fun showNoInternetConnectionError()

    fun showCountryList(countryDTOS: List<CountryDTO>)

    fun showDataExecutionError()

    fun showCountryDetail(countryDTO: CountryDTO)
}
