package com.example.mitenkodavid.cleanframework.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {
    @GET
    fun search(@Query("limit") limit: Int?, @Query("order") order: String, @Query("sort") sort: String, @Query("filter") filter: String, @Query("include") include: String
    ): Observable
}