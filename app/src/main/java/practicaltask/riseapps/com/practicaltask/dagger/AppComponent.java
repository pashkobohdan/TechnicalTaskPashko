package practicaltask.riseapps.com.practicaltask.dagger;

import dagger.Component;
import practicaltask.riseapps.com.practicaltask.dagger.module.AppModule;
import practicaltask.riseapps.com.practicaltask.dagger.module.GlobalModule;
import practicaltask.riseapps.com.practicaltask.dagger.module.NetworkModule;
import practicaltask.riseapps.com.practicaltask.ui.countryList.CountryListActivity;
import practicaltask.riseapps.com.practicaltask.ui.regionList.RegionListActivity;

@PerApp
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        GlobalModule.class
})
public interface AppComponent {

    void inject(RegionListActivity activity);

    void inject(CountryListActivity activity);
}