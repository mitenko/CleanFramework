package com.example.mitenkodavid.cleanframework.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api.php?action=query&list=search&utf8&format=json")
    fun search(@Query("srsearch") searchParam: String): Observable<Void>
}