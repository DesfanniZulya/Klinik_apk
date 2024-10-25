package com.fani.klinik_apk

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fani.klinik_apk.adapter.AdapterMenuIcon
import com.fani.klinik_apk.model.ModelIcon

class HomeActivity : AppCompatActivity() {
    private lateinit var txtseeall : TextView

    private lateinit var RecyclerViewMenu : RecyclerView
    private lateinit var AdapterMenu : AdapterMenuIcon

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val menuIcons = listOf(
            ModelIcon(R.drawable.icon_heart,"cardiologist"),
            ModelIcon(R.drawable.icon_eye,"Ophthalmologyst"),
            ModelIcon(R.drawable.icontooth,"Dentist")
        )

        //inisialisasi recyclerview dan adapter
        RecyclerViewMenu = findViewById(R.id.recycleViewMenuhome)
        RecyclerViewMenu.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        AdapterMenu = AdapterMenuIcon(menuIcons)
        RecyclerViewMenu.adapter = AdapterMenu

        txtseeall=findViewById(R.id.txtSeeAll)
        txtseeall.setOnClickListener(){
            val intent = Intent(this,DoctorPageActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}