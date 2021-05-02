package com.vinie4apps.hexconvert

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var gridView:GridView ? = null
    private var arrayList:ArrayList<ItemModel> ? = null
    private var itemAdapter:ItemAdapter ? = null
    lateinit var mAdView : AdView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        gridView = findViewById(R.id.gridv)
        arrayList = ArrayList()
        arrayList = setDataList()
        itemAdapter = ItemAdapter(applicationContext, arrayList!!)
        gridView?.adapter = itemAdapter
        gridView?.onItemClickListener = this
    }

    private fun setDataList() :ArrayList<ItemModel>{

        val arrayList:ArrayList<ItemModel> = ArrayList()

        arrayList.add(ItemModel(R.drawable.base2, "Base 2"))
        arrayList.add(ItemModel(R.drawable.base8, "Base 8"))
        arrayList.add(ItemModel(R.drawable.base10, "Base 10"))
        arrayList.add(ItemModel(R.drawable.base16, "Base 16"))


        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val itemAdapter: ItemModel = arrayList!![position]

        when (itemAdapter.name) {
            "Base 2" -> {
                val intent = Intent(this,BinActivity::class.java)
                startActivity(intent)
            }
            "Base 8" -> {
                val intent = Intent(this,OctalActivity::class.java)
                startActivity(intent)
            }
            "Base 10" -> {
                val intent = Intent(this,DecActivity::class.java)
                startActivity(intent)
            }
            "Base 16" -> {
                val intent = Intent(this,HexActivity::class.java)
                startActivity(intent)
            }
        }

    }
}