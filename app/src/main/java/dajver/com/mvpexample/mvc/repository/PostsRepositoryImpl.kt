package dajver.com.mvpexample.mvc.repository

import dajver.com.mvpexample.api.RestClient
import dajver.com.mvpexample.api.model.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsRepositoryImpl(private val onPostsFetchedListener: OnPostsFetchedListener) : PostsRepository {

    override fun getPosts() {
        RestClient.instance().posts.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                if(response.code() < 400) {
                    onPostsFetchedListener.showPosts(response.body()!! as ArrayList<PostModel>)
                }
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    interface OnPostsFetchedListener {
        fun showPosts(posts: ArrayList<PostModel>)
    }
}
