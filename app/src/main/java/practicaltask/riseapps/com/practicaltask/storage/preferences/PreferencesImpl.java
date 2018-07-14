package practicaltask.riseapps.com.practicaltask.storage.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import practicaltask.riseapps.com.practicaltask.data.enums.Region;

public class PreferencesImpl extends BasePreferences implements Preferences {

    private static final String LAST_OPENED_REGION_KEY = "lastOpenedRegionKey";

    private interface Keys {
    }

    private interface DefaultValues {
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
        sharedPreferences.edit().putString(LAST_OPENED_REGION_KEY, region.getCodeName()).apply();
    }

    @Override
    public Region getLastOpenedRegion() {
        return Region.getByCodeName(sharedPreferences.getString(LAST_OPENED_REGION_KEY, ""));
    }
}