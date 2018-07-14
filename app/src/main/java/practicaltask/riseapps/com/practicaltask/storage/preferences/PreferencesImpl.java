package practicaltask.riseapps.com.practicaltask.storage.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import practicaltask.riseapps.com.practicaltask.data.enums.Region;

public class PreferencesImpl extends BasePreferences implements Preferences {


    private interface Keys {
        String LAST_OPENED_REGION_KEY = "lastOpenedRegionKey";
    }

    private interface DefaultValues {
        String LAST_OPENED_REGION_DEFAULT_VALUE = "";
    }

    private SharedPreferences sharedPreferences;

    public PreferencesImpl(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    protected SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    @Override
    public void saveLastOpenedRegion(Region region) {
        putString(Keys.LAST_OPENED_REGION_KEY, region.getCodeName());
    }

    @Override
    public Region getLastOpenedRegion() {
        return Region.Companion.getByCodeName(getString(Keys.LAST_OPENED_REGION_KEY, DefaultValues.LAST_OPENED_REGION_DEFAULT_VALUE));
    }
}