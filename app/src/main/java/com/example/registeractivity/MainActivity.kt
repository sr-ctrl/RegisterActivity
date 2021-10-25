package com.example.registeractivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.registeractivity.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val launcherData = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == Activity_Result.RESULT_CODE) {
                binding.tvResult.text = result.data?.getStringExtra(Activity_Result.SEND_DATA)
            }
        }
        binding.btnSendText.setOnClickListener {
            val intent = Intent(this@MainActivity, Activity_Result::class.java)
            launcherData.launch(intent)
        }
    }
}