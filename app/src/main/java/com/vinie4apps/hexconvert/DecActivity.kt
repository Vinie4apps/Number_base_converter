package com.vinie4apps.hexconvert

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.math.BigInteger

@SuppressLint("StaticFieldLeak")
private lateinit var txtbin: TextView
@SuppressLint("StaticFieldLeak")
private lateinit var txtoct: TextView
@SuppressLint("StaticFieldLeak")
private lateinit var txthex: TextView
private lateinit var mAdView : AdView

class DecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dec)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val edittext = findViewById<EditText>(R.id.EditDec)
        txtbin = findViewById<View>(R.id.BinDec) as TextView
        txtoct = findViewById<View>(R.id.OctDec) as TextView
        txthex = findViewById<View>(R.id.HexDec) as TextView
        val bnt = findViewById<Button>(R.id.bntDec)


        bnt.setOnClickListener {

            val strDec = edittext.text

            if(strDec.isEmpty()){
                Toast.makeText(this@DecActivity, "¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show()
            }
            else {

                decToBin(strDec.toString())
                decToOctal(strDec.toString())
                decToHex(strDec.toString())
            }
        }
    }
    private fun decToBin(Bin: String) {
        val bin: String = BigInteger(Bin, 10).toString(2)
        (this.getString(R.string.binary_value) + " " +bin).also { txtbin.text = it }
    }

    private fun decToOctal(Bin: String) {
        val octal: String = BigInteger(Bin, 10).toString(8)
        (this.getString(R.string.octal_value) + " " +octal).also { txtoct.text = it }
    }

    private fun decToHex(Bin: String) {
        val hex: String = BigInteger(Bin, 10).toString(16)
        (this.getString(R.string.hexadecimal_value) + " " +hex).also { txthex.text = it }
    }
}