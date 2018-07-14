package practicaltask.riseapps.com.practicaltask.ui.regionList

import practicaltask.riseapps.com.practicaltask.data.enums.Region
import practicaltask.riseapps.com.practicaltask.ui.base.BaseView

interface RegionListView : BaseView {

    fun showRegionList(regions: List<Region>)

    fun openCountryListOfRegion(region: Region)
}
