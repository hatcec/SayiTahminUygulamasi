package com.example.sayitahminuygulamasi

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sayitahminuygulamasi.databinding.ActivityTahminBinding
import kotlin.random.Random

class TahminActivity : AppCompatActivity() {
    lateinit var binding:ActivityTahminBinding
    private var rastgeleSayi=0
    private var sayac=5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTahminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rastgeleSayi= Random.nextInt(101)//0..100
        Log.e("rastgele sayi : ",rastgeleSayi.toString())

        binding.buttonTahmin.setOnClickListener {
           val tahmin=binding.editTextGirdi.text.toString().toInt()
            sayac--
            if(rastgeleSayi==tahmin){
                 val intent=Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuc", true)//tahmin goğru
                finish()
                 startActivity(intent)

                return@setOnClickListener//dongudeki break mantığı
            }
            if(rastgeleSayi>tahmin){
                binding.textViewYardim.text="ARTIR"
                binding.textViewKalanHak.text="Kalan Hak:$sayac"
            }
            if(rastgeleSayi<tahmin){
                binding.textViewYardim.text="AZALT"
                binding.textViewKalanHak.text="Kalan Hak:$sayac"
            }
            if(sayac==0){
                val intent=Intent(this@TahminActivity,SonucActivity::class.java)
                intent.putExtra("sonuc", false)//tahmin goğru
                finish()
                startActivity(intent)
            }
            binding.editTextGirdi.setText("")


        }
    }
}