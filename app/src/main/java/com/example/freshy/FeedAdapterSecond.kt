package com.example.freshy

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.lang.Exception

class ViewHolderSecond(v: View) {
    val tvName: TextView = v.findViewById(R.id.tvName)
    val tvArtist: TextView = v.findViewById(R.id.tvArtist)
    val tvSummary: TextView = v.findViewById(R.id.tvSummary)
}
class FeedAdapterSecond(
    context: Context,
    private val resource: Int,
    private val applications: List<FeedSecondEntry>
) :
    ArrayAdapter<FeedEntry>(context, resource) {
    private val inflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return applications.size
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        Log.d(TAG, "getView called")
        val view: View
        val viewHolder: ViewHolderSecond
        if (convertView == null) {
            view = inflater.inflate(resource, parent, false)
            viewHolder = ViewHolderSecond(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolderSecond
        }


        val curremtApp = applications[position]
        Log.d(TAG, "Item inserted")

        viewHolder.tvName.text = (position + 1).toString() + "." + curremtApp.name
        viewHolder.tvArtist.text = curremtApp.artist
        if(curremtApp.summary==""){
            viewHolder.tvSummary.text=curremtApp.rights
        }else{
            viewHolder.tvSummary.text=curremtApp.summary
        }
        return view
    }
}