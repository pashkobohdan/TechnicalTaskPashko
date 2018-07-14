package practicaltask.riseapps.com.practicaltask.ui.regionList

import practicaltask.riseapps.com.practicaltask.data.enums.Region
import practicaltask.riseapps.com.practicaltask.storage.preferences.Preferences
import practicaltask.riseapps.com.practicaltask.ui.base.BasePresenter
import javax.inject.Inject

class RegionListPresenter @Inject internal constructor() : BasePresenter<RegionListView>() {

    @Inject
    lateinit var preferences: Preferences

    override fun onViewAttached() {
        view?.showRegionList(sortWithLastOpened(Region.values().toMutableList()))
    }

    private fun sortWithLastOpened(regions: MutableList<Region>): List<Region> {
        val lastOpenedRegion = preferences.lastOpenedRegion
        if (lastOpenedRegion != null && regions.contains(lastOpenedRegion)) {
            regions.remove(lastOpenedRegion)
            regions.add(0, lastOpenedRegion)
        }
        return regions
    }

    fun openRegion(region: Region) {
        saveLastOpenedRegion(region)
        view?.openCountryListOfRegion(region)
    }

    private fun saveLastOpenedRegion(region: Region) {
        preferences.saveLastOpenedRegion(region)
    }
}
