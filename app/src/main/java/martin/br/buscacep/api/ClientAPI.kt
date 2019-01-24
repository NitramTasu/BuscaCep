package martin.br.buscacep.api

import android.bluetooth.le.AdvertiseData
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientAPI<T>{
    fun getClient(c: Class<T>): T{
        val okHttp = OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor()).build()
        var retrofit: Retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://viacep.com.br/")
                .client(okHttp)
                .build()


        return retrofit.create(c)
    }
}

fun getAddressService(): AddressService{
    return ClientAPI<AddressService>().getClient(AddressService::class.java)
}