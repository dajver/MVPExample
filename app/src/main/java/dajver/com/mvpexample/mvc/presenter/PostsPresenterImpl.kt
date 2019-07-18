package dajver.com.mvpexample.mvc.presenter

import dajver.com.mvpexample.mvc.api.model.PostModel
import dajver.com.mvpexample.mvc.repository.PostsRepository
import dajver.com.mvpexample.mvc.repository.PostsRepositoryImpl
import dajver.com.mvpexample.mvc.PostsView

class PostsPresenterImpl(private val mView: PostsView) : PostsPresenter, PostsRepositoryImpl.OnPostsFetchedListener {

    private val mRepository: PostsRepository

    private var postModelList: ArrayList<PostModel>? = null

    init {
        mRepository = PostsRepositoryImpl(this)
        mRepository.getPosts()
    }

    override fun showPosts(posts: ArrayList<PostModel>) {
        postModelList = posts
        mView.showPosts(postModelList!!)
    }

    override fun onItemWasClicked(position: Int) {
        mView.onPostClick(postModelList!![position])
    }
}
