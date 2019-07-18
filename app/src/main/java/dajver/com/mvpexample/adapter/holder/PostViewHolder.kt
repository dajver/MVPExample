package dajver.com.mvpexample.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dajver.com.mvpexample.adapter.PostRecyclerAdapter
import dajver.com.mvpexample.api.model.PostModel
import kotlinx.android.synthetic.main.item_posts.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(postModel: PostModel, onItemCLickListener: PostRecyclerAdapter.OnItemCLickListener?) {
        itemView.name.text = postModel.title
        itemView.content.text = postModel.body

        itemView.setOnClickListener {
            onItemCLickListener!!.onItemCLick(adapterPosition)
        }
    }
}
