package dajver.com.mvpexample.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RestClient {

    private val service: API

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(API::class.java)
    }

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private val instance = RestClient()

        fun instance(): API {
            return instance.service
        }
    }
}
