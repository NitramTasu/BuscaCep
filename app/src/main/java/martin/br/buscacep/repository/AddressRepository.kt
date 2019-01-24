package martin.br.buscacep.repository


import martin.br.buscacep.api.ClientAPI
import martin.br.buscacep.api.getAddressService
import martin.br.buscacep.model.Address
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddressRepository {

    fun search(cep: String
               , onComplete: (Address?) -> Unit
               , onError: (Throwable?) -> Unit) {
        getAddressService().search(cep).enqueue(object : Callback<Address>{
            override fun onFailure(call: Call<Address>?, t: Throwable?) {
                onError(t)
            }

            override fun onResponse(call: Call<Address>?, response: Response<Address>?) {
                if (response?.isSuccessful == true){
                    onComplete(response?.body())
                }else{
                    onError(Throwable("Não foi possivel buscar o endereco"))
                }
            }

        })
    }
}