package com.deksi.bpsfmmobileapp.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.deksi.bpsfmmobileapp.R
import com.deksi.bpsfmmobileapp.home.model.Notifications

class NotificationsAdapter(context: Context, private val items: List<Notifications>) :
    ArrayAdapter<Notifications>(context, R.layout.list_item, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        if (itemView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.list_item, null)
        }

        val item = items[position]

        val itemDescription = itemView?.findViewById<TextView>(R.id.text_view_description)
        val itemImage = itemView?.findViewById<ImageView>(R.id.image_view_date)
        val itemDate = itemView?.findViewById<TextView>(R.id.text_view_date)


        itemDescription?.text = item.description
        itemImage?.setImageResource(item.image)
        itemDate?.text = item.date


        return itemView!!
    }
}