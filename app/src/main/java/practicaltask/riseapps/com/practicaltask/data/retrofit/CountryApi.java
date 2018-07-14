package practicaltask.riseapps.com.practicaltask.data.retrofit;

import java.util.List;

import practicaltask.riseapps.com.practicaltask.data.model.CountryDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CountryApi {

    @GET("region/{regionName}")
    Call<List<CountryDTO>> getRegions(@Path("regionName") String resourceName);
}
