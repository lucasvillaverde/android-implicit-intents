package dev.lucasvillaverde.androidimplicitintents

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import dev.lucasvillaverde.androidimplicitintents.examples.*
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator3

class MainActivity : AppCompatActivity() {

    private val intentTypesAdapter = IntentTypesAdapter(supportFragmentManager, lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragmentsToAdapter()
        intentViewPager.adapter = intentTypesAdapter
        intentViewPager.orientation = ORIENTATION_HORIZONTAL

        // Enabling and connecting the circle dots to our viewpager.
        indicator.setViewPager(intentViewPager)

    }

    private fun addFragmentsToAdapter() {
        intentTypesAdapter.addFragment(ImageIntentFragment())
        intentTypesAdapter.addFragment(TextIntentFragment())
        intentTypesAdapter.addFragment(WebIntentFragment())
        intentTypesAdapter.addFragment(MapIntentFragment())
    }
}