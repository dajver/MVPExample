package dajver.com.mvpexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dajver.com.mvpexample.adapter.PostRecyclerAdapter
import dajver.com.mvpexample.mvc.PostsView
import dajver.com.mvpexample.mvc.api.model.PostModel
import dajver.com.mvpexample.mvc.presenter.PostsPresenter
import dajver.com.mvpexample.mvc.presenter.PostsPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PostsView {

    private var mPresenter: PostsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = PostsPresenterImpl(this)
    }

    override fun showPosts(posts: List<PostModel>) {
        val adapter = PostRecyclerAdapter(posts)
        adapter.setOnItemClickListener(object: PostRecyclerAdapter.OnItemCLickListener {
            override fun onItemCLick(position: Int) {
                mPresenter!!.onItemWasClicked(position)
            }
        })
        recyclerView.adapter = adapter
    }

    override fun onPostClick(text: PostModel) {
        Toast.makeText(this, text.body, Toast.LENGTH_LONG).show()
    }
}
