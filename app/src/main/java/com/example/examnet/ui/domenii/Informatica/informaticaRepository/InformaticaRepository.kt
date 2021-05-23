package com.example.examnet.ui.domenii.Informatica.informaticaRepository

import com.example.examnet.ui.domenii.Informatica.informaticaApi.InformaticaRetrofitInstance
import com.example.examnet.ui.domenii.Informatica.informaticaModel.InformaticaResponse
import retrofit2.Response

class InformaticaRepository {

    suspend fun getInformations(): Response<List<InformaticaResponse>> {
        return InformaticaRetrofitInstance.api.getInformations()
    }
}