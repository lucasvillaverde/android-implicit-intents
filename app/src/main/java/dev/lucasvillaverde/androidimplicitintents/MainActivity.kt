package dev.lucasvillaverde.androidimplicitintents

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2.ORIENTATION_HORIZONTAL
import dev.lucasvillaverde.androidimplicitintents.examples.ImageIntentFragment
import dev.lucasvillaverde.androidimplicitintents.examples.IntentTypesAdapter
import dev.lucasvillaverde.androidimplicitintents.examples.TextIntentFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val intentTypesAdapter = IntentTypesAdapter(supportFragmentManager, lifecycle)
    private val imageFragment = ImageIntentFragment()
    private val textFragment = TextIntentFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentTypesAdapter.addFragment(imageFragment)
        intentTypesAdapter.addFragment(textFragment)
        intentViewPager.adapter = intentTypesAdapter
        intentViewPager.orientation = ORIENTATION_HORIZONTAL

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Message Intent


        //
    }
}