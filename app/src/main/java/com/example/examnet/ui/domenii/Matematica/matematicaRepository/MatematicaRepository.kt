package com.example.examnet.ui.domenii.Matematica.matematicaRepository


import com.example.examnet.ui.domenii.Matematica.matematicaApi.MatematicaRetrofitInstance
import com.example.examnet.ui.domenii.Matematica.matematicaModel.MatematicaResponse
import retrofit2.Response

class MatematicaRepository {

    suspend fun getInformations(): Response<List<MatematicaResponse>> {
        return MatematicaRetrofitInstance.api.getInformations()
    }
    suspend fun pushPost(post : ArrayList<String>): Response<Int>{
        return MatematicaRetrofitInstance.api2.pushPost(post)
    }
}