package com.example.projectmtd

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.developine.galleryapp.R

class SplashActivity : AppCompatActivity() {

        internal var SPLASH_TIME_OUT = 800

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_splash)

            Handler().postDelayed(
                {
                    // проверка того, что пользователь дал разрешение на доступ к накопителю.
                    // в противном случае запросим такое разрешение.
                    if (!checkSelfPermission()) {
                        requestPermission()
                    } else {
                        // если разрешение получено, загрузим изображения.
                        loadAllImages()
                    }
                }, SPLASH_TIME_OUT.toLong())
        }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 6036)
    }

    private fun checkSelfPermission(): Boolean {

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            return false
        } else
            return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


