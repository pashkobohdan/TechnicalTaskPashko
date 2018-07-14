package practicaltask.riseapps.com.practicaltask.ui.countryList;

import java.util.List;

import javax.inject.Inject;

import practicaltask.riseapps.com.practicaltask.data.model.CountryDTO;
import practicaltask.riseapps.com.practicaltask.data.retrofit.CountryApi;
import practicaltask.riseapps.com.practicaltask.ui.base.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryListPresenter extends BasePresenter<CountryListView> {

    @Inject
    protected CountryApi countryApi;
    private String regionCode;

    @Inject
    CountryListPresenter() {
        //For DI
    }

    void init(String regionCode) {
        this.regionCode = regionCode;
    }

    @Override
    protected void onViewAttached() {
        CountryListView view = getView();
        if (view != null) {
            view.showProgress();
            view.checkInternetConnection();
        }
    }

    public void internetConnectionChecked(boolean internet) {
        CountryListView view = getView();
        if (view == null) return;
        view.hideProgress();

        if(internet) {
            view.showProgress();
            readAllCountries();
        } else {
            view.showNoInternetConnectionError();
        }
    }

    private void readAllCountries() {
        countryApi.getRegions(regionCode).enqueue(new Callback<List<CountryDTO>>() {
            @Override
            public void onResponse(Call<List<CountryDTO>> call, Response<List<CountryDTO>> response) {
                CountryListView view = getView();
                if (view != null) {
                    view.showCountryList(response.body());
                    view.hideProgress();
                }
            }

            @Override
            public void onFailure(Call<List<CountryDTO>> call, Throwable t) {
                CountryListView view = getView();
                if (view != null) {
                    view.showDataExecutionError();
                    view.hideProgress();
                }
            }
        });
    }

    public void openCountry(CountryDTO countryDTO) {
        CountryListView view = getView();
        if (view != null) {
            view.showCountryDetail(countryDTO);
        }
    }
}
