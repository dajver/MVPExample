package dajver.com.mvpexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dajver.com.mvpexample.R
import dajver.com.mvpexample.adapter.holder.PostViewHolder
import dajver.com.mvpexample.api.model.PostModel

class PostRecyclerAdapter(private val postList: List<PostModel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onItemCLickListener: OnItemCLickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_posts, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as PostViewHolder
        viewHolder.bind(postList[position], onItemCLickListener)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun setOnItemClickListener(onItemClickListener: OnItemCLickListener) {
        this.onItemCLickListener = onItemClickListener
    }

    interface OnItemCLickListener {
        fun onItemCLick(position: Int)
    }
}
