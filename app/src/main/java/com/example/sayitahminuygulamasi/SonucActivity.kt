package com.example.sayitahminuygulamasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sayitahminuygulamasi.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {
    lateinit var binding: ActivitySonucBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySonucBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sonuc=intent.getBooleanExtra("sonuc",false)
        if(sonuc==true){
            binding.imageViewSonuc.setImageResource(R.drawable.mutlu_resim)
            binding.textViewSonuc.text="KAZANDINIZ!"
        }else{
            binding.imageViewSonuc.setImageResource(R.drawable.uzgun_resim)
            binding.textViewSonuc.text="KAYBETTİNİZ!"
        }
        binding.buttonTekrar.setOnClickListener {
            val intent= Intent(this@SonucActivity,TahminActivity::class.java)
            finish()//back stackten sildim.
            startActivity(intent)
        }
    }
}