package com.example.freshy

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.lang.Exception

class ViewHolder(v: View) {
    val tvName: TextView = v.findViewById(R.id.tvName)
    val tvArtist: TextView = v.findViewById(R.id.tvArtist)
    val tvSummary: TextView = v.findViewById(R.id.tvSummary)
}

const val TAG: String = "FeedAdapter"

class FeedAdapter(
    context: Context,
    private val resource: Int,
    private val applications: List<FeedEntry>
) :
    ArrayAdapter<FeedEntry>(context, resource) {
    private val inflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return applications.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        Log.d(TAG, "getView called")
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = inflater.inflate(resource, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }


        val curremtApp = applications[position]
        Log.d(TAG, "Item inserted")

        viewHolder.tvName.text = (position + 1).toString() + "." + curremtApp.title
        viewHolder.tvArtist.text = curremtApp.pubDate
        if ("</a>" in curremtApp.description) {
            val temp = curremtApp.description.split("</a>")
            try {
                viewHolder.tvSummary.text = temp[1]
            } catch (e: Exception) {
                viewHolder.tvSummary.text = ""
            }
        } else if ("/>" in curremtApp.description) {
            val temp = curremtApp.description.split("/>")
            try {
                viewHolder.tvSummary.text = temp[1]
            } catch (e: Exception) {
                viewHolder.tvSummary.text = ""
            }
            if (curremtApp.category != "") {
                viewHolder.tvSummary.text = "GENRE : " + curremtApp.category
            }
        }else{
            viewHolder.tvSummary.text=curremtApp.description
        }
        return view
    }
}