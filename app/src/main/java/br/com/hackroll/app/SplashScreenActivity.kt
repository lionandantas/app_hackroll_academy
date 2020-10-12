package br.com.hackroll.app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                finish()
                val intent = Intent()
                intent.setClass(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }, 4000)
    }
}
