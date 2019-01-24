package martin.br.buscacep.api


import martin.br.buscacep.model.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressService {
    @GET("/ws/{cep}/json/")
    fun search(@Path("cep") cep: String): Call<Address>
}