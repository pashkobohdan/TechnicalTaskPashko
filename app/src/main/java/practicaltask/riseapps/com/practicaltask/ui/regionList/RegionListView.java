package practicaltask.riseapps.com.practicaltask.ui.regionList;

import java.util.List;

import practicaltask.riseapps.com.practicaltask.data.enums.Region;
import practicaltask.riseapps.com.practicaltask.ui.base.BaseView;

public interface RegionListView extends BaseView {

    void showRegionList(List<Region> regions);

    void openCountryListOfRegion(Region region);
}
