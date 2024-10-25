package com.fani.klinik_apk.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fani.klinik_apk.DetailDoctorActivity
import com.fani.klinik_apk.R
import com.fani.klinik_apk.model.ModelListDoctors



class AdapterListDoctors(
    val itemListDoctors: List<ModelListDoctors>
): RecyclerView.Adapter<AdapterListDoctors.MyviewHolder>() {
    class MyviewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var txtNamaDoktor : TextView = itemView.findViewById(R.id.txtNamaDoctor)
        var imgDoctor : ImageView = itemView.findViewById(R.id.imgDoctor)
        var imgBintang : ImageView = itemView.findViewById(R.id.imgBintang)
        var txtBidang : TextView = itemView.findViewById(R.id.txtBidang)
        var txtTotalReview : TextView = itemView.findViewById(R.id.txtJumlahReview)
        var txtTotalRating : TextView = itemView.findViewById(R.id.txtJumlahRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor,parent,false)
        return MyviewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemListDoctors.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem = itemListDoctors[position]
        holder.txtNamaDoktor.setText(currentItem.NamaDr)
        holder.imgDoctor.setImageResource(currentItem.ImageDr)
        holder.imgBintang.setImageResource(currentItem.ImageBintang)
        holder.txtBidang.setText(currentItem.BidangDr)
        holder.txtTotalRating.setText(currentItem.totalRating)
        holder.txtTotalReview.setText(currentItem.totalReview)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailDoctorActivity::class.java).apply {
                // Mengirim data melalui intent
                putExtra("namaDoctor", currentItem.NamaDr)
                putExtra("photoDoctor", currentItem.ImageDr)
                putExtra("ahli", currentItem.BidangDr)
                putExtra("review", currentItem.totalReview)
                putExtra("photoBintang", currentItem.ImageBintang)
                putExtra("rating", currentItem.totalRating)

            }
            context.startActivity(intent)
        }
    }
}