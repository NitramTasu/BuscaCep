package martin.br.buscacep.repository.ui.search

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import martin.br.buscacep.model.Address
import martin.br.buscacep.repository.AddressRepository

class SearchViewModel: ViewModel(){

    val addressRepository =  AddressRepository()

    val address = MutableLiveData<Address>()
    val errorMessage = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun search(cep: String){
        isLoading.value = true
        addressRepository.search(cep,
                onComplete = {
                    address.value = it
                    errorMessage.value = ""
                    isLoading.value = false

                }, onError = {
                    address.value = null
                    errorMessage.value = it?.message
                    isLoading.value = false
                })

    }
}