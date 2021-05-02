package com.vinie4apps.hexconvert

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.math.BigInteger
import java.util.*

@SuppressLint("StaticFieldLeak")
private lateinit var txtdec: TextView
@SuppressLint("StaticFieldLeak")
private lateinit var txtoct: TextView
@SuppressLint("StaticFieldLeak")
private lateinit var txthex: TextView
private lateinit var mAdView : AdView

class BinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bin)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val edittext = findViewById<EditText>(R.id.EditBin)
        txtdec = findViewById<View>(R.id.DecBin) as TextView
        txtoct = findViewById<View>(R.id.OctBin) as TextView
        txthex = findViewById<View>(R.id.HexBin) as TextView
        val bnt = findViewById<Button>(R.id.bntBin)

        val strBin = edittext.text

        bnt.setOnClickListener {

            binToDec(strBin.toString())
            binToOctal(strBin.toString())
            binToHex(strBin.toString())

        }
    }
    private fun binToDec(Bin: String) {
        val dec: String = BigInteger(Bin, 2).toString(10)
        (this.getString(R.string.decimal_value) + " " +dec).also { txtdec.text = it }
    }

    private fun binToOctal(Bin: String) {
        val octal: String = BigInteger(Bin, 2).toString(8)
        (this.getString(R.string.octal_value) + " " +octal).also { txtoct.text = it }
    }

    private fun binToHex(Bin: String) {
        val hex: String = BigInteger(Bin, 2).toString(16)
        (this.getString(R.string.hexadecimal_value) + " " +hex).also { txthex.text = it }
    }
}