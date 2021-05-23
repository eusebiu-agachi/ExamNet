package com.example.examnet.ui.domenii.Biologie.biologieRepository

import com.example.examnet.ui.domenii.Biologie.biologieApi.BiologieRetrofitInstance
import com.example.examnet.ui.domenii.Biologie.biologieModel.BiologieResponse
import retrofit2.Response

class BiologieRepository {

    suspend fun getInformations(): Response<List<BiologieResponse>> {
        return BiologieRetrofitInstance.api.getInformations()
    }

    suspend fun pushPost(post : ArrayList<String>): Response<Int>{
        return BiologieRetrofitInstance.api2.pushPost(post)
    }
}