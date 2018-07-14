package practicaltask.riseapps.com.practicaltask.ui.countryList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import practicaltask.riseapps.com.practicaltask.PracticalTaskApp;
import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.data.model.CountryDTO;
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity;
import practicaltask.riseapps.com.practicaltask.ui.countryList.adapter.CountryListAdapter;
import practicaltask.riseapps.com.practicaltask.ui.utils.InternetCheck;

public class CountryListActivity extends BaseActivity implements CountryListView {
    public static final String REGION_NAME_KEY = "regionsName";

    @Inject
    protected CountryListPresenter mainPresenter ;

    @BindView(R.id.country_list_progress)
    protected ProgressBar progressBar;
    @BindView(R.id.country_recycler_view)
    protected RecyclerView countryRecyclerView;

    private CountryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PracticalTaskApp.getInstance().getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_list);
        ButterKnife.bind(this);

        initPresenterData();

        initHeaderButton();

        countryRecyclerView.setHasFixedSize(true);
        countryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CountryListAdapter(mainPresenter::openCountry);
        countryRecyclerView.setAdapter(adapter);

        mainPresenter.setView(this);

        mainPresenter.setView(this);
    }

    private void initPresenterData() {
        Intent intent = getIntent();
        if(intent != null ) {
            String regionCode = intent.getStringExtra(REGION_NAME_KEY);
            mainPresenter.init(regionCode);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.setView(null);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void checkInternetConnection() {
        new InternetCheck(internet -> { mainPresenter.internetConnectionChecked(internet); });
    }

    @Override
    public void showNoInternetConnectionError() {
        //TODO
    }

    @Override
    public void showCountryList(List<CountryDTO> countryDTOS) {
        adapter.setmDataset(countryDTOS);
    }

    @Override
    public void showDataExecutionError() {
//        Snackbar.make(parentLayout, "This is main activity", Snackbar.LENGTH_LONG));
    }
}