package com.example.registeractivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.registeractivity.databinding.ActivityResultBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.tv_Result
import kotlinx.android.synthetic.main.activity_result.*

class Activity_Result : AppCompatActivity() {
    companion object{
        const val SEND_DATA = "RETRIEVE_DATA_KEY"
        const val RESULT_CODE = 100
    }
    private lateinit var binding:ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendResult.setOnClickListener {
            val input_text = binding.etInput.text.toString()
            setResult(
                RESULT_CODE,
                Intent().putExtra(SEND_DATA,input_text)
            )
            finish()
        }
        binding.tvResultText.text = intent.getStringExtra("Message")
    }
}