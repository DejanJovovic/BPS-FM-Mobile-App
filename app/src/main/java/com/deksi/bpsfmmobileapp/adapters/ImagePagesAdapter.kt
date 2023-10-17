package com.deksi.bpsfmmobileapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.deksi.bpsfmmobileapp.model.PageContent
import com.deksi.bpsfmmobileapp.R

class ImagePagesAdapter(private val pages: List<PageContent>, private val context: Context) : PagerAdapter() {

    override fun getCount(): Int = pages.size

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.page_layout, container, false)

        val imageView = view.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(pages[position].imageResId)

        val textView = view.findViewById<TextView>(R.id.text_view)
        textView.text = pages[position].text

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }
}