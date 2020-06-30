package dev.lucasvillaverde.androidimplicitintents.examples

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.content.Intent.EXTRA_TEXT
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
import kotlinx.android.synthetic.main.fragment_text_intent.*

class TextIntentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_text_intent, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSendText.setOnClickListener {
            val intent = Intent().apply {
                action = ACTION_SEND
                type = "text/plain"
                putExtra(EXTRA_TEXT, edtSendText.text)
            }

            startActivityForResult(intent, Constants.REQUEST_SEND_TEXT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == Constants.REQUEST_SEND_TEXT) {
            Toast.makeText(activity, "Text sent!", Toast.LENGTH_SHORT).show()
        }
    }

}