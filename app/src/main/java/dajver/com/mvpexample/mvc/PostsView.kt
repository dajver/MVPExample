package dajver.com.mvpexample.mvc

import dajver.com.mvpexample.mvc.api.model.PostModel

interface PostsView {
    fun onPostClick(text: PostModel)
    fun showPosts(posts: List<PostModel>)
}
