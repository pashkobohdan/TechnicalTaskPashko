package practicaltask.riseapps.com.practicaltask.ui.regionList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import practicaltask.riseapps.com.practicaltask.data.enums.Region;
import practicaltask.riseapps.com.practicaltask.storage.preferences.Preferences;
import practicaltask.riseapps.com.practicaltask.ui.base.BasePresenter;

public class RegionListPresenter extends BasePresenter<RegionListView> {

    @Inject
    protected Preferences preferences;

    @Inject
    RegionListPresenter() {
        //For DI
    }

    @Override
    protected void onViewAttached() {
        RegionListView view = getView();
        if (view != null) {
            view.showRegionList(sortWithLastOpened(new ArrayList<Region>(Arrays.asList(Region.values()))));
        }
    }

    private List<Region> sortWithLastOpened(List<Region> regions) {
        Region lastOpenedRegion = preferences.getLastOpenedRegion();
        if (lastOpenedRegion != null && regions.contains(lastOpenedRegion)) {
            regions.remove(lastOpenedRegion);
            regions.add(0, lastOpenedRegion);
        }
        return regions;
    }

    public void openRegion(Region region) {
        saveLastOpenedRegion(region);
        RegionListView view = getView();
        if (view != null) {
            view.openCountryListOfRegion(region);
        }
    }

    private void saveLastOpenedRegion(Region region) {
        preferences.saveLastOpenedRegion(region);
    }
}
