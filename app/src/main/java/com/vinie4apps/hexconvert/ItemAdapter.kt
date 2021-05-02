package com.vinie4apps.hexconvert

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class ItemAdapter(var context: Context, var arrayList: ArrayList<ItemModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        var view:View = View.inflate(context, R.layout.grid_item, null)

        var icons: ImageView = view.findViewById(R.id.icons)
        var txt: TextView = view.findViewById(R.id.text)

        var itemmodel: ItemModel = arrayList[position]

        icons.setImageResource(itemmodel.icons!!)
        txt.text = itemmodel.name

        return view
    }
}