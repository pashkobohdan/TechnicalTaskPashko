package practicaltask.riseapps.com.practicaltask.dagger.module;

import dagger.Module;
import dagger.Provides;
import practicaltask.riseapps.com.practicaltask.dagger.PerApp;
import practicaltask.riseapps.com.practicaltask.data.retrofit.CountryApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static final String BASE_API_URL = "https://restcountries.eu/rest/v2/";
    private Retrofit retrofit;
    private CountryApi countryApi;

    @Provides
    @PerApp
    public CountryApi provideCountryApi() {
        if (countryApi == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            countryApi = retrofit.create(CountryApi.class);
        }
        return countryApi;
    }
}