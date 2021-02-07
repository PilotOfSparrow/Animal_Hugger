package com.anisimov.animalhugger

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.anisimov.animalhugger.ui.main.MainFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val fab: FloatingActionButton
        get() = findViewById(R.id.fab)

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

}
