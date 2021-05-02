package com.vinie4apps.hexconvert

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.math.BigInteger

@SuppressLint("StaticFieldLeak")
private lateinit var txtbin: TextView
@SuppressLint("StaticFieldLeak")
private lateinit var txtdec: TextView
@SuppressLint("StaticFieldLeak")
private lateinit var txthex: TextView
private lateinit var mAdView : AdView

class OctalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_octal)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val edittext = findViewById<EditText>(R.id.EditOctal)
        txtbin = findViewById<View>(R.id.BinOctal) as TextView
        txtdec = findViewById<View>(R.id.DecOctal) as TextView
        txthex = findViewById<View>(R.id.HexOctal) as TextView
        val bnt = findViewById<Button>(R.id.bntOctal)

        val strOctal = edittext.text

        bnt.setOnClickListener {

            hexToBin(strOctal.toString())
            hexToOctal(strOctal.toString())
            hexToDec(strOctal.toString())

        }
    }
    private fun hexToBin(Bin: String) {
        val bin: String = BigInteger(Bin, 8).toString(2)
        (this.getString(R.string.binary_value) + " " +bin).also { txtbin.text = it }
    }

    private fun hexToOctal(Bin: String) {
        val dec: String = BigInteger(Bin, 8).toString(10)
        (this.getString(R.string.octal_value) + " " +dec).also { txtdec.text = it }
    }

    private fun hexToDec(Bin: String) {
        val hex: String = BigInteger(Bin, 8).toString(16)
        (this.getString(R.string.decimal_value) + " " +hex).also { txtdec.text = it }
    }
}