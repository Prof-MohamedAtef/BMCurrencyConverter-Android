package mo.ed.bankmisr.api

import mo.ed.bankmisr.BuildConfig
import mo.ed.bankmisr.models.responses.currencies.GetCurrenciesResponse
import mo.ed.bankmisr.utils.NetworkResultWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api/symbols")
    fun getCurrencies(
        @Query("access_key") key: String = BuildConfig.Fixer_API_KEY,
    ): NetworkResultWrapper<GetCurrenciesResponse?>
}