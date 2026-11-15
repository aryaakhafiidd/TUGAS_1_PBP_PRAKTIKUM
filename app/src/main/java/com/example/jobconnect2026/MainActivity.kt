
package com.example.jobconnect2026

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_USIA = "extra_usia"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etUsia = findViewById<EditText>(R.id.etUsia)

        val btnKirim = findViewById<Button>(R.id.btnKirim)
        val btnInfo = findViewById<Button>(R.id.btnInfo)

        btnKirim.setOnClickListener {

            val nama = etNama.text.toString().trim()
            val usiaText = etUsia.text.toString().trim()

            if (nama.isEmpty()) {
                etNama.error = "Nama harus diisi"
                Toast.makeText(this, "Masukkan nama lengkap!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (usiaText.isEmpty()) {
                etUsia.error = "Usia harus diisi"
                Toast.makeText(this, "Masukkan usia!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usia = usiaText.toIntOrNull()

            if (usia == null || usia < 0) {
                etUsia.error = "Usia tidak valid"
                Toast.makeText(this, "Usia harus angka dan tidak boleh minus!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra(EXTRA_NAMA, nama)
            intent.putExtra(EXTRA_USIA, usia)

            startActivity(intent)
        }

        btnInfo.setOnClickListener {
            val url = "https://karirhub.kemnaker.go.id/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}
