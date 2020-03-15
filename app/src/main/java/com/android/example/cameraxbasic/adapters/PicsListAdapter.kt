package com.android.example.cameraxbasic.adapters

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.cameraxbasic.R
import com.android.example.cameraxbasic.data.Pics
import com.android.example.cameraxbasic.utils.inflate
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pics_list_item.view.*

class PicsListAdapter(private val pics:ArrayList<Pics>): RecyclerView.Adapter<PicsListAdapter.PicsHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicsHolder {

        val inflatedView = parent.inflate(R.layout.pics_list_item, false)
        return PicsHolder(inflatedView)
    }


    override fun getItemCount(): Int {
        Log.d("###","toatat no of items in the list is "+pics.size)
        return pics.size
    }

    override fun onBindViewHolder(holder: PicsHolder, position: Int) {
        val pic = pics[position]
        holder.bindQuote(pic)
    }

    class PicsHolder(view: View): RecyclerView.ViewHolder(view) {
        companion object{
            private val Pic_Key = "Pic"
        }

        fun bindQuote(pic:Pics)
        {
            Picasso.get().load(pic.imageUrl).fit().centerCrop().into(itemView.image)
            itemView.name.setText(pic.name)
        }

    }
}