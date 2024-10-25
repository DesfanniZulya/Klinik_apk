package com.fani.klinik_apk

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fani.klinik_apk.adapter.AdapterListDoctors
import com.fani.klinik_apk.adapter.AdapterMenuIcon
import com.fani.klinik_apk.model.ModelIcon
import com.fani.klinik_apk.model.ModelListDoctors

class DoctorPageActivity : AppCompatActivity() {
    private lateinit var txtBack : TextView

    private lateinit var RecyclerViewMenu : RecyclerView
    private lateinit var AdapterMenu : AdapterMenuIcon

    private lateinit var RecyclerViewDoctor : RecyclerView
    private lateinit var AdapterDoctor : AdapterListDoctors

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctor_page)

        //data contoh untuk menu
        val menuIcons = listOf(
            ModelIcon(R.drawable.icon_heart,"cardiologist"),
            ModelIcon(R.drawable.icon_eye,"Ophthalmologyst"),
            ModelIcon(R.drawable.icontooth,"Dentist")
        )


        //inisialisasi recyclerview dan adapter
        RecyclerViewMenu = findViewById(R.id.recycleViewMenu)
        RecyclerViewMenu.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        AdapterMenu = AdapterMenuIcon(menuIcons)
        RecyclerViewMenu.adapter = AdapterMenu

        //data untuk dokter
        val menudokter = listOf(
            ModelListDoctors("Dr.Floyd Miles",R.drawable.dokter1,R.drawable.bintang,"Pediatrics","(123 reviews)","4.9"),
            ModelListDoctors("Dr.Guy Hawkins",R.drawable.dokter2,R.drawable.bintang,"Dentist","(85 reviews)","4.9"),
            ModelListDoctors("Dr.Jane Cooper",R.drawable.dokter3,R.drawable.bintang,"Cardiologist","(44 reviews)","4.7"),
            ModelListDoctors("Dr.Jacob Jones",R.drawable.dokter4,R.drawable.bintang,"Nephrologyst","(101 reviews)","5.0"),
            ModelListDoctors("Dr.Savannah Nguyen",R.drawable.dokter5,R.drawable.bintang,"Urologist","(168 reviews)","4.8")
        )

        //inisialisasi recycleview dan adapter
        RecyclerViewDoctor = findViewById(R.id.recycleViewDoctor)
        RecyclerViewDoctor.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        AdapterDoctor= AdapterListDoctors(menudokter)
        RecyclerViewDoctor.adapter = AdapterDoctor


        txtBack = findViewById(R.id.txtBack)

        txtBack.setOnClickListener(){
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}