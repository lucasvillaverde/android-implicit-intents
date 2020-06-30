package dev.lucasvillaverde.androidimplicitintents.examples

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.lucasvillaverde.androidimplicitintents.Constants
import dev.lucasvillaverde.androidimplicitintents.R
import kotlinx.android.synthetic.main.fragment_image_intent.*

class ImageIntentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_image_intent, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnOpen.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, Constants.REQUEST_LOAD_IMG)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == Constants.REQUEST_LOAD_IMG) {
            mainImg.setImageURI(data?.data)
            Toast.makeText(activity, "Img Loaded!", Toast.LENGTH_SHORT).show()
        }
    }
}