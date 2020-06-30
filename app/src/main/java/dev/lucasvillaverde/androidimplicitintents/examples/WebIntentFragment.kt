package dev.lucasvillaverde.androidimplicitintents.examples

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dev.lucasvillaverde.androidimplicitintents.Constants
import dev.lucasvillaverde.androidimplicitintents.R
import kotlinx.android.synthetic.main.fragment_text_intent.*
import java.util.regex.Pattern

class WebIntentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_web_intent, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSendText.setOnClickListener {
            Log.d("WEB", "${edtSendText.text}")
            if (Pattern.matches("^(http|https)://\\S+", edtSendText.text.toString())) {
                val intent = Intent().apply {
                    action = ACTION_VIEW
                    data = Uri.parse("${edtSendText.text}")
                }

                startActivity(intent)
            } else
                Toast.makeText(activity, "Please, type a correct URL.", Toast.LENGTH_SHORT).show()

        }
    }
}