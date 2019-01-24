package martin.br.buscacep.model

import com.google.gson.annotations.SerializedName

data class Address(
        val cep: String,
        val logradouro: String,
        val complemento: String,
        val bairro: String,
        val localidade: String,
        @SerializedName("uf") val estado: String
)
