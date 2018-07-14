package practicaltask.riseapps.com.practicaltask.data.retrofit

import practicaltask.riseapps.com.practicaltask.data.model.CountryDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApi {

    @GET("region/{regionName}")
    fun getRegions(@Path("regionName") resourceName: String): Call<List<CountryDTO>>
}
