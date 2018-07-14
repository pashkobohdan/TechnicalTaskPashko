package practicaltask.riseapps.com.practicaltask.storage.preferences;

import io.reactivex.annotations.Nullable;
import practicaltask.riseapps.com.practicaltask.data.enums.Region;

public interface Preferences {

    void saveLastOpenedRegion(Region region);

    @Nullable
    Region getLastOpenedRegion();
}