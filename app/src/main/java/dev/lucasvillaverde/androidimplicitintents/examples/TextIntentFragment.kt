package dev.lucasvillaverde.androidimplicitintents.examples

import android.content.Intent
import android.content.Intent.*
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dev.lucasvillaverde.androidimplicitintents.Constants
import dev.lucasvillaverde.androidimplicitintents.R
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
                action = ACTION_VIEW
                type = "vnd.android-dir/mms-sms"
                putExtra("sms_body", "${edtSendText.text}")
            }

            startActivity(intent)
        }
    }

}