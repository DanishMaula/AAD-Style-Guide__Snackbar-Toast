package com.example.toastandsnackbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.toastandsnackbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.kishandonga.csbx.CustomSnackbar
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSnackbar.setOnClickListener {
            val sb = CustomSnackbar(this@MainActivity)
            sb.message("Snackbar clicked.")
            sb.padding(15)
            sb.cornerRadius(15f)
            sb.duration(Snackbar.LENGTH_LONG)
            sb.withAction(android.R.string.ok) { snackbar: Snackbar ->
                snackbar.dismiss()
                null
            }
            sb.show()
        }

        binding.btnToast.setOnClickListener {
            MotionToast.darkColorToast(this,"Delete all history!", "Deleted All",
                MotionToastStyle.DELETE,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this,R.font.helvetica_regular))

        }
    }
}