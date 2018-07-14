package practicaltask.riseapps.com.practicaltask.ui.countryList;

import java.util.List;

import practicaltask.riseapps.com.practicaltask.data.model.CountryDTO;
import practicaltask.riseapps.com.practicaltask.ui.base.BaseView;

interface CountryListView extends BaseView {

    void showProgress();

    void hideProgress();

    void checkInternetConnection();

    void showNoInternetConnectionError();

    void showCountryList(List<CountryDTO> countryDTOS);

    void showDataExecutionError();
}
