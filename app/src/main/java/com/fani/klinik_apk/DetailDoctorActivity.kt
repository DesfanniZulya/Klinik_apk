package com.fani.klinik_apk

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailDoctorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_doctor)

        val namaDoctor = intent.getStringExtra("namaDoctor")
        val Photo = intent.getIntExtra("photoDoctor",0)
        val ahli = intent.getStringExtra("ahli")
        val review = intent.getStringExtra("review")
        val gambarBintang = intent.getIntExtra("photoBintang",0)
        val rating = intent.getStringExtra("rating")

        val txtnama = findViewById<TextView>(R.id.txtNamaDoctor)
        val imgphoto = findViewById<ImageView>(R.id.imgDoctor)
        val txtbidang = findViewById<TextView>(R.id.txtBidang)
        val txtjumlahreview = findViewById<TextView>(R.id.txtJumlahReview)
        val imgbintang = findViewById<ImageView>(R.id.imgBintang)
        val jumlahrating = findViewById<TextView>(R.id.txtJumlahRating)

        txtnama.text = namaDoctor
        imgphoto.setImageResource(Photo)
        txtbidang.text = ahli
        txtjumlahreview.text = review
        imgbintang.setImageResource(gambarBintang)
        jumlahrating.text = rating



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}