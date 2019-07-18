package dajver.com.mvpexample.mvc.api

import dajver.com.mvpexample.mvc.api.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @get:GET("posts")
    val posts: Call<List<PostModel>>
}
