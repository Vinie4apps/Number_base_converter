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
private lateinit var txtdec: TextView
private lateinit var mAdView : AdView

class HexActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hex)

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val edittext = findViewById<EditText>(R.id.EditHex)
        txtbin = findViewById<View>(R.id.BinHex) as TextView
        txtoct = findViewById<View>(R.id.OctHex) as TextView
        txtdec = findViewById<View>(R.id.DecHex) as TextView
        val bnt = findViewById<Button>(R.id.bntHex)



        bnt.setOnClickListener {

            val strHex = edittext.text

            if(strHex.isEmpty()){
                Toast.makeText(this@HexActivity, "¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show()
            }
            else {

                hexToBin(strHex.toString())
                hexToOctal(strHex.toString())
                hexToDec(strHex.toString())
            }
        }
    }
    private fun hexToBin(Bin: String) {
        val bin: String = BigInteger(Bin, 16).toString(2)
        (this.getString(R.string.binary_value) + " " +bin).also { txtbin.text = it }
    }

    private fun hexToOctal(Bin: String) {
        val octal: String = BigInteger(Bin, 16).toString(8)
        (this.getString(R.string.octal_value) + " " +octal).also { txtoct.text = it }
    }

    private fun hexToDec(Bin: String) {
        val dec: String = BigInteger(Bin, 16).toString(10)
        (this.getString(R.string.decimal_value) + " " +dec).also { txtdec.text = it }
    }
}