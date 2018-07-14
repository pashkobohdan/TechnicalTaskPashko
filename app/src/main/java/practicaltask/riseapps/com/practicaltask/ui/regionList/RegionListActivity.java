package practicaltask.riseapps.com.practicaltask.ui.regionList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import practicaltask.riseapps.com.practicaltask.PracticalTaskApp;
import practicaltask.riseapps.com.practicaltask.R;
import practicaltask.riseapps.com.practicaltask.data.enums.Region;
import practicaltask.riseapps.com.practicaltask.ui.base.BaseActivity;
import practicaltask.riseapps.com.practicaltask.ui.countryList.CountryListActivity;
import practicaltask.riseapps.com.practicaltask.ui.regionList.adapter.RegionListAdapter;

import static practicaltask.riseapps.com.practicaltask.ui.countryList.CountryListActivity.REGION_NAME_KEY;

public class RegionListActivity extends BaseActivity implements RegionListView {

    @BindView(R.id.region_recycler_view)
    protected RecyclerView regionsRecyclerView;

    private RegionListAdapter adapter;

    @Inject
    protected RegionListPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PracticalTaskApp.getInstance().getApplicationComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region_list);
        ButterKnife.bind(this);

        //Указано на всех формах "back", будем возвращать )
        initHeaderButton();
        setTitle(getString(R.string.region_list_header));

        regionsRecyclerView.setHasFixedSize(true);
        regionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RegionListAdapter(mainPresenter::openRegion);
        regionsRecyclerView.setAdapter(adapter);

        mainPresenter.setView(this);
    }

    @Override
    public void showRegionList(List<Region> regions) {
        adapter.setmDataset(regions);
    }

    @Override
    public void openCountryListOfRegion(Region region) {
        Intent intent = new Intent(RegionListActivity.this, CountryListActivity.class);
        intent.putExtra(REGION_NAME_KEY, region.getCodeName());
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.setView(null);
    }
}
