
package com.example.jobconnect2026

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvHasil = findViewById<TextView>(R.id.tvHasil)
        val btnKembali = findViewById<Button>(R.id.btnKembali)

        val nama = intent.getStringExtra(MainActivity.EXTRA_NAMA)

        val usia = intent.getIntExtra(
            MainActivity.EXTRA_USIA, 0
        )

        tvHasil.text = "Halo ${nama}, usia Anda ${usia} tahun.\n\nPendaftaran berhasil!"

        btnKembali.setOnClickListener {
            finish()
        }
    }
}
